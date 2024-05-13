package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.entity.DrinkEntity;


@Transactional
@Repository
public class DrinkDao {
	@Autowired
	SessionFactory factory;

	public boolean CheckId(String drinkID) {
		Session session = factory.getCurrentSession();
		String hql = "FROM DrinkEntity where drinkID = :drinkID";
		Query query = session.createQuery(hql);
		query.setParameter("drinkID", drinkID);
		List<DrinkEntity> list = query.list();
		if (list.size() == 0) {
			return false;
		}
		return true;
	}

	// Lay_DrinkName
	public DrinkEntity getByDrinkName(String drinkName) {
		Session session = factory.getCurrentSession();
		String hql = "from DrinkEntity where drinkName = :drinkName";
		Query query = session.createQuery(hql);
		query.setParameter("drinkName", drinkName);

		List<DrinkEntity> list = query.list();
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
	
	// DanhSach_NhanVien
			public List<DrinkEntity> SearchDrinkName(String name) {
				Session session = factory.getCurrentSession();
				String hql = "FROM DrinkEntity where drinkName LIKE '%"+ name + "%'";
				Query query = session.createQuery(hql);
				List<DrinkEntity> list = query.list();
				return list;
			}
	
	// lấy ID Drink
		public DrinkEntity  GetByDrinkID(String drinkID) {
			Session session = factory.getCurrentSession();
			String hql = "from DrinkEntity Where drinkID = :drinkID";
			Query query = session.createQuery(hql);
			query.setParameter("drinkID", drinkID);
			List<DrinkEntity> list = query.list();
			return list.get(0);
		}

	// Danh_Sach_Thuc_uong
	public List<DrinkEntity> DrinkList() {
		Session session = factory.getCurrentSession();
		String hql = "from DrinkEntity ";
		Query query = session.createQuery(hql);
		List<DrinkEntity> list = query.list();
		return list;
	}

	// Insert_Drink
		public Integer InsertDrink(DrinkEntity drink) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();

			try {
				session.save(drink);
				t.commit();
				session.close();
				return 1;
			} catch (Exception e) {
				t.rollback();
				session.close();
				return 0;
			}
			/*
			 * } finally {
			 * 
			 * } return 1;
			 */
		}

		// Edit_ChucVu
		public Integer EditDrink(DrinkEntity drink) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			
			try {
				session.update(drink);
				t.commit();
				session.close();
				return 1;
			} catch (Exception e) {
				t.rollback();
				session.close();
				return 0;
			}
		}

		// Delete_ChucVu
		public Integer DeleteDrink(String drinkID) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			DrinkEntity drink = (DrinkEntity)session.get(DrinkEntity.class, drinkID);
			try {
				session.delete(drink);
				t.commit();
				session.close();
				return 1;
			} catch (Exception e) {
				t.rollback();
				session.close();
				return 0;
			}
			
		}

//
//			@RequestMapping(value = "insert", method = RequestMethod.POST)
//			public String insert(ModelMap model, @ModelAttribute("drink") DrinkEntity drink, BindingResult errors) {
//				model.addAttribute("drink", new DrinkEntity());
//				// check trùng
//				if (CheckId(drink.getDrinkID())== false) {
//					errors.rejectValue("drinkID", "drink","Id đã tồn tại");
//				}
//				if (drink.getDrinkName().trim().length() == 0) {
//					errors.rejectValue("drinkName", "drink","Không được trống");
//				}
//				if (drink.getPrice() == 0) {
//					errors.rejectValue("price", "drink","Không hợp lệ");
//				}
//				if (drink.getUnit().trim().length() == 0) {
//					errors.rejectValue("unit", "drink","Không được trống");
//				}
//				if(errors.hasErrors()) {
//					model.addAttribute("message","Vui lòng kiểm tra lại!");
//				}
//				else {
//					model.addAttribute("message","Nhập đúng");
//
//					
//				}
//				Session session = factory.openSession();
//				Transaction t = session.beginTransaction();
//				try {
//					session.save(drink);
//					t.commit();
//					model.addAttribute("message", "Thêm mới thành công!");
//				} catch (Exception e) {
//					t.rollback();
//					model.addAttribute("message", "Thêm mới thất bại!");
//				} finally {
//					session.close();
//				}
//				return "drink/insert";
//			}
}
