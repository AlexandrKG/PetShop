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
@Table(name="category")
public class Category implements Serializable{
    @Id
    @Column(name= "id")		
	protected long id;
    @Column(name= "name")	
    protected String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategory")    
    protected List<Subcategory> subcategories = new ArrayList<Subcategory>();
    
    public Category() {
    	
    }
    public Category(String data) {
        this.name = data;
        subcategories = new ArrayList<>();
    }

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

    public List<Subcategory> getSubcategories() {
		return subcategories;
	}
    
	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}
	
	private boolean existSubcategory(String subcategoryName) {
        for(Subcategory e : subcategories) {
            if(e.getName().equals(subcategoryName)) {
                return true;
            }
        }
        return false;
    }

    public void addSubcategory(String subcategory) {
        if (!existSubcategory(subcategory)) {
            Subcategory e = new Subcategory();
            e.setName(subcategory);
            e.setId(System.currentTimeMillis());
            subcategories.add(e);
        }
    }

    public void addSubcategory(Subcategory e) {
        subcategories.add(e);
    }


    public Subcategory getSubcategory(String subcategory) {
        Subcategory result = null;
        for(Subcategory e : subcategories) {
            if(e.getName().equals(subcategory)) {
                result = e;
                break;
            }
        }
        return result;
    }

    public Subcategory getSubcategory(long subcategoryID) {
        Subcategory result = null;
        for(Subcategory e : subcategories) {
            if(e.getId() == subcategoryID) {
                result = e;
                break;
            }
        }
        return result;
    }
}
