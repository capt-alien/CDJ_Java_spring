package com.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="license")
public class License {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column 
	private String number;
	
	@Column
	@NotNull(message="You must enter an expiration date.")
	@DateTimeFormat(pattern ="yyyy-mm-dd")
	private Date expiration_date;
	
	@Column
	@NotNull(message="Please Enter a State.")
	private String state;
	
	@Column
    @DateTimeFormat(pattern = "mm/dd/yyyy hh:mm:ss")
    private Date created_at;

    @Column
    @DateTimeFormat(pattern = "mm/dd/yyyy hh:mm:ss")
    private Date updated_at;
    
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;
	
	public License() {
	}

	public License(Long id, String number,
			@NotNull(message = "You must enter an expiration date.") Date expiration_date,
			@NotNull(message = "Please Enter a State.") String state) {
		super();
		this.id = id;
		this.number = number;
		this.expiration_date = expiration_date;
		this.state = state;
	}
    @PrePersist
    protected void onCreate() {
    	this.created_at = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
    	this.updated_at = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
//END
}
