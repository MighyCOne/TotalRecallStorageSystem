package com.eintern.testing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.eintern.orm.dao.HibernateGenericDAO;
import com.eintern.orm.dao.impl.HibernateGenericDAOImpl;
import com.eintern.orm.entity.Customer;
import com.eintern.orm.entity.StorageUnit;
import com.eintern.orm.entity.Transaction;
import com.eintern.orm.entity.UserAuthorization;

public class TestingClass {

	public static void main(String[] args) {

		//setupTable();
		stockUnitTable();
		
	}

	private static void stockUnitTable() {
		HibernateGenericDAO dao= new HibernateGenericDAOImpl();
		StorageUnit unit1= new StorageUnit();
		unit1.setAvailable(true);
		dao.insert(unit1);
		
		StorageUnit unit2= new StorageUnit();
		unit2.setAvailable(true);
		dao.insert(unit2);
		
		StorageUnit unit3= new StorageUnit();
		unit3.setAvailable(true);
		dao.insert(unit3);
		
		StorageUnit unit4= new StorageUnit();
		unit4.setAvailable(true);
		dao.insert(unit4);
		
		StorageUnit unit5= new StorageUnit();
		unit5.setAvailable(true);
		dao.insert(unit5);
		
		StorageUnit unit6= new StorageUnit();
		unit6.setAvailable(true);
		dao.insert(unit6);
		
		StorageUnit unit7= new StorageUnit();
		unit7.setAvailable(true);
		dao.insert(unit7);
		
		StorageUnit unit8= new StorageUnit();
		unit8.setAvailable(true);
		dao.insert(unit8);
		
		StorageUnit unit9= new StorageUnit();
		unit9.setAvailable(true);
		dao.insert(unit9);
		
		StorageUnit unit10= new StorageUnit();
		unit10.setAvailable(true);
		dao.insert(unit10);
	}

	private static void setupTable(){
		Date date= new Date();
		//Might be better off letting date be a string, so I can insert it as one using DateFormat
		DateFormat df= new SimpleDateFormat("MM/yyyy/dd HH:mm:ss");
		System.out.println(df.format(date));
		
		
		HibernateGenericDAO dao=new HibernateGenericDAOImpl();
		UserAuthorization user=new UserAuthorization();
		user.setUsername("keyun");
		user.setPassword("123");
		user.setType("customer");
		dao.insert(user);
		
		Customer cust=new Customer();
		cust.setCustName("Keyun");
		cust.setCustEmail("k@c.com");
		cust.setUserAuth(user);
		dao.insert(cust);
		StorageUnit unit= new StorageUnit();
		
		Transaction trans1=new Transaction();
		trans1.setDollarAmount(10);
		trans1.setCustomer(cust);
		trans1.setDateEntered(date);
		//Set<Transaction> transactions= new HashSet<Transaction>();
		
		
		
		
		dao.insert(trans1);
		//dao.delete(UserAuthorization.class,171);
	}
}
