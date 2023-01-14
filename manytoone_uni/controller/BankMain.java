package manytoone_uni.controller;

import java.util.Scanner;

import manytoone_uni.dao.BankDao;
import manytoone_uni.dao.BranchDao;
import manytoone_uni.dto.Bank;
import manytoone_uni.dto.Branch;

public class BankMain {
    static Bank ref;
	public static void main(String[] args) {
		BranchDao dao=new BranchDao();
		BankDao bank=new BankDao();
		
		
		
		
		
		Scanner sc=new Scanner(System.in);
		boolean check=true;
		System.out.println("====welcome=======");
		do {
			
			System.out.println("===Enter your choice===  \n 1.Add Bank details \n 2.Add BranchDetails"
					+ "\n 3.Update bank details  \n 4.update branch details"
					+ "\n 5.Details of bank  \n 6.Details of Branch"
					+ "\n 7.All details of bank  \n 8.All details of branch"
					+ "\n 9.delete bank details \n 10.delete branch details \n 11.exit");
			int option=sc.nextInt();
			switch (option) { 
			case 1:{
//				System.out.println("Enter bank id");
//			    int id=sc.nextInt();
			    System.out.println("enter Bank name ");
			    String name=sc.next();
			    System.out.println("Enter headoffice");
			    String head=sc.next();
			    System.out.println("Enter CEO");
			    String ceo=sc.next();
			    
			    Bank b=new Bank();
			    ref=b;
			    
			    b.setName(name);
			    b.setCeo(ceo);
			    b.setHeadoffic(head);
			    
			    bank.saveBank(b);
			    
				
			}break;
			case 2:
			{  
				
				System.out.println("Enter bank id to save branch details");
				int id=sc.nextInt();
				System.out.println("Enter Ifsc code ");
				String ifsc=sc.next();
				System.out.println("Enter  name");
				String name=sc.next();
				System.out.println("Enter Address");
				String address=sc.next();
				System.out.println("Enter manager name");
				String manager=sc.next();
				System.out.println("Enter phone");
				long phone=sc.nextLong();
				
				Branch b=new Branch();
				b.setAddress(address);
				b.setIfsc(ifsc);
				b.setName(name);
				b.setPhone(phone);
				b.setManager(manager);
				
				dao.saveBranch(id,b);
				
				
			}break;
			case 3:
			{
				
				System.out.println("Enter bank id");
				int id=sc.nextInt();
				  System.out.println("enter Bank name ");
				    String name=sc.next();
				    System.out.println("Enter headoffice");
				    String head=sc.next();
				    System.out.println("Enter CEO");
				    String ceo=sc.next();
				    
				    Bank b=new Bank();
				    
				    b.setName(name);
				    b.setCeo(ceo);
				    b.setHeadoffic(head);
				    bank.updateBank(id, b);
			}break;
			case 4:{
				System.out.println("Enter branch id");
				int id=sc.nextInt();
				System.out.println("Enter Ifsc code ");
				String ifsc=sc.next();
				System.out.println("Enter  name");
				String name=sc.next();
				System.out.println("Enter Address");
				String address=sc.next();
				System.out.println("Enter manager name");
				String manager=sc.next();
				System.out.println("Enter phone");
				long phone=sc.nextLong();
				
				Branch b=new Branch();
				b.setAddress(address);
				b.setIfsc(ifsc);
				b.setName(name);
				b.setPhone(phone);
				b.setManager(manager);
				dao.updateBranch(id, b);
			}break;
			case 5:{
				System.out.println("Enter bank");
				int id=sc.nextInt();
				bank.displayBank(id);
				
			}break;
			case 6:
			{
				System.out.println("Enter branch id");
				int id=sc.nextInt();
				dao.displayBranch(id);
			}break;
			case 7:
			{
				bank.displayAllBank();
			}break;
			case 8:
			{
				dao.displayAllBranch();
			}break;
			case 9:{
				System.out.println("Enter bank id");
				int id=sc.nextInt();
				bank.deleteBank(id);
			}break;
			case 10:
			{
				System.out.println("Enter branch id");
				int id=sc.nextInt();
				dao.deleteBranch(id);
			}break;
			case 11:
			{
				check=false;
			}

			
			}
			
		}while(check);
		System.out.println("====thank you=====");
		

	}

}
