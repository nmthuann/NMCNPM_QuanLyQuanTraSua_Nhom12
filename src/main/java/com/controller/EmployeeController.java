package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.CustomerEntity;
import com.entity.DrinkEntity;
import com.entity.PositionEntity;
import com.entity.SeatEntity;
import com.service.CustomerService;
import com.service.DrinkService;
import com.service.SeatService;

@Controller
@RequestMapping("/employee/")
public class EmployeeController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	DrinkService drinkService;
	
	@Autowired
	SeatService seatService;

	// =============================================== CUSTOMER =================================================== //
//	@RequestMapping("customer")
//	public String customerindex(HttpServletRequest request, ModelMap model,
//			@ModelAttribute("customer") CustomerEntity customer) {
//
//		PagedListHolder pagedListHolder = new PagedListHolder(customerService.CustomerList());
//		int page = ServletRequestUtils.getIntParameter(request, "c", 0);
//		pagedListHolder.setPage(page);
//		pagedListHolder.setMaxLinkedPages(4);
//		model.addAttribute("btnStatus", "btnAdd");
//		pagedListHolder.setPageSize(5);
//		model.addAttribute("pagedListHolder", pagedListHolder);
//		return "employee/customer";
//	}
//
//	@RequestMapping(value = "customer", params = "btnsearch", method = RequestMethod.GET)
//	public String searchUsername(HttpServletRequest request, ModelMap model,
//			@ModelAttribute("customer") CustomerEntity customer) {
//		PagedListHolder pagedListHolder = new PagedListHolder(customerService.searchCustomerID(request.getParameter("searchCustomerID")));
//		int page = ServletRequestUtils.getIntParameter(request, "c", 0);
//		pagedListHolder.setPage(page);
//		pagedListHolder.setMaxLinkedPages(5);
//
//		pagedListHolder.setPageSize(10);
//		System.out.print("tesst");
//		model.addAttribute("pagedListHolder", pagedListHolder);
//
//		return "employee/customer";
//	}
//
//	@RequestMapping(value = "customer", params = "btnSave", method = RequestMethod.POST)
//	public String InsertCustomer(HttpServletRequest request, ModelMap model,
//			@ModelAttribute("customer") CustomerEntity customer) {
//
//		// Khong_trung
//		/*
//		 * if(customerService.CheckCustomerId(request.getParameter("customerID"))==
//		 * false) { // errors.rejectValue("customerID", "không trùng"); return
//		 * "redirect:"; }
//		 */
//
//		Integer temp = customerService.InsertCustomer(customer);
//		System.out.println(temp);
//		if (temp != 0) {
//			model.addAttribute("message", "Thêm thành công");
//		} else {
//			model.addAttribute("message", "Thêm thất bại!");
//		}
//		PagedListHolder pagedListHolder = new PagedListHolder(customerService.CustomerList());
//		int page = ServletRequestUtils.getIntParameter(request, "c", 0);
//		pagedListHolder.setPage(page);
//		pagedListHolder.setMaxLinkedPages(5);
//
//		pagedListHolder.setPageSize(10);
//		System.out.print("tesst");
//		model.addAttribute("pagedListHolder", pagedListHolder);
//
//		return "employee/customer";
//	}
	// Them - Sua - TK
		@RequestMapping("customer")
		public String customer(ModelMap model, @ModelAttribute("customer") CustomerEntity customer) {
			List<CustomerEntity> list = customerService.CustomerList();
			model.addAttribute("customers", list);
			model.addAttribute("btnStatus", "btnAdd");
			return "employee/customer";
		}

		// Insert
		@RequestMapping(value = "customer", params = "btnAdd", method = RequestMethod.POST)
		public String InsertCustomer(HttpServletRequest request, ModelMap model,
				@ModelAttribute("customer") CustomerEntity customer, BindingResult errors) {
			System.out.println("Insert Customer");
			// ID_trống
			if (customer.getCustomerID().trim().length() == 0) {
				errors.rejectValue("customerID", "customer", "ID Không được bỏ trống!");
				System.out.println("ID Không được bỏ trống!");
			}
			// ID_Trung
			if (customerService.CheckCustomerId(customer.getCustomerID())== false ){
				errors.rejectValue("customerID", "customer", "bi trung");
				System.out.println("ID Không được bỏ trống!");
			}
			
			if (errors.hasErrors()) {
				model.addAttribute("message", "Check,pls");
			} else {
				model.addAttribute("message", "Ok");
				Integer temp = customerService.InsertCustomer(customer);
				System.out.println(temp);
				if (temp != 0) {
					model.addAttribute("message", "Insert Successfully!");
				} else {
					model.addAttribute("message", "Insert Failed!");
				}
			}
			List<CustomerEntity> list = customerService.CustomerList();
			model.addAttribute("customers", list);
			model.addAttribute("btnStatus", "btnAdd");
			return "employee/customer";
		}

		// Edit
		@RequestMapping(value = "customer/{customerID}", params = "linkEdit")
		public String UpdateCustomer(HttpServletRequest request, ModelMap model,
				@PathVariable("customerID") String customerID, @ModelAttribute("customer") CustomerEntity customer) {

			List<CustomerEntity> list = customerService.CustomerList();
			model.addAttribute("customer", customerService.getByCustomerID(customerID));
			model.addAttribute("btnStatus", "btnEdit");
			model.addAttribute("customers", list);

			return "employee/customer";
		}

		@RequestMapping(value = "customer", params = "btnEdit", method = RequestMethod.POST)
		public String edit_Customer(HttpServletRequest request, ModelMap model,
				@ModelAttribute("customer") CustomerEntity customer) {

			Integer temp = customerService.EditCustomer(customer);
			System.out.println(temp);
			if (temp != 0) {
				model.addAttribute("message", "Update Successfully!");
			} else {
				model.addAttribute("message", "Update Failed!");
			}

			return "employee/customer";
		}

		// TimKiem
		@RequestMapping(params = "btnSearch", value = "customer")
		public String SearchCustomerID(HttpServletRequest request, ModelMap model,
				@ModelAttribute("customer") CustomerEntity customer) {
			List<CustomerEntity> list = customerService.searchCustomerID(request.getParameter("searchCustomerId"));
			model.addAttribute("cutomers", list);
			System.out.println("Tim customer");
			return "employee/customer";
		}
	//============================================================================================================================//
	
	//======================================================== DRINK ==========================================================// 
		//Them - Sua - Xoa- TK
		@RequestMapping("drink")
		public String drink(HttpServletRequest request, ModelMap model, @ModelAttribute("drink") DrinkEntity drink){
			
			PagedListHolder pagedListHolder = new PagedListHolder(drinkService.DrinkList());
			int page = ServletRequestUtils.getIntParameter(request, "dr", 0);
			pagedListHolder.setPage(page);
			pagedListHolder.setMaxLinkedPages(5);
			pagedListHolder.setPageSize(4);
			model.addAttribute("pagedListHolder", pagedListHolder);
			return"employee/drink";
		}
		
//		@ModelAttribute("drinkList")
//		public List<DrinkEntity> getDrinkList(){
//			List<DrinkEntity> list = drinkService.DrinktList();
//			return list;
//			
//		}
	//==========================================================================================================================//
	
		
	//=============================================== SEAT =======================================================================//	
		//danh sách bàn
		@RequestMapping("seat")
		public String seat( ModelMap model, @ModelAttribute("seat") SeatEntity seat){
		
			List<SeatEntity> list = seatService.SeatList();
			model.addAttribute("seats", list);
			return"employee/seat";
		}
		
		// danh sách bàn trống
		@RequestMapping(params="btnShow",value="seat")
		public String Show(HttpServletRequest request, ModelMap model, @ModelAttribute("seat") SeatEntity seat){
			List<SeatEntity> list = seatService.getByEmptySeatList();
			model.addAttribute("seats", list);
			return"employee/seat";
		}
		
		//UpdateStatus
		@RequestMapping(value = "seat/{seatID}",params="btnUpdate")
		public String UpdateStatus(ModelMap model, @ModelAttribute("seat") SeatEntity seat, @PathVariable("seatID") int seatID) {
			
			Integer temp = seatService.UpdateStatus(seatID);
			System.out.println(temp);
			if (temp != 0) {
				model.addAttribute("message", "Update Successfully!");
				
			} else {
				model.addAttribute("message", "Update Failed!");
			} 
			
			
			List<SeatEntity> list = seatService.SeatList();
			model.addAttribute("seats", list);
			return "employee/seat";
			
		}
		//============================================================================================================================//	
}
