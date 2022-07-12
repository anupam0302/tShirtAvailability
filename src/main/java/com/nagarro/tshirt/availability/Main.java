package com.nagarro.tshirt.availability;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.nagarro.tshirt.availability.dao.DatabaseDataRetriever;
import com.nagarro.tshirt.availability.exceptions.DataNotFoundException;
import com.nagarro.tshirt.availability.exceptions.InvalidInputException;
import com.nagarro.tshirt.availability.file.parser.FileParser;
import com.nagarro.tshirt.availability.hibernate.utilities.HibernateConnector;
import com.nagarro.tshirt.availability.input.InputReader;
import com.nagarro.tshirt.availability.input.ScannerFactory;
import com.nagarro.tshirt.availability.model.TShirt;
import com.nagarro.tshirt.availability.model.UserInput;
import com.nagarro.tshirt.availability.output.OutputHandler;
import com.nagarro.tshirt.availability.tshirt.service.DataSorter;

public class Main {

	public static void main(String[] args) throws InvalidInputException, DataNotFoundException {
		Scanner scanner = ScannerFactory.getScanner();
		InputReader inputReader = new InputReader();
		SessionFactory sessionFactory = HibernateConnector.hibernateSession();
		FileParser fileParser = new FileParser();
		fileParser.start();
		DataSorter dataSorter = new DataSorter();
		OutputHandler output = new OutputHandler();
		DatabaseDataRetriever databaseDataRetriever = new DatabaseDataRetriever();
		while (true) {
			UserInput userInput = inputReader.inputVariables();
			ArrayList<TShirt> tShirts = databaseDataRetriever.retrieveData(userInput);
			ArrayList<TShirt> sortedTShirts = dataSorter.sortData(userInput.getOutputPreference(), tShirts);
			output.printOutput(sortedTShirts);

			System.out.println("Do you want to search again? (y/n)");
			String continueOrNot = scanner.next().toLowerCase().trim();
			if ("y".equals(continueOrNot)) {
				continue;
			} else if ("n".equals(continueOrNot)) {
				break;
			} else {
				throw new InvalidInputException("Entry should be either y or n. Anything else will not be entertained");
			}
		}
		ScannerFactory.closeScanner();
		HibernateConnector.closeSessionFactory();
		fileParser.interrupt();
	}
}
