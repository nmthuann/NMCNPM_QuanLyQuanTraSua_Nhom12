package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entity.EmployeeAccountEntity;
import com.entity.PositionEntity;


@Transactional
@Repository
public class AccountDao {
	
	@Autowired
	SessionFactory factory;
	
	
	/*
	 * public interface AccountDaoImp { public boolean CheckLogin(String email,
	 * String pass); public EmployeeAccountEntity getByUsername(String email);
	 * public Boolean InsertAccount(EmployeeAccountEntity account); public Boolean
	 * EditAccount(EmployeeAccountEntity account); public Boolean
	 * DeleteAccount(EmployeeAccountEntity account); public
	 * List<EmployeeAccountEntity> EmployeeAccountList(); }
	 */
	
	//Check_Login
		public boolean CheckLogin(String userName, String password) {
			Session session = factory.getCurrentSession();
			String hql = "FROM EmployeeAccountEntity where userName = :userName and password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			/* query.setParameter("role", role); */
			List<EmployeeAccountEntity> list = query.list();
			if(list.size() == 0) {
				return false;
			}
			return true;
		}
		
		//Check_MK
		public boolean CheckPassword(String password) {
			Session session = factory.getCurrentSession();
			String hql = "FROM EmployeeAccountEntity where password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("password", password);
			/* query.setParameter("role", role); */
			List<EmployeeAccountEntity> list = query.list();
			if(list.size() == 0) {
				return false;
			}
			return true;
		}
		
		//Lay_Role
		public boolean  getByRole() {
			Session session = factory.getCurrentSession();
			String hql = "from EmployeeAccountEntity  where role = :1";
			Query query = session.createQuery(hql);
			//model.setparameters
			
			List<EmployeeAccountEntity> list = query.list();
			if(list.size() == 1) {
				return true;
			}
			return false;
		}
		
		//Lay_Email
		public EmployeeAccountEntity  getByEmail(String userName) {
			Session session = factory.getCurrentSession();
			String hql = "from EmployeeAccountEntity where userName = :userName";
			Query query = session.createQuery(hql);
			query.setParameter("userName", userName);
			
			List<EmployeeAccountEntity> list = query.list();
			if(list.size() == 0) {
				return null;
			}
			return list.get(0);
		}
		
		
		//Lay_Email
		public EmployeeAccountEntity  getByPassword(String userName) {
			Session session = factory.getCurrentSession();
			String hql = "Select password from EmployeeAccountEntity where userName = :userName";
			Query query = session.createQuery(hql);
			query.setParameter("userName", userName);
			
			List<EmployeeAccountEntity> list = query.list();
			if(list.size() == 0) {
				return null;
			}
			return list.get(0);
		}
		
		//Danh_Sach_Tai_Khoan
		public List<EmployeeAccountEntity> EmployeeAccountList() {
			Session session = factory.getCurrentSession();
			String hql = "from EmployeeAccountEntity";
			Query query = session.createQuery(hql);
			List<EmployeeAccountEntity> list = query.list();
			
			return list;
		}
		
		//Insert_Account
		public Boolean InsertAccount(EmployeeAccountEntity account) {
			Boolean isSuccess = true;
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			
			try {
				session.save(account);
				t.commit();
			} catch (Exception e) {
				System.out.println(e);
				t.rollback();
				isSuccess = false;
			}
			finally {
				session.close();
			}
			return isSuccess;
		}
		
//		//Edit_Account
//		public Boolean EditAccount(EmployeeAccountEntity account) {
//			Boolean isSuccess = true;
//			Session session = factory.openSession();
//			Transaction t = session.beginTransaction();
//			
//			try {
//				session.update(account);
//				t.commit();
//				
//			} catch (Exception e) {
//				System.out.println(e);
//				t.rollback();
//				isSuccess = false;
//			}
//			finally {
//				session.close();
//			}
//			return isSuccess;
//		}
		
		// Edit_Account
		public Integer EditAccount(EmployeeAccountEntity account) {
			//Boolean isSuccess = true;
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			
			try {
				session.update(account);
				t.commit();
				session.close();
				return 1;
			} catch (Exception e) {
				t.rollback();
				session.close();
				return 0;
			}
		}
		
		
		//Delete_Account
		public Boolean DeleteAccount(EmployeeAccountEntity account) {
			Boolean isSuccess = true;
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			
			try {
				session.delete(account);
				t.commit();
				
			} catch (Exception e) {
				System.out.println(e);
				t.rollback();
				isSuccess = false;
			}
			finally {
				session.close();
			}
			return isSuccess;
		}
}
