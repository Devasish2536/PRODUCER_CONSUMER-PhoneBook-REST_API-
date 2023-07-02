package com.devatechno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devatechno.bean.Contact;
import com.devatechno.service.PhoneServiceInterface;

@Controller
public class PhoneController {
	@Autowired
	private PhoneServiceInterface service;
	@GetMapping("/")
    public String loadForm(Model model) {
		model.addAttribute("contact",new Contact());
	return"index";
}
	@PostMapping("/add")
	public String addContact(@ModelAttribute("contact") Contact contact, Model model) {
		String msg=service.add(contact);
		model.addAttribute("msg", msg);
		return "index";
	}
	@GetMapping("/getAll")
	public String getAllContact(Model model) {
	List<Contact>contactList=service.getAll();
	model.addAttribute("contactList", contactList);
		return "contactList";
	}

	@GetMapping("/edit")
	public String updateContact(@RequestParam("id")Integer id,Model model) {
		Contact contact=service.getById(id);
		model.addAttribute("contact",contact );
		return "index";
	}
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("id")Integer id,Model model) {
		String msg=service.delete(id);
		List<Contact>contactList=service.getAll();
		model.addAttribute("contactList", contactList);
		model.addAttribute("msg", msg);
		return "contactList";
	}

}
