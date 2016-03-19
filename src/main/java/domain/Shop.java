package main.java.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="goods")
public class Shop {
    @Id
    @Column(name= "idgoods")			
	private long idGoods;
    @Column(name= "number")
    private int number;
    @Column(name= "price")
    private double price;
    @Column(name= "sold")
    private int sold;  
    
    public Shop() {
    	
    }

	public long getIdGoods() {
		return idGoods;
	}

	public void setIdGoods(long idGoods) {
		this.idGoods = idGoods;
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
