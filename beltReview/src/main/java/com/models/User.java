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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	
	
//	FIELDS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
//	FIRST NAME
	@NotBlank(message="You Must Enter a first Name")
	@Size(min=2, max=60, message="first Name must be more than 2 charictors!")
	String firstName;
	
//	LAST NAME
	@NotBlank(message="You Must Enter a last Name")
	@Size(min=2, max=60, message="Last Name must be more than 2 charictors!")
	String lastName;
	
//	EMAIL
	@NotBlank(message="You must enter an email adress!")
	@Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-zA-Z0-9.-]+$", message="Invalid email pattern")
	@Email(message="Please enter a valid email.")
	private String email;
	
//	LOCATION
	@NotBlank(message="You Must Enter a location")
	@Size(min=2, max=60, message="Location must be more than 2 charictors!")
	private String location;
	
	private String state;
	
//	Password
	@NotBlank(message="You Must Enter a Password")
	@Size(min=2, max=60, message="Last Name must be more than 2 charictors!")
	private String password;
	
	@Transient
	@NotBlank(message="Must Enter password confirmation")
	private String confirmPassword;

	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
    //RELATIONSHIPS
    @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
    private List<Event> hostedEvents;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
   		 name="events_users",
   		 joinColumns = @JoinColumn(name="user_id"),
   		 inverseJoinColumns = @JoinColumn(name="event_id"))
    private List<Event> joinedEvents;
	
	
	

//	CONSTRUCTORS
	public User() {
	}

	public User(
			String firstName,
			String lastName,
			String email,
			String location,
			String state,
			String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.location = location;
		this.state = state;
		this.password = password;
	}

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	public List<Event> getHostedEvents() {
		return hostedEvents;
	}

	public void setHostedEvents(List<Event> hostedEvents) {
		this.hostedEvents = hostedEvents;
	}

	public List<Event> getJoinedEvents() {
		return joinedEvents;
	}

	public void setJoinedEvents(List<Event> joinedEvents) {
		this.joinedEvents = joinedEvents;
	}
	
//	END USER MODEL
}
