package com.hiber.Service;

import java.util.List;

import com.hiber.Entity.Mobile;
import com.hiber.Entity.Person;

public interface PersonDao {
	
	List<Mobile> getMobiles();
	List<Person> getPerson();
	void saveMobile(Mobile mob);
	void savePerson(Person per);
	void deletePerson(Long Id);
	void deleteMobile(Long Id);
	void updateMobile(Mobile mob, Long Id);
	void updatePerson(Person per, Long  Id);
	Mobile getMobileById(Long Id);
	Person getPersonById(Long Id);
	List<Mobile> getMobileByPersonId(Long Id);
}
