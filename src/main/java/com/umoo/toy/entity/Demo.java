package com.umoo.toy.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Demo implements Serializable{
	private static final long serialVersionUID = -1662509577639174043L;
	@Id
	@GeneratedValue
	private Integer id;
	@NotNull
	private String demoName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDemoName() {
		return demoName;
	}
	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}
}
