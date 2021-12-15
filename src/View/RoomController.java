package View;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class RoomController implements Initializable
{
    @FXML private Button btnHome, btnSave;
    @FXML private ListView<Room> allRoomsList;
    @FXML
    private TableView<Room> rooms;
    @FXML private TableColumn<Room,Integer> roomNumber;
    @FXML private TableColumn<Room,String> block;
    @FXML private TableColumn<Room,Integer> floor;
    @FXML private TableColumn<Student,Integer> capacity;
    private Room room;
    private RoomList roomList;
    private RoomList tempList;
    private ObservableList<RoomList> allRooms;
    private RoomList removedRooms;
    private int numberOfRemovedRooms = 0;
    private ScheduleModelManager scheduleManager = new ScheduleModelManager("src/Files/students.bin",
            "src/Files/teachers.bin", "src/Files/classes.bin", "src/Files/courses.bin",
            "src/Files/rooms.bin", "src/Files/lessons.bin");
    @FXML private TextField roomNumberField;
    @FXML private TextField blockField;
    @FXML private TextField floorField;
    @FXML private TextField capacityField;
    @FXML private TextField capacityField1;
    @FXML private ComboBox roomBox;



    public void switchToSceneHome(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource("Home.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage window = (Stage) btnHome.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));
        window.show();

    }



    public void initialize(URL url, ResourceBundle rb)
    {
        roomList = new RoomList();
        removedRooms = new RoomList();
        roomList = scheduleManager.getAllRooms();


        initializeTable();
        initializeComboBox();

    }

    private void initializeTable() {
        TableSelectionModel<Room> selectionModel = rooms.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        roomNumber.setCellValueFactory(new PropertyValueFactory<Room,Integer>("roomNumber"));
        block.setCellValueFactory(new PropertyValueFactory<Room,String>("bock"));
        floor.setCellValueFactory(new PropertyValueFactory<Room,Integer>("floor"));
//      students.getItems().addAll(allStudents);
        for (int i = 0; i < roomList.size(); i++)
        {
            rooms.getItems().add(roomList.get(i));
            removedRooms.addRoom(roomList.get(i));
        }
    }

    @FXML private void removeButton(ActionEvent event){
        Room selected = rooms.getSelectionModel().getSelectedItem();
        this.room = selected;
        removedRooms.addRoom(selected);
        roomList.removeRoom(selected);
        rooms.getItems().remove(selected);
        initializeTable();
        numberOfRemovedRooms++;
    }

    private void initializeComboBox()
    {
        for (int i = 0; i < roomList.size(); i++)
        {
            roomBox.getItems().add(roomList.get(i).toString());
        }

    }

    @FXML private void btnSave(ActionEvent event)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to remove " +
                numberOfRemovedRooms + " Rooms?", ButtonType.YES, ButtonType.CANCEL);
        alert.setHeaderText("Are you sure you want to continue?");
        alert.setTitle(null);

        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES)
        {
            for (int i = 0; i < removedRooms.size(); i++)
            {
                scheduleManager.removeRoom(removedRooms.get(i));
            }
            for (int i = 0; i < numberOfRemovedRooms; i++)
            {
                removedRooms.removeRoom(tempList.get(i));
            }
            this.numberOfRemovedRooms = 0;
        }
    }
}
