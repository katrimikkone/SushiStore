package backend.sushistore.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnore
	private List<Sushi> sushis;
	
	public Category() {
	
	}
	
	public Category(String name) {
		this.name = name;
	}


	public Category(String name, List<Sushi> sushis) {
		super();
		this.name = name;
		this.sushis = sushis;
	}


	public Category(Long categoryid, String name, List<Sushi> sushis) {
		this.categoryid = categoryid;
		this.name = name;
		this.sushis = sushis;
	}


	public Long getCategoryid() {
		return categoryid;
	}


	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Sushi> getSushis() {
		return sushis;
	}


	public void setSushis(List<Sushi> sushis) {
		this.sushis = sushis;
	}
	
	
}
