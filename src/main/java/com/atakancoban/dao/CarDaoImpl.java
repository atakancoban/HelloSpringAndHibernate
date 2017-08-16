package com.atakancoban.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.atakancoban.dao.CarDao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("carDao")
public class CarDaoImpl implements CarDao, Serializable {

	private SessionFactory sessionFactory;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1677161902821079349L;

	@Override
	public List<String> getCarDetails() {

		List<String> cars = new ArrayList<String>();

		cars.add(0, "LAMBORGHINI");
		cars.add(1, "BENTLEY");
		cars.add(2, "MASERATI");
		cars.add(3, "JAGUAR");
		cars.add(4, "MITSUBISHI");
		cars.add(5, "MERCEDES-BENZ");
		return cars;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String getSystemTime() throws Exception {
		String result = null;
		try {

			Session session = getSessionFactory().getCurrentSession();
			String sql = "select to_char(sysdate,'dd.mm.yyyy hh24:mi:ss') zmn from dual";
			SQLQuery query = (SQLQuery) session.createSQLQuery(sql);
			if (query.uniqueResult() != null)
				result = query.uniqueResult().toString();
			else
				result = "deger boş";
		} catch (Exception e) {
			throw new Exception("getSystemTime() error. " + e.getMessage(), e);
		}

		return result;
	}

}
