package View;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import Utils.ImportInitialData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class HomeController {
    @FXML
    Button btnStudents1, btnClasses, btnTeachers, btnRooms, btnCourses, btnLessons,
            btnSchedule, btnHome, firstInitial;



    //********** METHOD TO BE DELETED WHEN ITS TIME COMES **********\\

    public void switchToSceneHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource("Home.fxml"))
        );
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage window = (Stage) btnHome.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));

        window.show();

    }

    @FXML
     void websiteLink (ActionEvent event) throws URISyntaxException,IOException{
        Desktop.getDesktop().browse(new URI("https://google.com"));
    }

    public void switchToSceneStudents(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource("Students.fxml"))
        );
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage window = (Stage) btnStudents1.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));

        window.show();

    }


    public void switchToSceneClasses() throws IOException {
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource("Classes.fxml"))
        );
        Stage window = (Stage) btnClasses.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));

        window.show();

    }

    public void switchToSceneTeachers() throws IOException {
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource("Teachers.fxml"))
        );
        Stage window = (Stage) btnTeachers.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));

        window.show();

    }

    public void switchToSceneRooms() throws IOException {
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource("Rooms.fxml"))
        );
        Stage window = (Stage) btnRooms.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));

        window.show();

    }

    public void switchToSceneCourses() throws IOException {
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource("Courses.fxml"))
        );
        Stage window = (Stage) btnCourses.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));

        window.show();

    }

    public void switchToSceneLessons() throws IOException {
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource("Lessons.fxml"))
        );
        Stage window = (Stage) btnLessons.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));

        window.show();

    }

    public void switchToSceneSchedule() throws IOException {
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource("Schedule.fxml"))
        );
        Stage window = (Stage) btnSchedule.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));
        window.show();
    }


    @FXML
    public void firstInitial(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to import initial data " + " ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Import Data");
        alert.setHeaderText("Do you want to import initial data " + " ?");
        alert.setContentText("Do not import data more then once. Doing this will lead to stored data being lost");

        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            ImportInitialData.importData();
        }
    }
}


    //******* Hyperlink method!!! *******\\



