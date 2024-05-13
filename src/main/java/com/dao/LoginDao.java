//package com.dao;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.entity.EmployeeAccountEntity;
//import com.model.UserInfo;
//
//
//public class LoginDao {
//	
//	@Autowired
//	SessionFactory factory;
//	
//	public List<EmployeeAccountEntity> getAccount(String username, String password) {
//		Session session = factory.getCurrentSession();
//		String hql = " * FROM TaiKhoanNhanVien WHERE TenTK = :username AND MatKhau = :password";
//		Query query = session.createQuery(hql);
//		query.setParameter("TenTK", "%" +  username + "%");
//		query.setParameter("MatKhau", "%" +  password + "%");
//		List<EmployeeAccountEntity> list = query.list();
//		return list;
//	}
//	@RequestMapping("")
//	public String loginAccount(HttpServletRequest request, ModelMap model,
//			@ModelAttribute("account") UserInfo account) {
//		model.addAttribute("account",new UserInfo() );
//		return "login/infor";
//	}
//}
