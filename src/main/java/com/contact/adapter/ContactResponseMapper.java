package com.contact.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class ContactResponseMapper {
	public static com.contact.request.RequestContact convertResponseToRequest(
			com.contact.response.ResponseContact responseContact) {

		com.contact.request.RequestContact requestContact = null;
		if (!StringUtils.isEmpty(responseContact)) {
			requestContact = new com.contact.request.RequestContact();
			requestContact.setId(responseContact.getId());
			requestContact.setName(responseContact.getName());
			requestContact.setEmail(responseContact.getEmail());
			requestContact.setMobile(responseContact.getMobile());
			requestContact.setMessage(responseContact.getMessage());
		}
		return requestContact;
	}

	public static List<com.contact.request.RequestContact> convertResponseToRequestList(
			List<com.contact.response.ResponseContact> responseContacts) {

		if (responseContacts.isEmpty()) {
			return null;
		}

		List<com.contact.request.RequestContact> requestContacts = new ArrayList<com.contact.request.RequestContact>();
		for (com.contact.response.ResponseContact responseContact : responseContacts) {
			requestContacts.add(convertResponseToRequest(responseContact));
		}
		return requestContacts;

	}
}
