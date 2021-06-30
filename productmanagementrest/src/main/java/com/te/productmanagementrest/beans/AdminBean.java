package com.te.productmanagementrest.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "admin")
@XmlRootElement(name = "admin")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@XmlElement
	@JsonProperty
	private int aid;
	
	@Column
	@XmlElement
	@JsonProperty
	private String aname;
	
	@Column
	@XmlElement
	@JsonProperty
	private String password;
}
