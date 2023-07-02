package com.devatechno.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.devatechno.bean.Contact;
@Service
public class PhoneServiceImpl implements PhoneServiceInterface {
	
	String addUrl="http://localhost:2536/add";
	String deleteUrl="http://localhost:2536/delete/{id}";
	String getUrl="http://localhost:2536/get/{id}";
	String getAllUrl="http://localhost:2536/getAll";
	String updateUrl="http://localhost:2536/update";

	@Override
	public String add(Contact contact) {
		WebClient webClient=WebClient.create();
		String msg=webClient.post().uri(addUrl).bodyValue(contact)
				.retrieve().bodyToMono(String.class).block();
		return msg;
	}

	@Override
	public String update(Contact contact) {
		WebClient webClient=WebClient.create();
		String msg=webClient.put().uri(updateUrl).bodyValue(contact).retrieve()
		.bodyToMono(String.class).block();
		return msg;
	}

	@Override
	public String delete(Integer id) {
		WebClient webClient=WebClient.create();
		String msg=webClient.delete ().uri(deleteUrl,id).retrieve()
		.bodyToMono(String.class).block();
		return msg;
	
	}

	@Override
	public Contact getById(Integer id) {
		WebClient webClient=WebClient.create();
		Contact contact=webClient.get().uri(getUrl,id).retrieve()
		.bodyToMono(Contact.class).block();
		return contact;
	}

	@Override
	public List<Contact> getAll() {
		WebClient webClient=WebClient.create();
		@SuppressWarnings("unchecked")
		List<Contact>contactList=webClient.get().uri(getAllUrl).retrieve()
		.bodyToMono(List.class).block();
		return contactList;
	
	}

}
