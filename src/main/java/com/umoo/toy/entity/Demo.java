package com.umoo.toy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Demo {
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
