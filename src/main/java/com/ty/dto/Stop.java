package com.ty.dto;

import java.time.LocalTime;

import java.util.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Stop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stopid;
	
	private String stopname;
	
  private LocalTime arrivaltime;
	
	@ManyToOne
	@JoinColumn
	private Bus bus;
	
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public int getStopid() {
		return stopid;
	}
	public void setStopid(int stopid) {
		this.stopid = stopid;
	}
	public String getStopname() {
		return stopname;
	}
	public void setStopname(String stopname) {
		this.stopname = stopname;
	}
	public LocalTime getArrivaltime() {
		return arrivaltime;
	}
	public void setArrivaltime(LocalTime arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	
	

}
