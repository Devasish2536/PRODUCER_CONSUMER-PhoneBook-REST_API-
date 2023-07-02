package com.devatechno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devatechno.binding.PhoneBook;
import com.devatechno.service.PhoneServiceInterface;

@RestController
public class PhoneBookController {
	@Autowired
	private PhoneServiceInterface service;
	     @PostMapping("/add")
		public ResponseEntity<String> saveData(@RequestBody PhoneBook phoneBook){
	    	String msg= service.upsertData(phoneBook);
	    	return new ResponseEntity<String>(msg,HttpStatus.CREATED);
			
		}@PutMapping("/update")
	     public ResponseEntity<String> updateData(@RequestBody PhoneBook phoneBook){
	    	 String msg=service.upsertData(phoneBook);
	    	 return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	     }
		@GetMapping("/get/{id}")
		public ResponseEntity<PhoneBook>get(@PathVariable("id")Integer id){
			PhoneBook phoneBook=service.getById(id);
			return new ResponseEntity<>(phoneBook,HttpStatus.OK);
		}
		@GetMapping("/getAll")
		public ResponseEntity<List<PhoneBook>> getAll(){
		return new ResponseEntity<List<PhoneBook>>(service.getAll(),HttpStatus.OK);	
		}
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> delete(@PathVariable("id")Integer id){
			String msg=service.deleteById(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		

}
