package com.hwua.entity;

import java.sql.Date;

public class Record {
	private long r_id;
	private long car_c_id;
	private long uuser_u_id;
	private long r_total;
	private Date r_start_date;
	private Date r_end_date;
	private int r_ifback;
	
	public Record() {
		super();
	}
	public Record(long rId, long carCId, long uuserUId, long rTotal,
			Date rStartDate, Date rEndDate, int rIfback) {
		super();
		r_id = rId;
		car_c_id = carCId;
		uuser_u_id = uuserUId;
		r_total = rTotal;
		r_start_date = rStartDate;
		r_end_date = rEndDate;
		r_ifback = rIfback;
	}
	public long getR_id() {
		return r_id;
	}
	public void setR_id(long rId) {
		r_id = rId;
	}
	public long getCar_c_id() {
		return car_c_id;
	}
	public void setCar_c_id(long carCId) {
		car_c_id = carCId;
	}
	public long getUuser_u_id() {
		return uuser_u_id;
	}
	public void setUuser_u_id(long uuserUId) {
		uuser_u_id = uuserUId;
	}
	public long getR_total() {
		return r_total;
	}
	public void setR_total(long rTotal) {
		r_total = rTotal;
	}
	public Date getR_start_date() {
		return r_start_date;
	}
	public void setR_start_date(Date rStartDate) {
		r_start_date = rStartDate;
	}
	public Date getR_end_date() {
		return r_end_date;
	}
	public void setR_end_date(Date rEndDate) {
		r_end_date = rEndDate;
	}
	public int getR_ifback() {
		return r_ifback;
	}
	public void setR_ifback(int rIfback) {
		r_ifback = rIfback;
	}
	@Override
	public String toString() {
		return "Record [car_c_id=" + car_c_id + ", r_end_date=" + r_end_date
				+ ", r_id=" + r_id + ", r_ifback=" + r_ifback
				+ ", r_start_date=" + r_start_date + ", r_total=" + r_total
				+ ", uuser_u_id=" + uuser_u_id + "]";
	}
}
