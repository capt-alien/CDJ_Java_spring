package com.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="events")
public class Event {
//	FIELDS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
//	EVENT NAME
	@Size(min=0, max=60, message="Event must have a Valid name with more than 2 charictors.")
	String eventName;
	
//	DATE
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date eventDate;
	
//	LOCATION
	@NotBlank(message="You Must Enter a location")
	@Size(min=2, max=60, message="Location must be more than 2 charictors!")
	private String location;
	
//	STATE
	@Size(min=2, max=2, message="Please enter two charictor state code.")
	private String state;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
////	RELATIONNSHIPS:
	@ManyToOne(fetch=FetchType.LAZY)
	private User host;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
				name="events_users",
				joinColumns= @JoinColumn(name="event_id"),
				inverseJoinColumns = @JoinColumn(name="user_id"))
	private List<User> joiners;
	
	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)
	private List<Message> messages;
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	//	CONSTRUCTORS

	public Event() {
	}

	public Event(
			String eventName,
			Date eventDate,
			String location,
			String state, User host) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.location = location;
		this.state = state;
		this.host = host;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<User> getJoiners() {
		return joiners;
	}

	public void setJoiners(List<User> joiners) {
		this.joiners = joiners;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
//	END
}
