package com.contact.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.contact.response.ResponseContact;

public class ContactExtractor implements
		ResultSetExtractor<List<ResponseContact>> {

	@Override
	public List<ResponseContact> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<ResponseContact> responseContacts = new ArrayList<ResponseContact>();
		ResponseContact responseContact = null;
		while(rs.next()){
			responseContact = new ResponseContact();
			responseContact.setId(rs.getInt("id"));
			responseContact.setName(rs.getString("name"));
			responseContact.setEmail(rs.getString("email"));
			responseContact.setMobile(rs.getString("mobile"));
			responseContact.setMessage(rs.getString("message"));
			responseContacts.add(responseContact);
		}
		return responseContacts;
	}

}
