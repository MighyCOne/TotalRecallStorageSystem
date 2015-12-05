package com.eintern.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.eintern.orm.dao.impl.AppDAOImpl;
import com.eintern.orm.entity.Customer;
import com.eintern.orm.entity.Transaction;

public class ViewMyUnitsAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// AppDAOImpl appdao = new AppDAOImpl();

		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer_object");

		// Not getting failure out. Check up on it

		Set<Transaction> transactions;

		if (customer.getTransaction() == null) {

			return mapping.findForward("go_viewAUFailure");

		} else {
			transactions = customer.getTransaction();
			session.setAttribute("tset", transactions);

			for (Transaction transaction : customer.getTransaction()) {
				transaction.getStorageunit().getUnitId();

			}
			return mapping.findForward("go_viewAUSuccess");
		}
	}
}
