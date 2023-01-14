package manytoone_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytoone_uni.dto.Bank;
import manytoone_uni.dto.Branch;

public class BranchDao {
	
		public EntityManager getEntityManger() {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("radha");
			return entityManagerFactory.createEntityManager();
		}
		
		public void saveBranch(int id,Branch branch) {
			EntityManager entityManager=getEntityManger();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Bank bank=entityManager.find(Bank.class, id);
			if(bank!=null) {
				
				branch.setBank(bank);
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
			System.out.println("saved successfully");
			}
			
		}
		
		public void updateBranch(int id,Branch branch) {
			
			EntityManager entityManager=getEntityManger();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Branch b=entityManager.find(Branch.class, id);
			if(b!=null) {
				branch.setId(id);
				branch.setBank(b.getBank());
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
			}
			
		}
		
		public void deleteBranch(int id) {
			EntityManager entityManager=getEntityManger();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Branch b=entityManager.find(Branch.class, id);
			if(b!=null) {
			entityTransaction.begin();
			entityManager.remove(b);
			entityTransaction.commit();
			}
		}
		public void displayBranch(int id) {
			EntityManager entityManager=getEntityManger();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Branch b=entityManager.find(Branch.class, id);
			System.out.println(b);
		}
		
		public void displayAllBranch()
		{
			EntityManager entityManager=getEntityManger();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Query query=entityManager.createQuery("select a from Branch a");
			List<Branch>list=query.getResultList();
			System.out.println(list);
		}
			
	
	

}
