package com.controller;

import java.util.List;
import java.util.Random;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.EmployeeAccountEntity;

import com.service.AccountService;
import com.service.EmployeeService;

import javassist.expr.NewArray;

@Controller
@RequestMapping(value = "/account/")
public class AccountController {

//	@Autowired
//	SessionFactory factory;

	@Autowired
	AccountService accountService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	JavaMailSender mailer;

	/*
	 * @ModelAttribute("EmployeeList") public List<EmployeeEntity> getEmployeeList()
	 * { List<EmployeeEntity> list = employeeService.EmployeeList(); return list; }
	 */

	// Quên mật khẩu
	@RequestMapping(value = "forgotpassword", method = RequestMethod.GET)
	public String forgotpassword(ModelMap model) {
		model.addAttribute("account", new EmployeeAccountEntity());
		return "account/forgotpassword";
	}

	// Gửi mail để lấy lại mật khẩu
	@RequestMapping(value = "forgotpassword", method = RequestMethod.POST)
	public String forgotpassword(ModelMap model, @ModelAttribute("account") EmployeeAccountEntity account,
			@RequestParam("userName") String userName,
			BindingResult errors ){

		userName="thuanminh.2001286@gmail.com";

		
//		if (account.getUserName().trim().length() == 0) {
//			errors.rejectValue("userName", "account", "Yêu cầu không để trống tài khoản");
//			return "account/forgotpassword";
//		}
//		if (errors.hasErrors()) {
//			//return "redirect:account/forgotpassword.htm";
//		}
		EmployeeAccountEntity infor = new EmployeeAccountEntity();
		 infor = accountService.getByEmail(userName); 
			System.out.println(infor);
			 System.out.println(userName);
			 //System.out.println(account.getPassword());
		
			Random rand = new Random();
			int rand_int1 = rand.nextInt(100000000);
			String newPassword = Integer.toString(rand_int1);
			
			System.out.println(newPassword);
			
			
			//infor. = infor.setPassword(newPassword);
			//infor.setPassword(newPassword);
			Integer temp = accountService.EditAccount(account);
			temp = 1;
			if (temp != 0) {
				model.addAttribute("message", "Update Successfully!");
				String from = "nmt.m10.2862001@gmail.com";
				String to = userName;
				String body = "Đây là mật khẩu mới của bạn: " + newPassword;
				String subject = "Quên mật khẩu";
				try {
					MimeMessage mail = mailer.createMimeMessage();
					MimeMessageHelper heper = new MimeMessageHelper(mail, true, "UTF-8");
					heper.setFrom(from, from);
					heper.setTo(to);
					heper.setReplyTo(from);
					heper.setSubject(subject);
					heper.setText(body, true);
					mailer.send(mail);
					System.out.println("Gưi mail");
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}
			} else {
				model.addAttribute("message", "Update Failed!");
				System.out.println("Gưi mail thất bại");
			}
			
		//}
		//model.addAttribute("message", "login Failed!");
			
		return "account/forgotpassword";
	}

	
	
	
	// DoiMK
	@RequestMapping(value = "changepassword", method = RequestMethod.GET)
	public String changepassword(ModelMap model, @RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword, @RequestParam("newPasswordAgain") String newPasswordAgain,
			HttpSession httpSession) {
//		model.addAttribute("account", account);
//		httpSession.setAttribute("user", user);
		return "account/changepassword";
	}

	@RequestMapping(value = { "changepassword" }, method = RequestMethod.POST)
	public String change_password(ModelMap model, HttpServletRequest request,
			@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword,
			@RequestParam("newPasswordAgain") String newPasswordAgain) {

		// Account user = (Account) httpSession.getAttribute("user");

		HttpSession httpSession = request.getSession();
		EmployeeAccountEntity account = (EmployeeAccountEntity) httpSession.getAttribute("account");

		if (!account.getPassword().equals(oldPassword)) {
			model.addAttribute("message1", "Mật khẩu cũ không chính xác!");
			return "redicrect:/employee/changepassword.htm";
		}
		if (oldPassword.length() == 0)
			model.addAttribute("message1", "Mật khẩu không được để trống");
		if (newPassword.length() == 0)
			model.addAttribute("message2", "Mật khẩu không được để trống");
		if (newPasswordAgain.length() == 0)
			model.addAttribute("message3", "Mật khẩu không được để trống");
		else if (!newPassword.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
				|| !newPasswordAgain.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$"))
			model.addAttribute("message", "Nhập trên 8 kí tự trong đó có chữ Hoa thường và ký tự đặc biệt");
		else if (!newPassword.equals(newPasswordAgain)) {
			model.addAttribute("message", "Mật khẩu mới không trùng nhau !");
		} else if (newPassword.equals(oldPassword)) {
			model.addAttribute("message", "Mật khẩu mới không được trùng với mật khẩu cũ !");
		}

		else {
			Integer temp = accountService.EditAccount(account);
			System.out.println(temp);
			if (temp != 0) {
				model.addAttribute("message", "Change Successfully!");
			} else {
				model.addAttribute("message", "Change Failed!");
			}
		}
		return "account/changepassword";
	}

//	
	// Login_Get
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.put("account", new EmployeeAccountEntity());
		return "account/login";
	}

	// Login_Post
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(ModelMap model, HttpSession ss, @ModelAttribute("account") EmployeeAccountEntity account,
			BindingResult errors) {

		// BindingResult errors KiemTraDuLieuDauvao
		if (account.getUserName().length() == 0) {
			errors.rejectValue("userName", "account", "tên Tài Khoản trống!");
		}

		if (account.getPassword().length() == 0) {
			errors.rejectValue("password", "account", "vui lòng nhập lại mật khẩu");
		}

		if (errors.hasErrors()) {
			return "redirect:account/login.htm";
		}

		// KiemTra_Login
		if (accountService.CheckLogin(account.getUserName().trim(), account.getPassword().trim()) == true) {
			EmployeeAccountEntity infor = accountService.getByEmail(account.getUserName());

			// Lay_Quyen_Account
			if (infor.isRole() == true) {
				ss.setAttribute("account", infor);
				model.addAttribute("infor", infor);
				System.out.println("admin ngu");
				return "admin/adminhome"; // Admin_Page
			} else {
				ss.setAttribute("account", infor);
				model.addAttribute("infor", infor);
				System.out.println("Nhân viên quèn");
				return "employee/home"; // EmployeePage
			}
		}
		model.addAttribute("message", "login Failed!");
		return "account/login";
	}

	// View user home
	@RequestMapping(value = "account-infor", method = RequestMethod.GET)
	public String viewUserHome(ModelMap model, HttpServletRequest request) {
		HttpSession getSession = request.getSession();
		EmployeeAccountEntity account = (EmployeeAccountEntity) getSession.getAttribute("account");
		getSession.setAttribute("account", account);
		model.put("account", account);

		System.out.println((EmployeeAccountEntity) getSession.getAttribute("account"));
		System.out.println("lam on di bo");
		return "account/account-infor";
	}

	@RequestMapping(value = "account-infor", method = RequestMethod.POST)
	public String viewUserHome(ModelMap model, @ModelAttribute("account") EmployeeAccountEntity account) {

		return "account/account-infor";
	}

	// DangXuat
	@RequestMapping(value = "logout")
	public String logOut(HttpServletRequest req) {
		HttpSession s = req.getSession();
		s.removeAttribute("infor");
		return "redirect:/user/home.htm";
	}
}
