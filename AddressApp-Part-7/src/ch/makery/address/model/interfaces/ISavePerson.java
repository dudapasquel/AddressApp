package ch.makery.address.model.interfaces;

import ch.makery.address.model.PersonList;

public interface ISavePerson {
	void savePersonDataToFile(PersonList personList) throws Exception;
}
