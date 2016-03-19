package main.java.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="goods")
public class Goods {
    @Id
    @Column(name= "id")			
	private long idGoods;
    @Column(name= "idcategory")		
	protected long idCategory; 
    @Column(name= "idsubcategory")		
	protected long idSubcategory; 
    @Column(name= "name")
	private String name;
    @Column(name= "number")
    private int number;
    @Column(name= "price")
    private double price;
    @Column(name= "sold")
    private int sold;  	
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="idgoods")
//    private Shop shop;

	public Goods() {

	}


	public long getIdGoods() {
		return idGoods;
	}


	public void setIdGoods(long idGoods) {
		this.idGoods = idGoods;
	}


	public long getIdCategory() {
		return idCategory;
	}


	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}


	public long getIdSubcategory() {
		return idSubcategory;
	}


	public void setIdSubcategory(long idSubcategory) {
		this.idSubcategory = idSubcategory;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getSold() {
		return sold;
	}


	public void setSold(int sold) {
		this.sold = sold;
	}

}
