package com.kc.model;

public class CaseStatus {
    private Byte id;

    private String name;

    
    public Byte getId() {
		return id;
	}

	public void setId(Byte id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CaseStatus [id=" + id + ", name=" + name + ", getName()=" + getName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}