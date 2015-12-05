package com.eintern.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.eintern.orm.dao.HibernateGenericDAO;
import com.eintern.orm.dao.impl.AppDAOImpl;
import com.eintern.orm.dao.impl.HibernateGenericDAOImpl;
import com.eintern.orm.entity.StorageUnit;


public class ViewUnitsAction extends DispatchAction{
		

	public ActionForward viewAllUnits(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HibernateGenericDAO dao=new HibernateGenericDAOImpl();
		System.out.println("hi");
		List list=dao.retrieveAll(StorageUnit.class);
		System.out.println("bye");

		//Could have also used the Iterator class but I chose not to.
		HttpSession session=request.getSession();

		session.setAttribute("au", list);	
		
		return mapping.findForward("go_vAllUnits");
	}
	public ActionForward viewAssignedUnits(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AppDAOImpl appdao= new AppDAOImpl();
		List list=appdao.retrieveAssignedOrAvailableUnits(StorageUnit.class,false);

		//Could have also used the Iterator class but I chose not to.
		HttpSession session=request.getSession();

		session.setAttribute("assigned_units", list);	
		
		return mapping.findForward("go_vAssigned");
	}
	public ActionForward viewAvailableUnits(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AppDAOImpl appdao= new AppDAOImpl();
		List list=appdao.retrieveAssignedOrAvailableUnits(StorageUnit.class,true);

		//Could have also used the Iterator class but I chose not to.
		HttpSession session=request.getSession();

		session.setAttribute("available_units", list);	
		
		return mapping.findForward("go_vAvailable");
	}

}
