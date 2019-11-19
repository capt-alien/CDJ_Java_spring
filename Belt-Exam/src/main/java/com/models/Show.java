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

@Entity
@Table(name="shows")
public class Show {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 
	 private String title;
	 private String network;
	 
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 //MANY TO MANY RATINGS
//	 @ManyToMany(fetch = FetchType.LAZY)
//	 @JoinTable(
//			 name="show_ratings",
//			 joinColumns = @JoinColumn(name="show_id"),
//			 inverseJoinColumns = @JoinColumn(name="user_id")
//			 )
//	 private Double ratings;
	 
	 public Show() {
	 }
	 
	public Show(String title, String network) {
		this.title = title;
		this.network = network;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
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
	 
//	 END
}
