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
@Table(name="subcategory")
public class Subcategory  implements Serializable{
    @Id
    @Column(name= "id")		
	protected long id;
    @Column(name= "idcategory")		
	protected long idCategory; 
    @Column(name= "name")	
    protected String name;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsubcategory")    
    protected List<Goods> goods = new ArrayList<Goods>();
    
    public Subcategory() {

    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}



}
