package com.code.HibernateCrudOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.code.entities.Employee;

public class App {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("/com/code/config/hibernate.config.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// -------- INSERT OPERATION -----------//
		// INSERT METHODS --> save() & persist()

		/*
		 * try { session.save(new Employee("john sameul", "L1 Support", "Manager"));
		 * session.save(new Employee("Cibin Lukose", "RPA INFRA", "Associate Manager"));
		 * transaction.commit(); System.out.println("Employee added into DB...."); }
		 * catch (Exception e) { transaction.rollback();
		 * System.out.println("Something went wrong.."); e.printStackTrace(); }
		 */

		// -------- GET EMPLOYEE BY ID OPERATION -----------//
		// SELECT METHODS --> get() & load()
		/*
		 * try {
		 * 
		 * Employee emp1 = session.get(Employee.class, 1L); System.out.println(emp1); }
		 * catch (Exception e) { transaction.rollback();
		 * System.out.println("Something went wrong.."); e.printStackTrace(); }
		 */

		// -------- UPDATE OPERATION -----------//
		// UPDATE METHODS --> saveOrUpdate() & update()
		/*
		 * try {
		 * 
		 * Employee emp1 = session.get(Employee.class, 2L); emp1.setEmpRole("L1 Lead");
		 * transaction.commit();
		 * System.out.println("Employee details updated successfully......"); } catch
		 * (Exception e) { transaction.rollback();
		 * System.out.println("Something went wrong.."); e.printStackTrace(); }
		 */

		// -------- DELETE OPERATION -----------//
		// DELETE METHODS --> delete()

		try {

			Employee emp1 = session.get(Employee.class, 2L);
			session.delete(emp1);
			transaction.commit();
			System.out.println("Employee deleted successfully......");
		} catch (Exception e) {
			transaction.rollback();
			System.out.println("Something went wrong..");
			e.printStackTrace();
		}

	}
}
