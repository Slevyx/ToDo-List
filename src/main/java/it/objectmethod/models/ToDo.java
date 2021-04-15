package it.objectmethod.models;

public class ToDo {

	private Integer id;
	private String description;
	private Boolean done;
	private Boolean modified;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getDone() {
		return done;
	}
	
	public void setDone(Boolean done) {
		this.done = done;
	}
	
	public Boolean getModified() {
		return modified;
	}
	
	public void setModified(Boolean modified) {
		this.modified = modified;
	}
}
