package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marks")
public class Marks {
	
	@Id
	@Column(name="usn")
	private String usn;
	
	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	@Column(name="BEMarks")
	private String beMarks;
	
	@Column(name="SSLCMarks")
	private String sslcMarks;
	
	@Column(name="PUCMarks")
	private String pucMarks;

	public String getBeMarks() {
		return beMarks;
	}

	public void setBeMarks(String beMarks) {
		this.beMarks = beMarks;
	}

	public String getSslcMarks() {
		return sslcMarks;
	}

	public void setSslcMarks(String sslcMarks) {
		this.sslcMarks = sslcMarks;
	}

	public String getPucMarks() {
		return pucMarks;
	}

	public void setPucMarks(String pucMarks) {
		this.pucMarks = pucMarks;
	}
}
