package com.devatechno.service;

import java.util.List;

import com.devatechno.bean.Contact;

public interface PhoneServiceInterface {
	public String add(Contact contact);
	public String update(Contact contact);
	public String delete(Integer id);
	public Contact getById(Integer id);
	public List<Contact> getAll();

}
