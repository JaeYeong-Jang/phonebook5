package com.javaex.vo;

public class PersonVo {
	
	//Fields
	private int personId;
	private String name;
	private String hp;
	private String company;
	
	//Constructors
	public PersonVo() {
		
	}
	
	public PersonVo(int personId) {
		this.personId = personId;
		
	}
	
	public PersonVo(String name,String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
		
	}
	
	public PersonVo(int personId, String name, String hp, String company) {
		this.personId = personId;
		this.name = name;
		this.hp = hp;
		this.company = company;
		
	}

	//g/s
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int presonId) {
		this.personId = presonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "PersonVo [presonId=" + personId + ", name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
	
	//Method
	
	
}
