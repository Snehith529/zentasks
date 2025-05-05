package com.example.zentasks.dto;

import java.util.List;

public class TaskDTO {
	public TaskDTO(Long id, String title, String description, Long userId, List<Long> tagIds) {
	    this.id = id;
	    this.title = title;
	    this.description = description;
	    this.userId = userId;
	    this.tagIds = tagIds;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<Long> getTagIds() {
		return tagIds;
	}
	public void setTagIds(List<Long> tagIds) {
		this.tagIds = tagIds;
	}
	private Long id;
    private String title;
    private String description;
    private Long userId;
    private List<Long> tagIds;
    // Getters/Setters
}