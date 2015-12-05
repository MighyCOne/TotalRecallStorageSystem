package com.eintern.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.eintern.orm.dao.HibernateGenericDAO;
import com.eintern.orm.dao.impl.HibernateGenericDAOImpl;
import com.eintern.orm.entity.Customer;

public class CustomerStatusAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HibernateGenericDAO dao= new HibernateGenericDAOImpl();
		
		HttpSession session= request.getSession();
		
		Customer customer = (Customer) session.getAttribute("customer_object");
		
		
		customer.setBuying_status(!customer.isBuying_status());
		
		
		session.setAttribute("current_status", customer.isBuying_status());
		
		dao.update(customer);
		
		return mapping.findForward("cstatus");
	}

}
