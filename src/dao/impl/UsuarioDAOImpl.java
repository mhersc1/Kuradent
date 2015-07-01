package dao.impl;

// Generated 17/06/2015 01:54:27 PM by Hibernate Tools 3.4.0.CR1

import hibernate.HibernateUtil;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import bean.Usuario;
import dao.inf.UsuarioDAO;

/**
 * Home object for domain model class Usuario.
 * @see impl.Usuario
 * @author Hibernate Tools
 */
public class UsuarioDAOImpl implements UsuarioDAO {

	private static final Log log = LogFactory.getLog(UsuarioDAOImpl.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Usuario transientInstance) {
		log.debug("persisting Usuario instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Usuario instance) {
		log.debug("attaching dirty Usuario instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Usuario instance) {
		log.debug("attaching clean Usuario instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Usuario persistentInstance) {
		log.debug("deleting Usuario instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Usuario merge(Usuario detachedInstance) {
		log.debug("merging Usuario instance");
		try {
			Usuario result = (Usuario) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Usuario findById(long id) {
		log.debug("getting Usuario instance with id: " + id);
		try {
			Usuario instance = (Usuario) sessionFactory.getCurrentSession()
					.get("impl.Usuario", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Usuario instance) {
		log.debug("finding Usuario instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("impl.Usuario")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@Override
	public Integer login(String usuario, String password, Integer sistema) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();

		String existsUser	=	"from Usuario where usuario = '"+usuario+"'";
		String passValid	=	"from Usuario where usuario = '"+usuario+"' and contrasenia = '"+password+"'";
		
		Integer codigo = -1;
		try
		{
			Query query1 =	session.createQuery(existsUser);
			Object bean 	=	query1.uniqueResult();
			
			if(bean != null)
			{	
				Query query2 = session.createQuery(passValid);
				Usuario user = (Usuario) query2.uniqueResult();
				
				if (user != null) {
					
					codigo = 0;//Usuario Autorizado

				}else
				{
					codigo = 2;
				}
			}else
			{
				codigo =	1;//Usuario no registrado
			}
		}catch(HibernateException e)
		{
				codigo =	5;
		}
		
		return codigo;
	}
	
}
