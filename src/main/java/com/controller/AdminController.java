package com.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.BillEntity;
import com.entity.CustomerEntity;
import com.entity.DetailBillEntity;
import com.entity.DrinkEntity;
import com.entity.EmployeeAccountEntity;
import com.entity.EmployeeEntity;
import com.entity.PositionEntity;
import com.entity.SeatEntity;
import com.service.AccountService;
import com.service.BillService;
import com.service.CustomerService;
import com.service.DetailBillService;
import com.service.DrinkService;
import com.service.EmployeeService;
import com.service.PositionService;
import com.service.SeatService;

import javassist.expr.NewArray;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	SessionFactory factory;

	@Autowired
	ServletContext context;

	@Autowired
	DrinkService drinkService;

	@Autowired
	SeatService seatService;

	@Autowired
	CustomerService customerService;

	@Autowired
	PositionService positionService;

	@Autowired
	DetailBillService detailBillService;

	@Autowired
	AccountService accountService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	BillService billService;

//	@Autowired
//	AccountService

	@RequestMapping("adminhome")
	public String home() {
		return "admin/adminhome";
	}

	@RequestMapping("employeeaccount")
	public String employeeaccount() {
		return "admin/employeeaccount";
	}



	// =============================================== CUSTOMER
	// =================================================== //
	// Them - Sua - TK
	@RequestMapping("customer")
	public String customer(ModelMap model, @ModelAttribute("customer") CustomerEntity customer) {
		List<CustomerEntity> list = customerService.CustomerList();
		model.addAttribute("customers", list);
		model.addAttribute("btnStatus", "btnAdd");
		return "admin/customer";
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
		if (customerService.CheckCustomerId(customer.getCustomerID()) == false) {
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
		return "admin/customer";
	}

	// Edit
	@RequestMapping(value = "customer/{customerID}", params = "linkEdit")
	public String UpdateCustomer(HttpServletRequest request, ModelMap model,
			@PathVariable("customerID") String customerID, @ModelAttribute("customer") CustomerEntity customer) {

		List<CustomerEntity> list = customerService.CustomerList();
		model.addAttribute("customer", customerService.getByCustomerID(customerID));
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("customers", list);

		return "admin/customer";
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

		return "admin/customer";
	}

	// TimKiem
	@RequestMapping(params = "btnSearch", value = "customer")
	public String SearchCustomerID(HttpServletRequest request, ModelMap model,
			@ModelAttribute("customers") CustomerEntity customers) {
		List<CustomerEntity> list = customerService.searchCustomerID(request.getParameter("searchCustomerId"));
		model.addAttribute("cutomers", list);
		System.out.println("Tim customer");
		return "admin/customer";
	}
	// ===============================================================================================================//

	// =================================================== DRINK
	// =====================================================//
	// Them - Sua - Xoa- TK
	@RequestMapping("drink")
	public String drink(ModelMap model, @ModelAttribute("drink") DrinkEntity drink) {

		List<DrinkEntity> list = drinkService.DrinkList();
		model.addAttribute("drinks", list);
		model.addAttribute("btnStatus", "btnAdd");
		return "admin/drink";
	}

	// Insert
	@RequestMapping(value = "drink", params = "btnAdd", method = RequestMethod.POST)
	public String InsertDrink(HttpServletRequest request, ModelMap model, @ModelAttribute("drink") DrinkEntity drink,
			BindingResult errors) {

		// Mã Trùng
		if (drinkService.CheckId(drink.getDrinkID())) {
			errors.rejectValue("drinkID", "drink", "ID Không được Trùng!");
		}
		// Ten_trống
		if (drink.getDrinkName().trim().length() == 0) {
			errors.rejectValue("drinkName", "drink", "Không được bỏ trống!");
		}
		// Giá ko hợp lệ
		if (drink.getPrice() < 0) {
			errors.rejectValue("price", "drink", "Không hợp lệ!");
		}
		// Dơn vị trống
		if (drink.getUnit().trim().length() == 0) {
			errors.rejectValue("unit", "drink", "Không được bỏ trống!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("message", "Check,pls");
		} else {
			model.addAttribute("message", "Ok");
			Integer temp = drinkService.InsertDrink(drink);
			System.out.println(temp);
			if (temp != 0) {
				model.addAttribute("message", "Insert Successfully!");
			} else {
				model.addAttribute("message", "Insert Failed!");
			}
		}
		List<DrinkEntity> list = drinkService.DrinkList();
		model.addAttribute("drinks", list);
		model.addAttribute("btnStatus", "btnAdd");
		return "admin/drink";
	}

	// Sửa
	@RequestMapping(value = "drink/{drinkID}", params = "linkEdit")
	public String UpdateDrink(HttpServletRequest request, ModelMap model, @PathVariable("drinkID") String drinkID,
			@ModelAttribute("drink") DrinkEntity drink) {

		List<DrinkEntity> list = drinkService.DrinkList();
		model.addAttribute("drink", drinkService.GetByDrinkId(drinkID));
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("drinks", list);

		return "admin/drink";
	}

	@RequestMapping(value = "drink", params = "btnEdit", method = RequestMethod.POST)
	public String UpdateDrink(HttpServletRequest request, ModelMap model, @ModelAttribute("drink") DrinkEntity drink,
			BindingResult errors) {

		/*
		 * // Mã Trùng if (drinkService.CheckId(drink.getDrinkID())) {
		 * errors.rejectValue("drinkID", "drink", "ID Không được Trùng!"); }
		 */
		// Ten_trống
		if (drink.getDrinkName().trim().length() == 0) {
			errors.rejectValue("drinkName", "drink", "Không được bỏ trống!");
		}
		// Giá ko hợp lệ
		if (drink.getPrice() < 0) {
			errors.rejectValue("price", "drink", "Không hợp lệ!");
		}
		// Dơn vị trống
		if (drink.getUnit().trim().length() == 0) {
			errors.rejectValue("unit", "drink", "Không được bỏ trống!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("message", "Check,pls");
		} else {
			Integer temp = drinkService.EditDrink(drink);
			System.out.println(temp);
			if (temp != 0) {
				model.addAttribute("message", "Update Successfully!");
			} else {
				model.addAttribute("message", "Update Failed!");
			}
		}

		return "admin/drink";
	}

	// Delete
	@RequestMapping(value = "drink/{drinkID}", params = "btnDelete")
	public String DeleteDrink(ModelMap model, @ModelAttribute("drink") DrinkEntity drink,
			@PathVariable("drinkID") String drinkID) {

		Integer temp = drinkService.DeleteDrink(drinkID);
		System.out.println(temp);
		if (temp != 0) {
			model.addAttribute("message", "Delete Successfully!");

		} else {
			model.addAttribute("message", "Delete Failed!");
		}

		List<DrinkEntity> list = drinkService.DrinkList();
		model.addAttribute("drinks", list);
		return "admin/drink";

	}

	@RequestMapping(params = "btnSearch", value = "drink")
	public String SearchDrinkName(HttpServletRequest request, ModelMap model,
			@ModelAttribute("drinks") DrinkEntity drinks) {
		List<DrinkEntity> list = drinkService.SearchDrinkName(request.getParameter("searchDrinkName"));
		model.addAttribute("drinks", list);
		return "admin/drink";
	}

	// ========================================== EMPLOYEE
	// ================================================================//
	// Them - Sua - TK
	@RequestMapping("employeepage")
	public String index(ModelMap model) {
		List<EmployeeEntity> list = employeeService.EmployeeList();
		model.addAttribute("employees", list);
		return "admin/employeepage";
	}

	@RequestMapping(params = "btnSearch", value = "employeepage")
	public String SearchEmpName(HttpServletRequest request, ModelMap model,
			@ModelAttribute("employees") EmployeeEntity employees) {
		List<EmployeeEntity> list = employeeService.SearchEmployeeName(request.getParameter("searchInput"));
		model.addAttribute("employees", list);
		return "admin/employeepage";
	}

	@ModelAttribute("positions")
	public List<PositionEntity> getByPositionNameList() {
		List<PositionEntity> list = employeeService.getByPositionNameList();
		return list;
	}

	// UpdateStatusNV
	@RequestMapping(value = "employeepage/{employeeID}", params = "btnUpdate")
	public String UpdateEmployeeStatus(ModelMap model, @ModelAttribute("employee") EmployeeEntity employee,
			@PathVariable("employeeID") int employeeID) {

		Integer temp = employeeService.UpdateEmployeeStatus(employeeID);
		System.out.println(temp);
		if (temp != 0) {
			model.addAttribute("message", "Update Successfully!");

		} else {
			model.addAttribute("message", "Update Failed!");
		}

		List<EmployeeEntity> list = employeeService.EmployeeList();
		model.addAttribute("employees", list);
		return "admin/employeepage";
	}

	// Sửa Nhân viên
	@RequestMapping(value = "employee-infor/{employeeID}", params = "linkEdit")
	public String editEmployee(HttpServletRequest request, ModelMap model, @PathVariable("employeeID") int employeeID,
			@ModelAttribute("employee") EmployeeEntity employee) {

		List<EmployeeEntity> list = employeeService.EmployeeList();
		model.addAttribute("employee", employeeService.GetByEmployeeID(employeeID));
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("employees", list);

		return "admin/employee-infor";
	}

//		@RequestMapping(value = "employee-infor", params = "btnEdit", method = RequestMethod.POST)
//		public String edit_Employee(HttpServletRequest request, ModelMap model,
//				@ModelAttribute("employee") EmployeeEntity employee) {
//
////			Integer temp = employeeService.
////			System.out.println(temp);
////			if (temp != 0) {
////				model.addAttribute("message", "Insert Successfully!");
////			} else {
////				model.addAttribute("message", "Insert Failed!");
////			}
//
//			return "admin/employeepage";
//		}

	@RequestMapping(value = "register")
	public String EmployeeRegister() {
		return "admin/register";
	}

	// =========================================== POSITION
	// ==================================================================//

	@RequestMapping("position")
	public String position(ModelMap model, @ModelAttribute("position") PositionEntity position) {
		List<PositionEntity> list = positionService.PositionList();
		model.addAttribute("positions", list);
		model.addAttribute("btnStatus", "btnAdd");
		return "admin/position";
	}

	// Insert
	@RequestMapping(value = "position", params = "btnAdd", method = RequestMethod.POST)
	public String InsertPosition(HttpServletRequest request, ModelMap model,
			@ModelAttribute("position") PositionEntity position, BindingResult errors) {

		// Ten_trống
		if (position.getPositionName().trim().length() == 0) {
			errors.rejectValue("positionName", "position", "Không được bỏ trống!");
//			return "admin/position";
		}
		if (errors.hasErrors()) {
			model.addAttribute("message", "Check,pls");
		} else {
			model.addAttribute("message", "Ok");
			Integer temp = positionService.InsertPosition(position);
			System.out.println(temp);
			if (temp != 0) {
				model.addAttribute("message", "Insert Successfully!");
			} else {
				model.addAttribute("message", "Insert Failed!");
			}
		}
		List<PositionEntity> list = positionService.PositionList();
		model.addAttribute("positions", list);
		model.addAttribute("btnStatus", "btnAdd");
		return "admin/position";
	}

	// Sửa
	@RequestMapping(value = "position/{positionID}", params = "linkEdit")
	public String UpdatePosition(HttpServletRequest request, ModelMap model, @PathVariable("positionID") int positionID,
			@ModelAttribute("position") PositionEntity position) {

		List<PositionEntity> list = positionService.PositionList();
		model.addAttribute("position", positionService.GetByPositionId(positionID));
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("positions", list);

		return "admin/position";
	}

	@RequestMapping(value = "position", params = "btnEdit", method = RequestMethod.POST)
	public String edit_Position(HttpServletRequest request, ModelMap model,
			@ModelAttribute("position") PositionEntity position) {

		Integer temp = positionService.EditPosition(position);
		System.out.println(temp);
		if (temp != 0) {
			model.addAttribute("message", "Insert Successfully!");
		} else {
			model.addAttribute("message", "Insert Failed!");
		}

		return "admin/position";
	}

	// Delete
	@RequestMapping(value = "position/{positionID}", params = "btnDelete")
	public String DeletePosition(ModelMap model, @ModelAttribute("position") PositionEntity position,
			@PathVariable("positionID") int positionID) {

		Integer temp = positionService.DeletePosition(positionID);
		System.out.println(temp);
		if (temp != 0) {
			model.addAttribute("message", "Delete Successfully!");

		} else {
			model.addAttribute("message", "Delete Failed!");
		}

		List<PositionEntity> list = positionService.PositionList();
		model.addAttribute("positions", list);
		return "admin/position";

	}
	// =========================================================================================================================//

	// ============================================ SEAT
	// =======================================================================//

	// danh sách bàn
	@RequestMapping("seat")
	public String seat(ModelMap model, @ModelAttribute("seat") SeatEntity seat) {

		List<SeatEntity> list = seatService.SeatList();
		model.addAttribute("seats", list);
		return "admin/seat";
	}

	// danh sách bàn trống
	@RequestMapping(params = "btnShow", value = "seat")
	public String ShowAdmin(HttpServletRequest request, ModelMap model, @ModelAttribute("seat") SeatEntity seat) {
		List<SeatEntity> list = seatService.getByEmptySeatList();
		//model.addAttribute("seats", list);
		model.put("seats", list);
		return "admin/seat";
	}

	// UpdateStatus
	@RequestMapping(value = "seat/{seatID}", params = "btnUpdate")
	public String UpdateStatus(ModelMap model, @ModelAttribute("seat") SeatEntity seat,
			@PathVariable("seatID") int seatID) {

		Integer temp = seatService.UpdateStatus(seatID);
		System.out.println(temp);
		if (temp != 0) {
			model.addAttribute("message", "Update Successfully!");

		} else {
			model.addAttribute("message", "Update Failed!");
		}

		List<SeatEntity> list = seatService.SeatList();
		model.addAttribute("seats", list);
		return "admin/seat";

	}
	// ============================================================================================================================//

	// ================================================ DETAILBILL
//	// ===================================================//
	@ModelAttribute("bills")
	public List<BillEntity> getByBillIDList() {
		List<BillEntity> list = billService.BillList();
		return list;
	}

	@RequestMapping("detailbill")
	public String DetailBill(HttpServletRequest request, ModelMap model,
			@ModelAttribute("detailbill") DetailBillEntity detailbill) {
		return "admin/detailbill";
	}

	@RequestMapping(value = "detailbill", params = "btnFind")
	public String DetailBillList(HttpServletRequest request, ModelMap model,
			@ModelAttribute("detailbill") DetailBillEntity detailbill, @RequestParam("bill.billID") int billID) {
		List<DetailBillEntity> list = detailBillService.SearchBillID(billID);
		model.addAttribute("detailbills", list);
		model.addAttribute("total", detailBillService.TotalBill(detailbill, billID));
		return "admin/detailbill";
	}

	// ============================================================================================================================//

	// ================================================ Order
	// ===================================================//
	@ModelAttribute("customers")
	public List<CustomerEntity> getCustomerList() {
		List<CustomerEntity> list = customerService.CustomerList();
		return list;
	}

	@ModelAttribute("EmployeeId")
	public int getByEmployeeId(ModelMap model, HttpServletRequest request) {
		HttpSession getSession = request.getSession();
		EmployeeAccountEntity account = (EmployeeAccountEntity) getSession.getAttribute("account");
		getSession.setAttribute("account", account);
		model.put("account", account);
		int ID = account.getEmployeeEntity().getEmployeeID();
		System.out.println((EmployeeAccountEntity) getSession.getAttribute("account"));
		System.out.println("ID: " + ID);
		return ID;
	}

	@ModelAttribute("seatEmpty")
	public List<SeatEntity> getSeatEmptyList() {
		List<SeatEntity> list = seatService.getByEmptySeatList();
		return list;
	}

	@ModelAttribute("TimeNowCreateBill")
	public Date TimeNow() {
		long millis = System.currentTimeMillis();
		Date dateNow = new java.sql.Date(millis);
		System.out.println(dateNow);

		return dateNow;
	}

	@ModelAttribute("drinkList")
	public List<DrinkEntity> getDrinkList() {
		List<DrinkEntity> list = drinkService.DrinkList();
		return list;
	}

	@RequestMapping("bill")
	public String OrderBill(ModelMap model, @ModelAttribute("bill") BillEntity bill) {
		List<BillEntity> list = billService.BillList();
		model.addAttribute("bills", list);
		System.out.println("cc");
		return "admin/bill";
	}

	// Create Bill
	@RequestMapping(value = "bill", params = "btnCreate")
	public String CreateBill(ModelMap model, @ModelAttribute("bill") BillEntity bill, BindingResult errors) {

		if (bill.getCreateBillDay() == null) {
			errors.rejectValue("createBillDay", "bill", "Không được bỏ trống!");
//			return "admin/position";
		}
		if (errors.hasErrors()) {
			model.addAttribute("message", "Check,pls");
		} else {
			Integer temp = billService.InsertBill(bill);
			System.out.println(temp);
			if (temp != 0) {
				model.addAttribute("message", "Insert Successfully!");
			} else {
				model.addAttribute("message", "Insert Failed!");
			}
		}
		// bill vs ID vừa tạo
		List<BillEntity> list = billService.BillList();
		model.addAttribute("bills", list);
		System.out.println("Chuc Nang Create Bill");// Phai Rong
		return "admin/order";
	}

	@ModelAttribute("billIdLast")
	public int getByBillIdLast() {
		int ID = billService.getByBillIdLast();
		return ID;
	}

	// XoaHD khi HD rong
	// Chua lam

	@RequestMapping("order")
	public String OrderDetailBill(ModelMap model, @ModelAttribute("detailbill") DetailBillEntity detailbill,
			BindingResult errors) {
		List<DetailBillEntity> list = detailBillService.SearchBillID(billService.getByBillIdLast());
		model.addAttribute("detailbills", list);
		model.addAttribute("detailbill", new DetailBillEntity());
		System.out.println("cc");
		return "admin/order";
	}

	// InsertDetailBill
	@RequestMapping(value = "order", params = "btnInsert")
	public String InsertDetailBill(ModelMap model, @ModelAttribute("detailbill") DetailBillEntity detailbill,
			@RequestParam("bill.billID") int billID, BindingResult errors) {
		// Ten_trống
		if (detailbill.getQuantity() == 0) {
			errors.rejectValue("quantity", "detailbill", "So luong Không được bỏ trống!");
		}
		if (detailbill.getDrink().getDrinkID() == null) {
			errors.rejectValue("drink.drinkID", "detailbill", "mã thức uống Không được bỏ trống!");
		}
		if (detailbill.getBill().getBillID() == 0) {
			errors.rejectValue("bill.billID", "detailbill", "mã hóa đơn Không được bỏ trống!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("message", "Kiểm tra lại!");
		} else {
			Integer temp = detailBillService.InsertDetailBill(detailbill);
			System.out.println(temp);
			if (temp != 0) {
				model.addAttribute("message", "Insert Successfully!");
			} else {
				model.addAttribute("message", "Insert Failed!");
			}
		}

		// bill vs ID vừa tạo
		List<DetailBillEntity> list = detailBillService.SearchBillID(billID);
		model.addAttribute("detailbills", list);
		System.out.println("Chuc Nang Insert DetailBill");// Phai Rong
		return "admin/order";
	}

//	
	// Cancel_DetailBill
	@RequestMapping(value = "order/{drinkID}", params = "btnCancel")
	public String DeleteDrinkIDDetailBill(HttpServletRequest request, ModelMap model,
			@ModelAttribute("detailbill") DetailBillEntity detailbill, @PathVariable("drinkID") String drinkID) {

		HttpSession getSession = request.getSession();
		BillEntity bill = (BillEntity) getSession.getAttribute("bill");

		Integer temp = detailBillService.DeleteDrinkIDDetailBill(drinkID);
		System.out.println(temp);
		if (temp != 0) {
			model.addAttribute("message", "Delete Successfully!");

		} else {
			model.addAttribute("message", "Delete Failed!");
		}

		// ShowList
		List<DetailBillEntity> list = detailBillService.SearchBillID(bill.getBillID());
		model.addAttribute("detailbills", list);
		System.out.println("Chuc nang Cancel DetailBill");
		return "admin/order";
	}

	// ===============================================================================================================//

	// ===================================================Dung_Lai_Duoc_Rui==================================================//
}
