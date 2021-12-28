package com.harman.dto;

public class CellularInfo {
	
	
//	public int _id;
//
//	private double rsrp;
//	
//	private double rsrq;
//	
//	private double snr;
//	
//	private double pci;
	
	private String phnNo;


	private String city;



	public String getPhnNo() {
		return phnNo;
	}

	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}



	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

		
	
	@Override
	public String toString() {
		return "CellularInfo :phnNo= " + phnNo + ", city=" + city + "]";
	}
	
	
	
	

}
