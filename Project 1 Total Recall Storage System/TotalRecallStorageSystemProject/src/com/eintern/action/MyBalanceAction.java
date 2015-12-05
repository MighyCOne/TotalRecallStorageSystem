package com.eintern.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.eintern.orm.entity.Customer;

public class MyBalanceAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer_object");
		double mybalance=customer.getCustBalance();
				
				session.setAttribute("my_balance", mybalance);
		
		return mapping.findForward("mb");
	}
}
