package mapping;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Laptop {
	@Id
	private String code;
	private String brand;
	private int price;
	
	public Laptop(String code, String brand, int price) {
		super();
		this.code = code;
		this.brand = brand;
		this.price = price;
	}
	
	public Laptop(String code) {
		super();
		this.code = code;
	}



	public Laptop() {
		super();
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Laptop [code=" + code + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
}
