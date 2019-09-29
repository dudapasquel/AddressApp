package ch.makery.address.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class PersonList{
	private ObservableList<Person> personData = FXCollections.observableArrayList();

	public ObservableList<Person> getPersonData() {
        return personData;
    }

	public void setPersonData(ObservableList<Person> lista){
		personData = lista;
	}

    public void newPerson (String personFirstName, String personLastName) {
    	personData.add(new Person("personFirstName", "personLastName"));
    }

    public void addPerson(Person person){
    	personData.add(person);
    }
}
