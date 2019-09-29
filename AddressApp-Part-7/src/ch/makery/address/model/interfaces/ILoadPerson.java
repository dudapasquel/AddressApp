package ch.makery.address.model.interfaces;

import ch.makery.address.model.PersonList;

public interface ILoadPerson {
	PersonList loadPersonDataToFile() throws Exception;
}
