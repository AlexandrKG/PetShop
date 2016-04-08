package main.java.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.Collections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.domain.Category;
import main.java.domain.Client;
import main.java.domain.Goods;
import main.java.domain.SaleRecord;
import main.java.domain.Subcategory;
import main.java.utl.DataUtl;

@Repository
@Transactional
@Qualifier("hibernateUserDao")
public class HibernateUserDao implements CustomerDAO {

	private static final String HQL_ALL_CLIENTS = 
			"SELECT idClient, name, gender, age, address, telephone FROM Client";
	private static final String HQL_ALL_CATEGORIES =
			"SELECT id, name FROM Category";
	private static final String HQL_IDCATEG_SUBCATEGORIES = 
			"SELECT id, idCategory, name FROM Subcategory WHERE idCategory = :idcateg";	
	private static final String HQL_IDCATEG_GOODS = 
			"SELECT id, idCategory, idSubcategory, name FROM Goods WHERE idCategory = :idcateg "
			+ " AND idSubcategory = :idsubcateg";
	private static final String HQL_TRANSACTIONS = 
			"SELECT idRecord, goods, client, data, number, cost FROM SaleRecord";
	private static final String HQL_CLIENT_TRANSACTIONS = 
			"SELECT idRecord, idGoods, data, number, cost FROM SaleRecord "
			+ "WHERE idClient = :clientid";
	
	private SessionFactory sessionFactory;

	@Autowired
	public HibernateUserDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		// System.err.println("sessionFactory = " +
		// this.sessionFactory.toString());
		// System.err.println("HibernateUserDao = " + this.toString());
	}

	private Session currentSession() {
		Session session = sessionFactory.getCurrentSession();
		System.err.println("!!! ============= session = " + session);
		return session;
	}
	
//===============================================================================
	
	private <T>T getBeanById(Class<T> cl,long id) {
		T bean = null;
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			bean = cl.newInstance();
			bean = (T) session.get(cl, id);
			session.flush(); 
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); 
			}
		}
		return bean;
	}

	private <T> void addBean(T obj) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			session.save(obj);
			session.flush(); 
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); 
			}
		}		
	}

	private <T> void delBean(T obj) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			session.delete(obj);
			session.flush(); 
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); 
			}
		}		
	}
	
//=====================================getList==========================================
	
	private List<Client> getClientList(Query query) {
		ArrayList<Client> clients = new ArrayList<>();
		Client client;
		Iterator iterator = query.list().iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			client = new Client();
			client.setIdClient((long) obj[0]);
			client.setName((String) obj[1]);
			client.setGender((String) obj[2]);
			client.setAge((int) obj[3]);
			client.setAddress((String) obj[4]);
			client.setTelephone((String) obj[5]);
			clients.add(client);
		}
		return clients;
	}	
	

	private List<Category> getCategoryList(Query query) {
		ArrayList<Category> categories = new ArrayList<>();
		Category categ;
		Iterator iterator = query.list().iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			categ = new Category();
			categ.setId((long) obj[0]);
			categ.setName((String) obj[1]);
			categories.add(categ);
		}
		return categories;
	}	

	private List<Subcategory> getSubcategoryList(Query query, long idcateg) {
		query.setParameter("idcateg", idcateg);
		ArrayList<Subcategory> subcategories = new ArrayList<>();
		Subcategory subcategory;
		Iterator iterator = query.list().iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			subcategory = new Subcategory();
			subcategory.setId((long) obj[0]);
			subcategory.setIdCategory((long) obj[1]);
			subcategory.setName((String) obj[2]);
			subcategories.add(subcategory);
		}
		return subcategories;
	}
	
	private List<Goods> getGoodsList(Query query, long idcateg, long idsubcateg) {
//		System.out.println("====Query: idcateg = " + idcateg + " idsubcateg: " + idsubcateg);
		query.setParameter("idcateg", idcateg);
		query.setParameter("idsubcateg", idsubcateg);
		ArrayList<Goods> goodsArray = new ArrayList<>();
		Goods goods;
		Iterator iterator = query.list().iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			goods = new Goods();
			goods.setIdGoods((long) obj[0]);
			goods.setIdCategory((long) obj[1]);
			goods.setIdSubcategory((long) obj[2]);
			goods.setName((String) obj[3]);
			goodsArray.add(goods);
		}
		return goodsArray;
	}
	
//	private List<SaleRecord> getSRList(Query query) {
//		System.out.println("====Query: getSRList================");
//		ArrayList<SaleRecord> saleRecords = new ArrayList<>();
//		SaleRecord sr;
//		Iterator iterator = query.list().iterator();
//		while (iterator.hasNext()) {
//			Object[] obj = (Object[]) iterator.next();
//			sr = new SaleRecord();
//			sr.setIdRecord((long) obj[0]);
//			sr.setGoods((Goods)obj[1]);   
//			sr.setClient((Client) obj[2]);
//			Calendar date = DataUtl.getStringData((java.sql.Date)obj[3]);
//			sr.setData(date);
//			sr.setDataTXT(DataUtl.txtData(date));
//			sr.setNumber((int) obj[4]);
//			sr.setCost((double) obj[5]);
//			System.out.println("SaleRecord ID = " + sr.getIdRecord());
//			saleRecords.add(sr);
//		}		
//		return saleRecords;
//	}
	
	private List<SaleRecord> getClientSRList(Query query, long id) {
		System.out.println("====Query: getClientSRList================STEP2");
		System.out.println("clientid = " + id);
		query.setParameter("clientid", id);
		
		ArrayList<SaleRecord> saleRecords = new ArrayList<>();
		SaleRecord sr;
		Iterator iterator = query.list().iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			sr = new SaleRecord();
			sr.setIdRecord((long) obj[0]);
//			sr.setIdGoods((long) obj[1]);
//			sr.setGoods((Goods)obj[1]);   
//			sr.setClient((Client) obj[2]);
//			Calendar date = DataUtl.getStringData((java.sql.Date)obj[2]);
			Calendar date = ((Calendar)obj[2]);
			sr.setData(date);
			sr.setDataTXT(DataUtl.txtData(date));
			sr.setNumber((int) obj[3]);
			sr.setCost((double) obj[4]);
			System.out.println("SaleRecord ID = " + sr.getIdRecord());
			saleRecords.add(sr);
		}		
		return saleRecords;
	}
//===============================Client================================================	
	
	@Override
	public List<Client> getAllClients() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// List<User> results = (List<User>)session.createQuery(HQL_ALL_USERS)
		// .setResultTransformer(Transformers.aliasToBean(User.class)).list();
		List<Client> results = getClientList(session.createQuery(HQL_ALL_CLIENTS));
		tx.commit();
		session.close();
		return results;
	}

	@Override
	public Client getClientActivity(long id, String startDate, String endDate) {
		Client results = null;
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			results = (Client)session.load(Client.class, id);
			//======================================================
//			System.out.println(results.getName() + " has " +
//					results.getRecords().size() +
//					" records which are");
			 
			for (SaleRecord sr : results.getRecords()) {
//				System.out.println("============================================");
//				System.out.println(sr.getData().after(DataUtl.setData(startDate)));
//				System.out.println(sr.getData().before(DataUtl.setData(endDate)));
				sr.setDataTXT(null);
				if(sr.getData().compareTo(DataUtl.setData(startDate)) >= 0) {
//				if(sr.getData().after(DataUtl.setData(startDate)))	{
					if(sr.getData().compareTo(DataUtl.setData(endDate)) <= 0) {
//					if(sr.getData().before(DataUtl.setData(endDate))) {
//						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
						sr.setDataTXT(DataUtl.txtData(sr.getData()));
					}
				}
					
//				System.out.println(" ID = " + sr.getIdRecord()+ "DateTXT = "+sr.getDataTXT());
//				System.out.println("Goods = "+sr.getGoods().getName());
				sr.getGoods().getName();
			}
			//======================================================		
			session.flush(); 
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); 
			}
		}			

		return results;
	}

	@Override
	public Client getClientById(long id) {
		return getBeanById((new Client()).getClass(),id);
	}

	@Override
	public void addClient(Client client) {
		addBean(client);		
	}

	@Override
	public void delClient(long id) {
		Client client = getClientById(id);
		delBean(client);
	}
	
//======================================Category=========================================	
	
	@Override
	public List<Category> getAllCategories() {
		List<Category> results = null;
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
		tx = session.beginTransaction();
		results = getCategoryList(session.createQuery(HQL_ALL_CATEGORIES));
		session.flush(); 
		tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); 
			}
		}				
		return results;
	}	
	
	@Override
	public void addCategory(Category categ) {
		addBean(categ);		
	}
	
	@Override
	public Category getCategoryById(long id) {
		return getBeanById((new Category()).getClass(),id);
	}
	
	@Override
	public void delCategory(long id) {
		Category categ = getCategoryById(id);
		delBean(categ);
	}

	@Override
	public Category getSelectCateg(long id) {
		Category results = null;
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			results = (Category)session.load(Category.class, id);
			//======================================================
			System.out.println("==================================================");
			System.out.println(results.getName() + " has " +
					results.getSubcategories().size() +
					" Subcategories which are");
			 
			for (Subcategory sc : results.getSubcategories()) {					
				System.out.println("Subcategory = "+sc.getName());
				for (Goods g : sc.getGoods()) {	
					System.out.println("Goods = "+g.getName());
					System.out.println("Goods Number = "+g.getNumber());
					System.out.println("Goods Number = "+g.getPrice());
				}	
			}
			
			//======================================================		
			session.flush(); 
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); 
			}
		}			

		return results;
	}
	
//===============================================================================	
	
	@Override
	public List<Subcategory> getSubcategories(long idCategory) {
		List<Subcategory> results = null;
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
		tx = session.beginTransaction();
		results = getSubcategoryList(session.createQuery(HQL_IDCATEG_SUBCATEGORIES),idCategory);
		session.flush(); 
		tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); 
			}
		}				
		return results;
	}	

	@Override
	public Subcategory getSubcategoryById(long id) {
		return getBeanById((new Subcategory()).getClass(),id);
	}
	
	@Override
	public void addSubcategory(Subcategory subcateg) {
		addBean(subcateg);			
	}
	
	@Override
	public void delSubcategory(long id) {
		Subcategory subcateg = getSubcategoryById(id);
		delBean(subcateg);
	}

	
//===============================================================================	
	

	@Override
	public List<Goods> getGoods(long idCategory, long idSubcategory) {
		List<Goods> results = null;
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
		tx = session.beginTransaction();
		results = getGoodsList(session.createQuery(HQL_IDCATEG_GOODS),idCategory,idSubcategory);
		session.flush(); 
		tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); 
			}
		}				
		return results;
	}

	@Override
	public Goods getGoodsById(long id) {
		return getBeanById((new Goods()).getClass(),id);
	}

	@Override
	public void addGoods(Goods goods) {
		addBean(goods);		
	}

	@Override
	public void delGoods(long id) {
		Goods goods = getGoodsById(id);
		delBean(goods);	
	}

	@Override
	public void buyGoods(SaleRecord saleRecord) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
		tx = session.beginTransaction();
		Goods goods = (Goods)session.get(Goods.class, saleRecord.getGoods().getIdGoods()); 
		goods.setNumber(goods.getNumber()-saleRecord.getNumber());
		goods.setSold(goods.getSold()+ saleRecord.getNumber());
		session.update(goods);
		addSaleRecord(saleRecord);
		session.flush(); 
		tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); 
			}
		}	
		
	}
	
//===============================================================================	
	

	@Override
	public void addSaleRecord(SaleRecord saleRecord) {
		addBean(saleRecord);
	}

	@Override
	public List<SaleRecord> getSaleRecords() {
		List<SaleRecord> results = null;
//		Transaction tx = null;
//		Session session = sessionFactory.openSession();
//		try {
//		tx = session.beginTransaction();
//		results = getSRList(session.createQuery(HQL_TRANSACTIONS));
//		session.flush(); 
//		tx.commit();
//		} catch (Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			ex.printStackTrace();
//		} finally {
//			if (session != null) {
//				session.close(); 
//			}
//		}				
		return results;
	}

	@Override
	public List<SaleRecord> getClientSaleRecords(long id) {
		List<SaleRecord> results = null;
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
		tx = session.beginTransaction();
		results = getClientSRList(session.createQuery(HQL_CLIENT_TRANSACTIONS),id);
		session.flush(); 
		tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); 
			}
		}				
		return results;
	}	

	
}
