package ch.makery.address;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ch.makery.address.view.BirthdayStatisticsController;

public class MainApp extends Application {

    public graphicInterface layout = new graphicInterface();
    public addPerson add = new addPerson();

    public MainApp() {
        add.newPerson("Duda", "Pasquel");
        add.newPerson("Leo", "Caetano");
        add.newPerson("Babi", "Martins");
        add.newPerson("Ana", "Pimenta");
        add.newPerson("Pedro", "Paulo");
        add.newPerson("Xoão", "Pedro");
        add.newPerson("Dolly", "Guaraná");
        add.newPerson("Nicoly", "Dandara");
        add.newPerson("Anna", "Dornelas");
    }

    public void showBirthdayStatistics() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BirthdayStatistics.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Birthday Statistics");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(layout.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            BirthdayStatisticsController controller = loader.getController();
            controller.setPersonData(add.getPersonData());

            dialogStage.getIcons().add(new Image("file:resources/images/calendar.png"));

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	graphicInterface layout = new graphicInterface();
    	Platform.runLater(new Runnable() {
    	    @Override
    	    public void run() {
    	    	layout.start( new Stage());
    	    }
    	});
        
    }

	@Override
	public void start(Stage arg0) throws Exception {

	}
}