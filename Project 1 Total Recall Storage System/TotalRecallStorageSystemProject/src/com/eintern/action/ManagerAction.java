package com.eintern.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.eintern.business.DailyUpdateCountdown;
import com.eintern.orm.dao.HibernateGenericDAO;
import com.eintern.orm.dao.impl.HibernateGenericDAOImpl;
import com.eintern.orm.entity.Customer;
import com.eintern.orm.entity.Manager;
import com.eintern.orm.entity.StorageUnit;
import com.eintern.orm.entity.Transaction;

public class ManagerAction extends DispatchAction {

	public ActionForward viewCustomerTransaction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HibernateGenericDAO dao = new HibernateGenericDAOImpl();
		List list = dao.retrieveAll(Transaction.class);

		// Could have also used the Iterator class but I chose not to.
		HttpSession session = request.getSession();

		session.setAttribute("all_transactions", list);

		return mapping.findForward("go_vct");
	}

	public ActionForward viewAllCustomerBalances(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HibernateGenericDAO dao = new HibernateGenericDAOImpl();
		List list=dao.retrieveAll(Customer.class);
		
		HttpSession session = request.getSession();
		session.setAttribute("all_customers", list);
		
		return mapping.findForward("view_all_cust");
	}
	
	public ActionForward viewAllManagers(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HibernateGenericDAO dao = new HibernateGenericDAOImpl();
		List list=dao.retrieveAll(Manager.class);
		
		HttpSession session = request.getSession();
		session.setAttribute("all_managers", list);
		
		return mapping.findForward("vam");
	}
	
	public ActionForward dailyUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		DailyUpdateCountdown du=new DailyUpdateCountdown();
		du.countdown();

		return mapping.findForward("go_du");
	}
	
	public ActionForward addNewStorageUnit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HibernateGenericDAO dao = new HibernateGenericDAOImpl();
		
		StorageUnit unit=new StorageUnit();
		unit.setAvailable(true);
		
		List list=dao.retrieveAll(StorageUnit.class);
		
	
	HttpSession session= request.getSession();
	session.setAttribute("unit_amount", list.size());
	
		
		dao.insert(unit);
		
		return mapping.findForward("go_ansu");
	}
	

}
