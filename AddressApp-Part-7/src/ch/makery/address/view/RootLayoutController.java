package ch.makery.address.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import ch.makery.address.MainApp;
import ch.makery.address.model.LoadPersonDataToFile;
import ch.makery.address.model.PersonList;
import ch.makery.address.model.SavePersonDataToFile;
import ch.makery.address.model.dao.PersonDAO;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 *
 * @author Marco Jakob
 */
public class RootLayoutController {

    // Reference to the main application
    private MainApp mainApp;
    private PersonList personList;
    private PersonDAO personDao = new PersonDAO();

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        personList = mainApp.getPersonList();
    }

    /**
     * Creates an empty address book.
     */
    @FXML
    private void handleNew() {
        mainApp.getPersonList().getPersonData().clear();
        try {
			personDao.removeAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //mainApp.setPersonFilePath(null);
    }

    /**
     * Opens a FileChooser to let the user select an address book to load.
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
        	LoadPersonDataToFile loadFile = new LoadPersonDataToFile(file);

        	try {
				personList = loadFile.loadPersonDataToFile();
			} catch (Exception e) {
				showErrorAlertSaveData(file.getPath());
			}
        }
    }

    /**
     * Saves the file to the person file that is currently open. If there is no
     * open file, the "save as" dialog is shown.
     */
    @FXML
    private void handleSave() {
       /* File personFile = mainApp.getPersonFilePath();
        if (personFile != null) {
        	SavePersonDataToFile savePerson = new SavePersonDataToFile(personFile);

        	try{
        		savePerson.savePersonDataToFile(personList);
        	} catch(Exception ex){
        		showErrorAlertSaveData(personFile.getPath());
        	}

    	} else {
            handleSaveAs();
        }*/
    }

    /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    @FXML
    private void handleSaveAs() {
        /*FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }

            SavePersonDataToFile savePerson = new SavePersonDataToFile(file);

        	try{
        		savePerson.savePersonDataToFile(personList);
        	} catch(Exception ex){
        		showErrorAlertSaveData(file.getPath());
        	}
        }*/
    }

    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("AddressApp");
    	alert.setHeaderText("About");
    	alert.setContentText("Author: Marco Jakob\nWebsite: http://code.makery.ch");

    	alert.showAndWait();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }

    /**
     * Opens the birthday statistics.
     */
    @FXML
    private void handleShowBirthdayStatistics() {
      mainApp.showBirthdayStatistics();
    }

	private void showErrorAlertSaveData(String caminhoArquivo) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Could not save data");
		alert.setContentText("Could not save data to file:\n" + caminhoArquivo);

		alert.showAndWait();
	}
}