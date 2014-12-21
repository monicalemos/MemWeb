package pt.memplus.web.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//TODO
@Entity
@Table(name="Event")
public class Event {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int relatedToPersonId;
	private String title;
	private String description;
	private Date  dateOfOccurance;
	
	public Event() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRelatedToPersonId() {
		return relatedToPersonId;
	}
	public void setRelatedToPersonId(int personId) {
		this.relatedToPersonId = personId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDateOfOccurance() {
		return dateOfOccurance;
	}
	public void setDateOfOccurance(Date dateOfOccurance) {
		this.dateOfOccurance = dateOfOccurance;
	}
	
	
	

}
