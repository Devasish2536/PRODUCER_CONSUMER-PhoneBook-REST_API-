package com.devatechno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devatechno.binding.PhoneBook;
import com.devatechno.repository.PhoneRepo;
@Service
public class PhoneServiceImpl implements PhoneServiceInterface {
	@Autowired
	private PhoneRepo repo;

	@Override
	public String upsertData(PhoneBook phoneBook) {
	repo.save(phoneBook);
	String msg="Successfylly added";	
		return msg;
	}

	@Override
	public PhoneBook getById(Integer id) {
		  Optional<PhoneBook> optional =  repo.findById(id);
		  if(optional.isPresent()) {
			  return optional.get();
		  }
		return null;
	}

	@Override
	public List<PhoneBook> getAll() {
		 
		return repo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
	     if( repo.existsById(id)) {
	    	 repo.deleteById(id);
	    	 return "Successfully deleted";
	     }
		return null;
	}


	
}
