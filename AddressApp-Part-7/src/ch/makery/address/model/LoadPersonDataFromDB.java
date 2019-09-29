package ch.makery.address.model;

import java.util.List;

import ch.makery.address.model.dao.PersonDAO;
import ch.makery.address.model.interfaces.ILoadPerson;
import javafx.collections.FXCollections;

public class LoadPersonDataFromDB implements ILoadPerson{

	public PersonList loadPersonDataToFile() throws Exception{
		PersonList personList = new PersonList();

	    PersonDAO personDao = new PersonDAO();

		List<Person> pessoas = personDao.listAll();
        personList.setPersonData(FXCollections.observableArrayList(pessoas));

		return personList;
	}
}
