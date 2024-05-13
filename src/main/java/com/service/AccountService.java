package com.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AccountDao;
import com.entity.EmployeeAccountEntity;


@Service
public class AccountService {
	@Autowired
	AccountDao accountDao;
	
	//CheckLoginHashPass
	public boolean CheckLoginHashPass(String userName, String password) {
		// TODO Auto-generated method stub
		String pwHash = HashPass(password);
		return accountDao.CheckLogin(userName, pwHash);
	}
	
	//CheckLogin
	public boolean CheckLogin(String userName, String password){
		// TODO Auto-generated method stub
				return accountDao.CheckLogin(userName, password);
	}
	
	//GetEmail
	public EmployeeAccountEntity getByEmail(String userName) {
		// TODO Auto-generated method stub
				return accountDao.getByEmail(userName);
	}
	
	public EmployeeAccountEntity getByPassword(String userName) {
		// TODO Auto-generated method stub
				return accountDao.getByPassword(userName);
	}
	
	//CheckTaiKhoanTontai
	public Boolean CheckExistUserName(String userName) {
		if(this.getByEmail(userName)!= null) {
			return true;
		}
		return false;
	}
	
	
	//DanhSachTaiKhoan
	public List<EmployeeAccountEntity>EmployeeAccountList(){
		return accountDao.EmployeeAccountList();
	}
	
	//SetAccount
	public EmployeeAccountEntity setAccount(String userName,String password) {
		EmployeeAccountEntity account = new EmployeeAccountEntity();
		account.setUserName(userName);
		account.setPassword(password);
//		taiKhoan.setMaTK(taoMaTKMoi());
		return account;
	}
	
	//SetAccount
	public EmployeeAccountEntity setAccountHashPW(String userName,String password) {
		EmployeeAccountEntity account = new EmployeeAccountEntity();
		account.setUserName(userName);
		account.setPassword(HashPass(password));
//		taiKhoan.setMaTK(taoMaTKMoi());
		return account;
	}
	
	//
	public Boolean InsertAccount(EmployeeAccountEntity account) {
		//account.setRole(false);
		return accountDao.InsertAccount(account);
	}
	
	//HashPasss
	public String HashPass(String password) {
		String hashpw = DigestUtils.md5Hex(password).toUpperCase();
		return hashpw;
	}
	
	//ResetPW
//	public Boolean ResetPassword(EmployeeAccountEntity account) {
//		account.setPassword(HashPass("12345678"));
//		return accountDao.EditAccount(account);
//	}
	
	//ThayDoiMK
//	public Boolean ChangePassword1(EmployeeAccountEntity account, String password) {
//		account.setPassword(HashPass(password));
//		return accountDao.EditAccount(account);
//	}
	
	public Integer EditAccount(EmployeeAccountEntity account) {
		return accountDao.EditAccount(account);
	}
	
	//DangKi
	public Boolean RegisterAccount(EmployeeAccountEntity account) {
		
		//ThemNV
		account.setRole(false);
		return accountDao.InsertAccount(account);
	}
}
