package com.devatechno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devatechno.binding.PhoneBook;

@Repository
public interface PhoneRepo extends JpaRepository<PhoneBook, Integer>{

}
