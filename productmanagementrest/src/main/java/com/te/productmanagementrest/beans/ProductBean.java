package com.te.productmanagementrest.beans;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "product")
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@XmlElement
	@JsonProperty
	private int pid;
	
	@Column
	@XmlElement
	@JsonProperty
	private String pname;
	@Column
	@XmlElement
	@JsonProperty
	private Date mgDate;
	@Column
	@XmlElement
	@JsonProperty
	private Date exDate;
	@Column
	@XmlElement
	@JsonProperty
	private int price;
	@Column
	@XmlElement
	@JsonProperty
	private int quantity;
	
	
	
	
}
