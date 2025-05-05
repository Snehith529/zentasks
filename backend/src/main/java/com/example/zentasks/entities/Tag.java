package com.example.zentasks.entities;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Tag {
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Id @GeneratedValue private Long id;
    private String name;
}