package ch.makery.address.model;

import java.io.File;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import ch.makery.address.MainApp;
import ch.makery.address.model.interfaces.ILoadPerson;

public class LoadPersonDataToFile implements ILoadPerson {

	public LoadPersonDataToFile(){}

	public LoadPersonDataToFile(File file){
		setPersonFilePath(file);
	}

	public File getPersonFilePath() {
	    Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
	    String filePath = prefs.get("filePath", null);
	    if (filePath != null) {
	        return new File(filePath);
	    } else {
	        return null;
	    }
	}

	public void setPersonFilePath(File file) {
	    Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
	    if (file != null) {
	        prefs.put("filePath", file.getPath());

	    } else {
	        prefs.remove("filePath");
	    }
	}


	public PersonList loadPersonDataToFile() throws Exception {
		PersonList personList = new PersonList();

		JAXBContext context = JAXBContext
                .newInstance(PersonListWrapper.class);
        Unmarshaller um = context.createUnmarshaller();

        PersonListWrapper wrapper = (PersonListWrapper) um.unmarshal(getPersonFilePath());

        personList.getPersonData().addAll(wrapper.getPersons());

        return personList;
	}
}
