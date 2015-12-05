package com.eintern.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.eintern.orm.dao.HibernateGenericDAO;
import com.eintern.orm.dao.impl.HibernateGenericDAOImpl;
import com.eintern.orm.entity.Customer;
import com.eintern.orm.entity.UserAuthorization;

public class AddNewCustomerAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm addForm = (DynaActionForm) form;
		String custname = (String) addForm.get("name");
		String custemail = (String) addForm.get("email");
		String username = (String) addForm.get("username");
		String password = (String) addForm.get("password");
		String type = (String) addForm.get("type");

		UserAuthorization userA = new UserAuthorization();
		userA.setUsername(username);
		userA.setPassword(password);
		userA.setType(type);

		Customer cust = new Customer();
		cust.setCustName(custname);
		cust.setCustEmail(custemail);
		cust.setUserAuth(userA);

		HibernateGenericDAO dao = new HibernateGenericDAOImpl();

		if (dao.insert(cust)) {

			return mapping.findForward("go_addUser");
		} else {
			return  mapping.findForward("go_addFailed");
		}

	}
}
