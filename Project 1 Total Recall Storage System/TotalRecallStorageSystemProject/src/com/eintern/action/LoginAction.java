package com.eintern.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

import com.eintern.business.AuthenticateUser;
import com.eintern.orm.dao.impl.AppDAOImpl;
import com.eintern.orm.entity.Customer;
import com.eintern.orm.entity.UserAuthorization;

public class LoginAction extends DispatchAction {

	public ActionForward customer(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm loginForm = (DynaActionForm) form;

		String username = (String) loginForm.get("username");
		String password = (String) loginForm.get("password");
		String usertype = loginForm.getString("type");

		AuthenticateUser authen = new AuthenticateUser();
		
		
		System.out.println("customer");
		
		
		if (authen.authenticateUser(username, password, usertype)) {

			AppDAOImpl appdao = new AppDAOImpl();

			UserAuthorization user = (UserAuthorization) appdao.retrieveByUsername(UserAuthorization.class, username);

			HttpSession session = request.getSession();

			session.setAttribute("customer_name", user.getCustomer().getCustName());
			session.setAttribute("customer_object", user.getCustomer());

			return mapping.findForward("c_portal");
		} else {
			return mapping.findForward("failure");
		}
	}

	public ActionForward manager(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm loginForm = (DynaActionForm) form;

		String username = (String) loginForm.get("username");
		String password = (String) loginForm.get("password");
		String usertype = loginForm.getString("type");

		AuthenticateUser authen = new AuthenticateUser();
		
		
		System.out.println("manager");
		
		
		if (authen.authenticateUser(username, password, usertype)) {

			AppDAOImpl appdao = new AppDAOImpl();

			// If I add back in the manager table, I'll be be getting the
			// manager name the same way I got the customre name. Maybe even log
			// their actions.
			
			 UserAuthorization user=(UserAuthorization)appdao.retrieveByUsername(UserAuthorization.class, username);
			 
			 HttpSession session=request.getSession();
			 
			 session.setAttribute("manager_name", user.getManager().getManaName());			 

			return mapping.findForward("m_portal");
		} else {
			return mapping.findForward("failure");
		}
	}
}
