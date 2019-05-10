package ch.makery.address;

import ch.makery.address.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class addPerson{
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	public ObservableList<Person> getPersonData() {
        return personData;
    }

    public void newPerson (String personFirstName, String personLastName) {
    	personData.add(new Person("personFirstName", "personLastName"));
    }
}
