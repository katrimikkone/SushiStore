package backend.sushistore.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="symbol")
public class Image {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long symbolid;
	private String name;
	@Lob
	private byte[] imagedata;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "image")
	@JsonIgnore
	private List<Sushi> sushis;
	
	public Image() {
		
	}

	public Image(String name, byte[] imagedata) {
		super();
		this.name = name;
		this.imagedata = imagedata;
	}

	public Long getSymbolid() {
		return symbolid;
	}

	public void setSymbolid(Long symbolid) {
		this.symbolid = symbolid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImagedata() {
		return imagedata;
	}

	public void setImageData(byte[] imagedata) {
		this.imagedata = imagedata;
	}
	
	
	
	
}
