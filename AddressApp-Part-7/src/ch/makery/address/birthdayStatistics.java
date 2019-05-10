package ch.makery.address;

import javafx.application.Preloader;
import javafx.stage.Stage;
import java.io.IOException;

import ch.makery.address.model.Person;
import ch.makery.address.view.BirthdayStatisticsController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

public class birthdayStatistics extends Preloader {

	 /**
     * Opens a dialog to show birthday statistics.
     */

	private Stage primaryStage;
	private ObservableList<Person> personData = FXCollections.observableArrayList();

	public void showBirthdayStatistics() {
        try {
            // Load the fxml file and create a new stage for the popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BirthdayStatistics.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Birthday Statistics");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the persons into the controller.
            BirthdayStatisticsController controller = loader.getController();
            controller.setPersonData(personData);

            // Set the dialog icon.
            dialogStage.getIcons().add(new Image("file:resources/images/calendar.png"));

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void start(Stage primaryStage) throws Exception {
		showBirthdayStatistics();
	}
}





