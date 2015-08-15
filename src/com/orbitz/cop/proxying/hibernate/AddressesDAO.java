package com.orbitz.cop.proxying.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Addresses entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.orbitz.cop.proxying.hibernate.Addresses
 * @author MyEclipse Persistence Tools
 */
public class AddressesDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(AddressesDAO.class);
	// property constants
	public static final String ADDRESS = "address";

	public void save(Addresses transientInstance) {
		log.debug("saving Addresses instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Addresses persistentInstance) {
		log.debug("deleting Addresses instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Addresses findById(java.lang.Integer id) {
		log.debug("getting Addresses instance with id: " + id);
		try {
			Addresses instance = (Addresses) getSession().get(
					"com.orbitz.cop.proxying.hibernate.Addresses", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Addresses instance) {
		log.debug("finding Addresses instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.orbitz.cop.proxying.hibernate.Addresses")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Addresses instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Addresses as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findAll() {
		log.debug("finding all Addresses instances");
		try {
			String queryString = "from Addresses";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Addresses merge(Addresses detachedInstance) {
		log.debug("merging Addresses instance");
		try {
			Addresses result = (Addresses) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Addresses instance) {
		log.debug("attaching dirty Addresses instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Addresses instance) {
		log.debug("attaching clean Addresses instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}