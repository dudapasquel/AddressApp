package ch.makery.address.model;

import java.io.File;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import ch.makery.address.MainApp;
import ch.makery.address.model.interfaces.ISavePerson;

public class SavePersonDataToFile implements ISavePerson {

	public SavePersonDataToFile(){}

	public SavePersonDataToFile(File file){
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


	public void savePersonDataToFile(PersonList personList) throws Exception {

        JAXBContext context = JAXBContext
                .newInstance(PersonListWrapper.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        PersonListWrapper wrapper = new PersonListWrapper();
        wrapper.setPersons(personList.getPersonData());

        m.marshal(wrapper, getPersonFilePath());

	}
}
