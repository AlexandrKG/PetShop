package main.java.domain;

import main.java.utl.DataUtl;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="trade")
public class SaleRecord {
	
    @Id
    @Column(name= "id")		
	private long idRecord;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idgoods")	
	private Goods goods;
    	   
    @Column(name="idclient")	    
	private long idClient;
    
    @Column(name= "data")
	private Calendar data;
    @Column(name= "number")
	private int number;
    @Column(name= "price")
	private double cost;

    
    private String dataTXT;

  
    public SaleRecord() {
    	
    }
    
	public long getIdRecord() {
		return idRecord;
	}

	public void setIdRecord(long idRecord) {
		this.idRecord = idRecord;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}


	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
//		setDataTXT(DataUtl.txtData(data));
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getDataTXT() {
		return dataTXT;
	}

	public void setDataTXT(String dataTXT) {
		this.dataTXT = dataTXT;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

//	public long getIdGoods() {
//		return idGoods;
//	}
//
//	public void setIdGoods(long idGoods) {
//		this.idGoods = idGoods;
//	}

	//============================================================
//	public void printRecord() {
//		System.out.print(DataUtl.txtData(this.data) + "; ");
//		System.out.print(this.client + "; ");
//		System.out.print(this.goods + "; ");
//		System.out.print(this.number + "; ");
//		System.out.print(this.cost + "; ");
//		System.out.println("Summ: " + this.cost * this.number + ".");
//	}
//
//	public boolean printDataRecord(Calendar startData, Calendar stopData) {
//		if (this.data.compareTo(startData) >= 0
//				&& this.data.compareTo(stopData) <= 0) {
//			System.out.print(DataUtl.txtData(this.data) + "; ");
//			System.out.print(this.client + "; ");
//			System.out.print(this.goods + "; ");
//			System.out.print(this.number + "; ");
//			System.out.print(this.cost + "; ");
//			System.out.println("Summ: " + this.cost * this.number + ".");
//			return true;
//		}
//		return false;
//	}

}
