package com.products;

public class product {

	//<!-- id,sku,pic,name,pict,price,delieverFee,descript,seller,categ,postDate  -->

	private int id;
	private String sku;	
	private String picurl;
	private String name;		
	private String pict;	
	private double price;	
	private double DelieverFee;	
	private String Descript;			
	private int Seller;	
	private int Categ;	
	


	public product(int id, String sku, String picurl, String name, String pict,
			double price, double delieverFee, String descript, int seller,
			int categ) {
		super();
		this.id = id;
		this.sku = sku;
		this.picurl = picurl;
		this.name = name;
		this.pict = pict;
		this.price = price;
		DelieverFee = delieverFee;
		Descript = descript;
		Seller = seller;
		Categ = categ;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getSku() {
		return sku;
	}



	public void setSku(String sku) {
		this.sku = sku;
	}



	public String getPicurl() {
		return picurl;
	}



	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPict() {
		return pict;
	}



	public void setPict(String pict) {
		this.pict = pict;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public double getDelieverFee() {
		return DelieverFee;
	}



	public void setDelieverFee(double delieverFee) {
		DelieverFee = delieverFee;
	}



	public String getDescript() {
		return Descript;
	}



	public void setDescript(String descript) {
		Descript = descript;
	}



	public int getSeller() {
		return Seller;
	}



	public void setSeller(int seller) {
		Seller = seller;
	}



	public int getCateg() {
		return Categ;
	}



	@Override
	public String toString() {
		return "product [id=" + id + ", sku=" + sku + ", picurl=" + picurl
				+ ", name=" + name + ", pict=" + pict + ", price=" + price
				+ ", DelieverFee=" + DelieverFee + ", Descript=" + Descript
				+ ", Seller=" + Seller + ", Categ=" + Categ + "]";
	}
	
	
	
	
	

}
