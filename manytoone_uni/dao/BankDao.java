package manytoone_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytoone_uni.dto.Bank;

public class BankDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("radha");
		return entityManagerFactory.createEntityManager();
		
	}
	
	public void saveBank(Bank bank) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(bank);
		entityTransaction.commit();
	}
	
	public void updateBank(int id,Bank bank) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Bank b=  entityManager.find(Bank.class, id);
		if(b!=null) {
			bank.setId(id);
			
		
		
		entityTransaction.begin();
		entityManager.merge(bank);
		entityTransaction.commit();
		}
	}
	
	public void deleteBank(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Bank b=  entityManager.find(Bank.class, id);
		if(b!=null) {
		
		
		entityTransaction.begin();
		entityManager.remove(b);
		entityTransaction.commit();
		}
	}
	
	public void displayBank(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Bank b=  entityManager.find(Bank.class, id);
		if(b!=null) {
		
		System.out.println(b);
		
		}
	}
	public void displayAllBank() {
		EntityManager entityManager=getEntityManager();
		Query query= entityManager.createQuery("select a from Bank a");
		List<Bank>list=query.getResultList();
		System.out.println(list);
	}
	
	
	
	
	

}
