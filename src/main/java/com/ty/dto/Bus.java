package com.ty.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busid;
	private String busname;
	private String fromplace;
	private String toplace;
	
	@OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
	private List<Stop> stop = new ArrayList<Stop>();
	
		public List<Stop> getStop() {
		return stop;
	}
	public void setStop(List<Stop> stop) {
		this.stop = stop;
	}
		public String getFromplace() {
		return fromplace;
	}
	public void setFromplace(String fromplace) {
		this.fromplace = fromplace;
	}
	public String getToplace() {
		return toplace;
	}
	public void setToplace(String toplace) {
		this.toplace = toplace;
	}
	public int getBusid() {
		return busid;
	}
	public void setBusid(int busid) {
		this.busid = busid;
	}
	public String getBusname() {
		return busname;
	}
	public void setBusname(String busname) {
		this.busname = busname;
	}

}
