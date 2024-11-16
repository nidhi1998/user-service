package com.wipro.user.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
@Table(name = "team")
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Name cannot be null
    private String name;

    @Column
    private String size;

    @Column
    private String createdBy;

    @Column
    private String details;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<TeamUserMapping> teamUserMappings;
    // Default constructor
    public Team() {
    }
    
    public Set<TeamUserMapping> getTeamUserMappings() {
		return teamUserMappings;
	}

	public void setTeamUserMappings(Set<TeamUserMapping> teamUserMappings) {
		this.teamUserMappings = teamUserMappings;
	}

	

	// Parameterized constructor
    public Team(String name, String size, String createdBy, String details) {
        this.name = name;
        this.size = size;
        this.createdBy = createdBy;
        this.details = details;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
