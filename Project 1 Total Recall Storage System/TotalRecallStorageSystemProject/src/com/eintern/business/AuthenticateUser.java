package com.eintern.business;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.eintern.orm.dao.HibernateGenericDAO;
import com.eintern.orm.dao.impl.HibernateGenericDAOImpl;
import com.eintern.orm.entity.UserAuthorization;

public class AuthenticateUser extends HibernateGenericDAOImpl {
	
	public boolean authenticateUser(String theusername, String thepassword, String thetype) {
		UserAuthorization user=new UserAuthorization();
		Criteria criteria= session.createCriteria(UserAuthorization.class)
				.add(Restrictions.eq("username", theusername))
				.add(Restrictions.eq("password", thepassword))
				.add(Restrictions.eq("type", thetype));
						
		List data = criteria.list();

		System.out.println(data);

		if (data.size() == 0)
			return false;
		else
			return true;
	}
}
