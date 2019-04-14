package com.hwua.entity;

public class Car {
	private long c_id;
	private String c_name;
	private String c_carNumber;
	private String c_color;
	private long c_carprice;
	private String c_remark;
	private String c_brand;
	private String c_type;
	private long c_price;
	private int c_ifrent;
	private int c_ifputaway;
	
	public Car() {
		super();
	}

	public Car(long cId, String cName, String cCarNumber, String cColor,
			long cCarprice, String cRemark, String cBrand, String cType,
			long cPrice, int cIfrent, int cIfputaway) {
		super();
		c_id = cId;
		c_name = cName;
		c_carNumber = cCarNumber;
		c_color = cColor;
		c_carprice = cCarprice;
		c_remark = cRemark;
		c_brand = cBrand;
		c_type = cType;
		c_price = cPrice;
		c_ifrent = cIfrent;
		c_ifputaway = cIfputaway;
	}

	public long getC_id() {
		return c_id;
	}

	public void setC_id(long cId) {
		c_id = cId;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String cName) {
		c_name = cName;
	}

	public String getC_carNumber() {
		return c_carNumber;
	}

	public void setC_carNumber(String cCarNumber) {
		c_carNumber = cCarNumber;
	}

	public String getC_color() {
		return c_color;
	}

	public void setC_color(String cColor) {
		c_color = cColor;
	}

	public long getC_carprice() {
		return c_carprice;
	}

	public void setC_carprice(long cCarprice) {
		c_carprice = cCarprice;
	}

	public String getC_remark() {
		return c_remark;
	}

	public void setC_remark(String cRemark) {
		c_remark = cRemark;
	}

	public String getC_brand() {
		return c_brand;
	}

	public void setC_brand(String cBrand) {
		c_brand = cBrand;
	}

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String cType) {
		c_type = cType;
	}

	public long getC_price() {
		return c_price;
	}

	public void setC_price(long cPrice) {
		c_price = cPrice;
	}

	public int getC_ifrent() {
		return c_ifrent;
	}

	public void setC_ifrent(int cIfrent) {
		c_ifrent = cIfrent;
	}

	public int getC_ifputaway() {
		return c_ifputaway;
	}

	public void setC_ifputaway(int cIfputaway) {
		c_ifputaway = cIfputaway;
	}

	@Override
	public String toString() {
		return "Car [c_brand=" + c_brand + ", c_carNumber=" + c_carNumber
				+ ", c_carprice=" + c_carprice + ", c_color=" + c_color
				+ ", c_id=" + c_id + ", c_ifputaway=" + c_ifputaway
				+ ", c_ifrent=" + c_ifrent + ", c_name=" + c_name
				+ ", c_price=" + c_price + ", c_remark=" + c_remark
				+ ", c_type=" + c_type + "]";
	}
}
