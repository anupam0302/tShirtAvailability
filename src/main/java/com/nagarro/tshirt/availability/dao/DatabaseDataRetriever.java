package com.nagarro.tshirt.availability.dao;

import java.util.ArrayList;

import org.hibernate.Session;

import com.nagarro.tshirt.availability.hibernate.utilities.HibernateConnector;
import com.nagarro.tshirt.availability.model.TShirt;
import com.nagarro.tshirt.availability.model.UserInput;

public class DatabaseDataRetriever {
	public ArrayList<TShirt> retrieveData(UserInput userInput) {
		Session session = HibernateConnector.sessionFactory.openSession();
		ArrayList<TShirt> tShirts = (ArrayList<TShirt>) session.createQuery(
				"from tshirt where color='" + userInput.getColor() + "' and gender='" + userInput.getGender() + "' and size='"+userInput.getSize()+"'",
				TShirt.class).getResultList();
		session.close();
		return tShirts;

	}
}
