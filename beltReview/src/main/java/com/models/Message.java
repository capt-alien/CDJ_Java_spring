package com.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="messages")
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Size(min=1, message="message connot be empty")
	private String content;
	
    private Date createdAt;
    private Date updatedAt;

    
//    many to one event 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="event_id")
	private Event event;
    
//    many to one user
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="event_id")
	private User author ;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
	
//	CONSTRUCTORS
	public Message() {
	}

public Message(String content, Event event, User author) {
	super();
	this.content = content;
	this.event = event;
	this.author = author;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public Event getEvent() {
	return event;
}

public void setEvent(Event event) {
	this.event = event;
}

public User getAuthor() {
	return author;
}

public void setAuthor(User author) {
	this.author = author;
}
	
}
