package com.eintern.business;

import java.util.List;
import java.util.Set;

import com.eintern.orm.dao.HibernateGenericDAO;
import com.eintern.orm.dao.impl.HibernateGenericDAOImpl;
import com.eintern.orm.entity.Customer;
import com.eintern.orm.entity.StorageUnit;
import com.eintern.orm.entity.Transaction;

public class DailyUpdateCountdown {

	public void countdown() {

		MoneyHandler money = new MoneyHandler();

		HibernateGenericDAO dao = new HibernateGenericDAOImpl();

		List list = dao.retrieveAll(StorageUnit.class);

		for (StorageUnit unit : (List<StorageUnit>) list) {

			int time_remaining = unit.getTimeRemaining();

			Set<Transaction> transactionSet = unit.getTransaction();

			if (unit.getTimeRemaining() == 0 && (unit.isAvailable() == false)) {
				
				for (Transaction trans : transactionSet) {

					double late_fee = money.getLATE_FEE();

					trans.setDollarAmount(-late_fee);
					
					Customer customer = trans.getCustomer();
					//the if statement is new 
					if(customer.getCustBalance()==0){
						unit.setTimeRemaining(money.getTime_remaining());
					}
					else{
					customer.setCustBalance(customer.getCustBalance() + late_fee);
					}
					dao.update(trans);
					
					
				}
			}

			else if (time_remaining > 0 && (unit.isAvailable() == false)) {

				unit.setTimeRemaining(time_remaining - 1);

				System.out.println("Test:>=0 and false");
				
				dao.update(unit);

			}

			
		}

	}
}
