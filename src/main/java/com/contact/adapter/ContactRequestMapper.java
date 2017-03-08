package com.contact.adapter;

import org.springframework.util.StringUtils;

public class ContactRequestMapper {
	
	public static com.contact.response.ResponseContact convertRequestToResponse(
			com.contact.request.RequestContact requestContact) {
		
		com.contact.response.ResponseContact responseContact = null;
		if (!StringUtils.isEmpty(requestContact)) {
			responseContact = new com.contact.response.ResponseContact();
			responseContact.setId(requestContact.getId());
			responseContact.setName(requestContact.getName());
			responseContact.setEmail(requestContact.getEmail());
			responseContact.setMobile(requestContact.getMobile());
			responseContact.setMessage(requestContact.getMessage());

		}
		return responseContact;

	}
}
