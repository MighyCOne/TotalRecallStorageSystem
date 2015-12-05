package com.eintern.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.eintern.orm.dao.HibernateGenericDAO;
import com.eintern.orm.dao.impl.HibernateGenericDAOImpl;
import com.eintern.orm.entity.Customer;
import com.eintern.orm.entity.Manager;

public class DeleteSomeoneAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		DynaActionForm addForm = (DynaActionForm) form;
		int theid = Integer.parseInt(addForm.getString("id"));
		String thetype = addForm.getString("type");
		
		//HttpSession session= request.getSession();
		HibernateGenericDAO dao= new HibernateGenericDAOImpl();
		
		if(thetype.equals("manager")){
			if(dao.retrieveById(Manager.class, theid)!=null){
				dao.delete(Manager.class, theid);
				return mapping.findForward("ds");
			}	
		}
		if (thetype.equals("customer")){
			if(dao.retrieveById(Customer.class, theid)!=null){
				System.out.println("Hi");
				dao.delete(Customer.class, theid);
			return mapping.findForward("ds");
			}
		}
		
			return mapping.findForward("df");
		
		
	}

}
