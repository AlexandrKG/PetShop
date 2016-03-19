package main.java.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client implements Serializable{
    @Id
    @Column(name= "id")	
	private long idClient;
    @Column(name= "name")
	private String name;
    @Column(name= "gender")
	private String gender;
    @Column(name= "age")   
	private int age;
    @Column(name= "address")   
	private String address;
    @Column(name= "telephone")   
	private String telephone;
	
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idclient")
    private List<SaleRecord> records = new ArrayList<SaleRecord>();  	

	public Client() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public List<SaleRecord> getRecords() {
		return records;
	}

	public void setRecords(List<SaleRecord> records) {
		this.records = records;
	}

	
}
