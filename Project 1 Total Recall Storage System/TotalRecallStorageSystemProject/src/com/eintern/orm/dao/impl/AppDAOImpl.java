package com.eintern.orm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class AppDAOImpl<T> extends HibernateGenericDAOImpl<T> {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> retrieveAssignedOrAvailableUnits(Class<T> c, boolean availability) {

		try {
			Criteria criteria = session.createCriteria(c).add(Restrictions.like("isAvailable", availability));
			List<T> data = criteria.list();

			return data;
		} catch (HibernateException he) {
			he.printStackTrace();
			return null;
		}
	}
//Maybe I can make this generic by making the string a type p.
	public T retrieveByUsername(Class<T> c, String somename) {

				try {
					T t = (T) session.get(c, somename);
					return t;
		} catch (HibernateException he) {
			he.printStackTrace();
			return null;
		}
				
	}
}
