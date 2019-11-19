package com.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
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
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@NotBlank(message="You Must Enter a first Name")
	@Size(min=2, max=60, message="First Name must be more than 2 char!")
    private String firstName;

	@NotBlank(message="You Must Enter a last Name")
	@Size(min=2, max=60, message="Last Name must be more than 2 char!")
    private String lastName;
	
	@NotBlank(message="You must enter an email adress!")
	@Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-zA-Z0-9.-]+$", message="Invalid email pattern")
	@Email(message="Please enter a valid email.")
    private String email;
    private String password;
    
    @Transient
    private String passwordConfirmation;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
	 //MANY TO MANY RATINGS
//	 @ManyToMany(fetch = FetchType.LAZY)
//	 @JoinTable(
//			 name="show_ratings",
//			 inverseJoinColumns = @JoinColumn(name="user_id"),
//			 joinColumns = @JoinColumn(name="show_id")
//			 )
//	 private Double ratings;
    
    public User() {
    }
    
    public User(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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

//	public Double getRatings() {
//		return ratings;
//	}
//
//	public void setRatings(Double ratings) {
//		this.ratings = ratings;
//	}
	
}
