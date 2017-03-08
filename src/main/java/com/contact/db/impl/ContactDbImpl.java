package com.contact.db.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.contact.constants.QueryConstant;
import com.contact.db.ContactDb;
import com.contact.extractor.ContactExtractor;
import com.contact.response.ResponseContact;

@Repository
public class ContactDbImpl implements ContactDb{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public String addContact(ResponseContact responseContact) {
		String response = null;
		if (!StringUtils.isEmpty(responseContact)){
			Object args[] = { responseContact.getName(), responseContact.getEmail(), responseContact.getMobile(),
					responseContact.getMessage() };
			int add = jdbcTemplate.update(QueryConstant.ADD_CONTENT, args);
			if (add > 0) {
				response = "Successfully inserted";
			} else {
				response = "unable to insert it";
			}
		}
		return response;
	}

	@Override
	public ResponseContact getContact() {
		List<ResponseContact> responseContact = jdbcTemplate.query(QueryConstant.GET_CONTENT, new ContactExtractor());
		if (!responseContact.isEmpty()) {
			return responseContact.get(0);
		}
		return new ResponseContact();
	}

	@Override
	public String updateContact(ResponseContact responseContact) {
		String response = null;
		if (!StringUtils.isEmpty(responseContact)) {
			Object args[] = { responseContact.getName(), responseContact.getMobile(),
					responseContact.getMessage(), responseContact.getEmail() };
			int add = jdbcTemplate.update(QueryConstant.UPDATE_CONTENT, args);
			if (add > 0) {
				response = "Successfully Updated";
			} else {
				response = "unable to insert it";
			}
		}
		return response;
	}

	@Override
	public List<ResponseContact> getAll() {
		List<ResponseContact> responseContacts = jdbcTemplate.query(QueryConstant.GET_ALL, new ContactExtractor());
		return responseContacts;
	}

}
