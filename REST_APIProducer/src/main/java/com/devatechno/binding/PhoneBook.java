package com.devatechno.binding;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="phoneBook_tab")
public class PhoneBook {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;
 private String name;
 private Long number;
 private String email;
}
