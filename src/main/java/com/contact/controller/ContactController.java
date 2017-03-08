package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.contact.adapter.ContactRequestMapper;
import com.contact.adapter.ContactResponseMapper;
import com.contact.request.RequestContact;
import com.contact.response.ResponseContact;
import com.contact.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value ="/addContact", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String AddContact(@RequestBody RequestContact requestContact){
		String response = contactService.addContact(ContactRequestMapper.convertRequestToResponse(requestContact));
		return response;
	}
	
	@RequestMapping(value = "/getContact", method = RequestMethod.GET)
	public RequestContact getContact() {
		ResponseContact response = contactService.getContact();
		return ContactResponseMapper.convertResponseToRequest(response);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<RequestContact> getAll() {
		
		return ContactResponseMapper.convertResponseToRequestList(contactService.getAll());
	}
	
	@RequestMapping(value = "/updateContact", method = RequestMethod.PUT)
	public String updateContent(@RequestBody RequestContact requestContact) {

		return contactService.updateContact(ContactRequestMapper.convertRequestToResponse(requestContact));
	}

}
