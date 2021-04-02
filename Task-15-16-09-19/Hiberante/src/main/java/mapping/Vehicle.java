package mapping;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {

		@Id
		private String regno;
		private String brand;
		private String model;
		private long price;
	
		public Vehicle(String regno, String brand, String model, long price) {
			super();
			this.regno = regno;
			this.brand = brand;
			this.model = model;
			this.price = price;
		}

		public Vehicle(String regno) {
			super();
			this.regno = regno;
		}

		public Vehicle() {
			super();
		}
		
		public String getRegno() {
			return regno;
		}
		public void setRegno(String regno) {
			this.regno = regno;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public long getPrice() {
			return price;
		}
		public void setPrice(long price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "Vehicle [regno=" + regno + ", brand=" + brand + ", model=" + model + ", price=" + price + "]";
		}
		
		
}
