package com.devatechno.service;

import java.util.List;

import com.devatechno.binding.PhoneBook;


public interface PhoneServiceInterface {
	public String upsertData(PhoneBook phoneBook);
	public PhoneBook getById(Integer id);
	public List<PhoneBook> getAll();
	public String deleteById(Integer id);
}
