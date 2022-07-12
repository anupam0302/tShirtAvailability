package com.nagarro.tshirt.availability.file.parser;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.tshirt.availability.hibernate.utilities.HibernateConnector;
import com.nagarro.tshirt.availability.model.TShirt;

public class FileParser extends Thread {

	@Override
	public void run() {
		try {

			String resourceFolderPath = new File("").getAbsolutePath() + "/src/test/resources";

			while (true) {

				File resourceFolder = new File(resourceFolderPath);
				File[] totalFiles = resourceFolder.listFiles();
				Session session = HibernateConnector.sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				for (int j = 0; j < totalFiles.length; j++) {
					String path = totalFiles[j].getAbsolutePath();
					Reader reader = new FileReader(path);
					CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL);
					List<CSVRecord> csvRecords = csvParser.getRecords();

					String str = csvRecords.get(0).get(0);
					String[] headers = str.split("\\|");

					for (int i = 1; i < csvRecords.size(); i++) {
						String[] tshirtAttributes = csvRecords.get(i).get(0).split("\\|");
						session.save(new TShirt(tshirtAttributes[0], tshirtAttributes[1], tshirtAttributes[2],
								tshirtAttributes[3], tshirtAttributes[4], Double.parseDouble(tshirtAttributes[5]),
								Double.parseDouble(tshirtAttributes[6]), tshirtAttributes[7]));
						

					}
					csvParser.close();

				}
				transaction.commit();
				session.close();
				Thread.sleep(300000);

			}
		} catch (Exception e) {
			System.out.println("*******" + e.getMessage() + "*******");
//			e.printStackTrace();
		}

	}
}
