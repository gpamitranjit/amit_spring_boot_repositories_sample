package com.amdocs.models;


/**
 * @author Amit
 *
 */
public final class TodoSearchResultDTO {
	 
    private Long id;
 
    private String title;
 
    public TodoSearchResultDTO() {}
 
    public Long getId() {
        return id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
}