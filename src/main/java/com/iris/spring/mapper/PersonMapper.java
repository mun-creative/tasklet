package com.iris.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iris.spring.model.Person;

/*
 * 
 * Mapper class to map a person bean from database
 */
public class PersonMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Person person=new Person();
		person.setFirstName(rs.getString("firstName"));
		person.setLastName(rs.getString("lastName"));
		person.setAddress(rs.getString("address"));
		person.setAge(rs.getInt("age"));
		person.setEmpId(rs.getInt("empId"));
		
		
		
		
		
		
		
		return person;
	}
	

}
