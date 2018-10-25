package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



public class GenericDAO<T> {

	private Class<T> klass;

	public GenericDAO(Class<T> klass) {
		this.klass = klass;
	}

	public T find(long l) {
		EntityManager em = DatabaseHelper.createEntityManager();
		T findClient = em.find(klass, l);
		return findClient;
	}

	public List<T> findAll() {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		List<T> listT = null;
		try {
			TypedQuery<T> query = em.createQuery("from " + klass.getName() + " k ", klass);
			listT = query.getResultList();

		} catch (Exception e) {
			DatabaseHelper.rollbackTxAndClose(em);
			e.printStackTrace();
		}
		return listT;
	}

	public T persist(T klass) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		try {
			em.persist(klass);
			DatabaseHelper.commitTxAndClose(em);
		} catch (Exception e) {
			DatabaseHelper.rollbackTxAndClose(em);
			e.printStackTrace();
		}
		return klass;
	}

	public T merge(T klass){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		try {
			em.merge(klass);
			DatabaseHelper.commitTxAndClose(em);
		}catch(Exception e) {
			DatabaseHelper.rollbackTxAndClose(em);
			e.printStackTrace();
		}
		return klass;
	}
	
	public void remove(T klass){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		try {
			em.remove(em.contains(klass) ? klass : em.merge(klass));
			DatabaseHelper.commitTxAndClose(em);
		}catch(Exception e) {
			DatabaseHelper.rollbackTxAndClose(em);
			e.printStackTrace();
		}
	}
	
	
}
