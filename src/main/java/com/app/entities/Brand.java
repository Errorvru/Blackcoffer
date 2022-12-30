package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="brand")
public class Brand {
	
		@Id
//		@GeneratedValue
		@Column(name="id")
	private int id;
		@Column(name="brandname")
	private String brandName;
//		@Column(name="price")
//	private float price;
		
		public Brand(int id, String brandName) {
			this.id = id;
			this.brandName = brandName;
		}
		public Brand() {
			// TODO Auto-generated constructor stub
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getBrandName() {
			return brandName;
		}
		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}
		@Override
		public String toString() {
			return "Brand [id=" + id + ", brandName=" + brandName + "]";
		}
		
		
}
