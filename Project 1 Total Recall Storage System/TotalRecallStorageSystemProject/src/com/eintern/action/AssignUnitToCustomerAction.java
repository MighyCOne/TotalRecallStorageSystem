package com.eintern.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.eintern.business.MoneyHandler;
import com.eintern.orm.dao.HibernateGenericDAO;
import com.eintern.orm.dao.impl.HibernateGenericDAOImpl;
import com.eintern.orm.entity.Customer;
import com.eintern.orm.entity.StorageUnit;
import com.eintern.orm.entity.Transaction;

public class AssignUnitToCustomerAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		MoneyHandler money = new MoneyHandler();

		DynaActionForm assignForm = (DynaActionForm) form;
		int customerId = Integer.parseInt(assignForm.getString("custId"));
		int unitId = Integer.parseInt(assignForm.getString("storageId"));

		Customer customer;
		StorageUnit unit;
		HibernateGenericDAO dao = new HibernateGenericDAOImpl();

		if (dao.retrieveById(Customer.class, customerId) == null
				|| dao.retrieveById(StorageUnit.class, unitId) == null) {
			return mapping.findForward("go_assignUCFailureNull");

		}

		customer = (Customer) dao.retrieveById(Customer.class, customerId);
		unit = (StorageUnit) dao.retrieveById(StorageUnit.class, unitId);

		if (unit.isAvailable() == false) {
			return mapping.findForward("go_assignUCFailureNotAvailable");
		}
		if( customer.isBuying_status()==false){
			return mapping.findForward("not_buying");
		}

		double balance = money.getSTORAGE_PRICE();
		double current_balance = customer.getCustBalance();
		double new_balance = current_balance + balance;
		int storage_time = money.getTime_remaining();
		
		customer.setCustBalance(new_balance);
		customer.setBuying_status(false);
		unit.setUnitId(unitId);
		unit.setAvailable(false);
		unit.setTimeRemaining(storage_time);

		Date date = new Date();

		Transaction transaction = new Transaction();
			transaction.setCustomer(customer);
			transaction.setStorageunit(unit);
			transaction.setDateEntered(date);
			transaction.setDollarAmount(-balance);

		if (dao.insert(transaction)) {
			
			return mapping.findForward("go_assignUCSuccess");
		} else {
			return mapping.findForward("go_assignUCFailure");
		}

	}

}
