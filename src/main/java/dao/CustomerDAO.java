package main.java.dao;

import java.util.List;

import main.java.domain.Category;
import main.java.domain.Client;
import main.java.domain.Goods;
import main.java.domain.SaleRecord;
import main.java.domain.Subcategory;

public interface CustomerDAO {
	
	public Client getClientById(long id);
	public List<Client> getAllClients();
	public Client getClientActivity(long id, String startDate, String endDate);
	public void addClient(Client user);
	public void delClient(long id);
		
	public Category getCategoryById(long id);
	public List<Category> getAllCategories();
	public void addCategory(Category categ);
	public void delCategory(long id);
	public Category getSelectCateg(long id);
	
	public Subcategory getSubcategoryById(long id);
	public List<Subcategory> getSubcategories(long idCategory);
	public void addSubcategory(Subcategory subcateg);
	public void delSubcategory(long id);
	
	public Goods getGoodsById(long id);
	public List<Goods> getGoods(long idCategory,long idSubcategory);
	public void addGoods(Goods goods);
	public void delGoods(long id);
	public void buyGoods(SaleRecord saleRecord);
	
	public List<SaleRecord> getSaleRecords();
	public List<SaleRecord> getClientSaleRecords(long id);
	public void addSaleRecord(SaleRecord saleRecord);
	
}
