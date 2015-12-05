package com.eintern.action;

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
import com.eintern.orm.entity.Transaction;

public class DeleteTransactionAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MoneyHandler money = new MoneyHandler();

		DynaActionForm addForm = (DynaActionForm) form;
		int theid = Integer.parseInt(addForm.getString("id"));

		HibernateGenericDAO dao = new HibernateGenericDAOImpl();

		if (dao.retrieveById(Transaction.class, theid) != null) {
			Transaction trans = (Transaction) dao.retrieveById(Transaction.class, theid);
			trans.getStorageunit().setAvailable(true);
			trans.getStorageunit().setTimeRemaining(money.getTime_remaining());
			dao.update(trans.getStorageunit());
			dao.delete(Transaction.class, theid);

			return mapping.findForward("ds");

		}
		return mapping.findForward("df");
	}
}
