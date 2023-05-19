package com.hiber.Service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hiber.Entity.Mobile;
import com.hiber.Entity.Person;
import com.hiber.util.Hibernateutil;

public class PersonServiceImpl implements PersonDao {

	public List<Mobile> getMobiles() {
		Transaction tx = null;
		Session session = null;

		List<Mobile> mobiles = null;
		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			String hql = "from Mobile";
			Query<Mobile> mobile = session.createQuery(hql);
			mobiles = mobile.list();
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();

		} finally {
			if (tx != null) {
				session.close();
			}
		}

		return mobiles;
	}

	public List<Person> getPerson() {
		Transaction tx = null;
		Session session = null;

		List<Person> persons = null;
		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			String hql = "from Person";
			Query<Person> person = session.createQuery(hql);
			persons = person.list();
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();

		} finally {
			if (tx != null) {
				session.close();
			}
		}

		return persons;

	}

	public void saveMobile(Mobile mob) {
		Transaction tx = null;
		Session session = null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(mob);

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();

		} finally {
			if (tx != null) {
				session.close();
			}
		}

	}

	public void savePerson(Person per) {
		Transaction tx = null;
		Session session = null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(per);
			tx.commit();
		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();

		} finally {
			if (tx != null) {
				session.close();
			}
		}

	}

	public void deletePerson(Long Id) {
		Transaction tx = null;
		Session session = null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Person per = session.get(Person.class, Id);
			session.delete(per);
			tx.commit();
		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();

		} finally {
			if (tx != null) {
				session.close();
			}
		}
	}

	public void deleteMobile(Long Id) {
		Transaction tx = null;
		Session session = null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Mobile mob = session.get(Mobile.class, Id);
			session.delete(mob);
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();

		} finally {
			if (tx != null) {
				session.close();
			}
		}
	}

	public void updateMobile(Mobile mob, Long Id) {
		Transaction tx = null;
		Session session = null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Mobile mobile = session.get(Mobile.class, Id);
			System.out.println(mobile.getBrand());
			mobile.setBrand(mob.getBrand());
			mobile.setCost(mob.getCost());
			mobile.setModel(mob.getModel());
			mobile.setPerson(mob.getPerson());
			session.update(mobile);
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();

		} finally {
			if (tx != null) {
				session.close();
			}
		}
	}

	public void updatePerson(Person per, Long Id) {
		Transaction tx = null;
		Session session = null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Person person = session.get(Person.class, Id);
			person.setName("V Raju");
			person.setMobile(per.getMobile());

			session.update(person);
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();

		} finally {
			if (tx != null) {
				session.close();
			}
		}
	}

	public Mobile getMobileById(Long Id) {
		Transaction tx = null;
		Session session = null;

		Mobile mobile = null;
		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			mobile = session.get(Mobile.class, Id);

			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();

		} finally {
			if (tx != null) {
				session.close();
			}
		}
		return mobile;
	}

	public Person getPersonById(Long Id) {
		Transaction tx = null;
		Session session = null;
		Person person = null;
		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			person = session.get(Person.class, Id);

			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();

		} finally {
			if (tx != null) {
				session.close();
			}
		}
		return person;
	}

	public List<Mobile> getMobileByPersonId(Long Id) {
		Transaction tx = null;
		Session session = null;
		List<Mobile> mobileData = null;
		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			String hql = "FROM Mobile m WHERE m.person.id = :personId";
			Query<Mobile> query = session.createQuery(hql, Mobile.class);
			query.setParameter("personId", Id);
			
			mobileData = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();

		} finally {
			if (tx != null) {
				session.close();
			}
		}
		return mobileData;
	}

}
