package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.entidades.Livro;
import br.com.jpautil.Jpautil;

public class DaoGeneric<E> {
	
	public void salvar(Livro livro) {
		EntityManager entityManager = Jpautil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(livro);
		entityTransaction.commit();
		entityManager.close();	                           
	}
	
	public Livro merge(Livro livro) {
		EntityManager entityManager = Jpautil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Livro retorno = entityManager.merge(livro);
		entityTransaction.commit();
		entityManager.close();	
		
		return retorno;
	}
	
	public void deletePorId(Livro livro) {
		EntityManager entityManager = Jpautil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Object id = Jpautil.getPrimaryKey(livro);
		entityManager.createQuery("Delete from " + livro.getClass().getCanonicalName() + " where id = " + id).executeUpdate();
		entityTransaction.commit();
		entityManager.close();	                           
	}
	
	public List<E> getListEntity(Class<Livro> l) {
		EntityManager entityManager = Jpautil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		List<E> retorno = entityManager.createQuery("from " + l.getName()).getResultList();
		
		entityTransaction.commit();
		entityManager.close();	 
		
		return retorno;
	}

}
