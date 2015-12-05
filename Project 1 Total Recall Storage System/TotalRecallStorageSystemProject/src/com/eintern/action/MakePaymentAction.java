package com.eintern.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.eintern.business.MoneyHandler;
import com.eintern.orm.dao.HibernateGenericDAO;
import com.eintern.orm.dao.impl.HibernateGenericDAOImpl;
import com.eintern.orm.entity.Customer;
import com.eintern.orm.entity.Transaction;

public class MakePaymentAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm paymentForm = (DynaActionForm) form;

		int customerpayment = Integer.parseInt(paymentForm.getString("payment"));

		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer_object");
		double newBalance = customer.getCustBalance() - customerpayment;

		if (newBalance >= 0) {
			HibernateGenericDAO dao= new HibernateGenericDAOImpl();
						
			customer.setCustBalance(newBalance);
			
			
			for(Transaction transaction:customer.getTransaction()){
				transaction.setDollarAmount(customerpayment);
				dao.update(transaction);
			}
			//dao.update(customer);
			session.setAttribute("balance", newBalance);
			
			return mapping.findForward("success_payment");
			
		} else {
			
			return mapping.findForward("failed_payment");
			
		}
	}

}
