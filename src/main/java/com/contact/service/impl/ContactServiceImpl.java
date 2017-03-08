package com.contact.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.contact.db.ContactDb;
import com.contact.response.ResponseContact;
import com.contact.service.ContactService;
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDb contactDb;

	@Override
	public String addContact(ResponseContact responseContact) {
		String response = null;
		if (!StringUtils.isEmpty(responseContact)) {
			response = contactDb.addContact(responseContact);
		}
		return response;
	}

	@Override
	public ResponseContact getContact() {
		return contactDb.getContact();
	}

	@Override
	public String updateContact(ResponseContact responseContact) {
		return contactDb.updateContact(responseContact);
	}

	@Override
	public List<ResponseContact> getAll() {
		return contactDb.getAll();
	}

}
