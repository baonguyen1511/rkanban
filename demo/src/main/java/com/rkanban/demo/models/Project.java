package com.rkanban.demo.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "project")
public class Project {
    @Id
    private int id;
    @NotBlank
    private String identifier;
    @NotBlank
    private String name;
    @NotBlank
    private int status;
    @NotBlank
    private Timestamp created_on;
    @NotBlank
    private Timestamp updated_on;
    private Integer parent_id;
    
    // public long getId() {
    // return id;
    // }
    // public void setId(Integer id) {
    // this.id = id;
    // }
    // public String getIdentifier() {
    // return identifier;
    // }
    // public void setIdentifier(String identifier) {
    // this.identifier = identifier;
    // }
    // public String getName() {
    // return name;
    // }
    // public void setName(String name) {
    // this.name = name;
    // }
    // public int getStatus() {
    // return status;
    // }
    // public void setStatus(int status) {
    // this.status = status;
    // }
    // public Timestamp getCreated_on() {
    // return created_on;
    // }
    // public void setCreated_on(Timestamp created_on) {
    // this.created_on = created_on;
    // }
    // public Timestamp getUpdated_on() {
    // return updated_on;
    // }
    // public void setUpdated_on(Timestamp updated_on) {
    // this.updated_on = updated_on;
    // }
    // public long getParent_id() {
    // return parent_id;
    // }
    // public void setParent_id(Integer parent_id) {
    // this.parent_id = parent_id;
    // }    
    
}
