package com.contact.db;

import java.util.List;

import com.contact.response.ResponseContact;

public interface ContactDb {
	
	public String addContact(ResponseContact responseContact);

	public ResponseContact getContact();

	public String updateContact(ResponseContact responseContact);
	
	public List<ResponseContact> getAll();
}
