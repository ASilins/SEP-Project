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

public class RoomController
{
    @FXML private Button btnHome;
    @FXML private TableView<Room> rooms;
    @FXML private TableColumn<Room,String> roomNumber;
    @FXML private TableColumn<Room,Character> block;
    @FXML private TableColumn<Room,Integer> floor;
    @FXML private TableColumn<Room,Integer> capacity;
    private Room room;
    private RoomList roomList;
    private RoomList tempList;
    private ObservableList<RoomList> allRooms;
    private RoomList removedRooms;
    private int numberOfRemovedRooms = 0;
    private ScheduleModelManager scheduleManager = new ScheduleModelManager("src/Files/students.bin",
            "src/Files/teachers.bin", "src/Files/classes.bin", "src/Files/courses.bin",
            "src/Files/rooms.bin", "src/Files/lessons.bin");
    @FXML private TextField roomNumberFieldEdit;
    @FXML private TextField blockFieldEdit;
    @FXML private TextField floorFieldEdit;
    @FXML private TextField capacityFieldEdit;
    @FXML private TextField roomNumberFieldAdd;
    @FXML private TextField blockFieldAdd;
    @FXML private TextField floorFieldAdd;
    @FXML private TextField capacityFieldAdd;
    @FXML private ComboBox<String> roomBox;



    public void switchToSceneHome(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource("Home.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage window = (Stage) btnHome.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));
        window.show();

    }

    public void initialize()
    {
        roomList = new RoomList();
        removedRooms = new RoomList();

        initializeRoomList();
        initializeTable();
        initializeComboBox();

    }

    private void initializeRoomList(){
        roomList = scheduleManager.getAllRooms();
        for (int i = removedRooms.size() - 1; i >= 0; i--)
        {
            removedRooms.removeRoom(removedRooms.get(i));
        }
    }

    private void initializeTable() {
        TableSelectionModel<Room> selectionModel = rooms.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        roomNumber.setCellValueFactory(new PropertyValueFactory<Room,String>("roomNumber"));
        block.setCellValueFactory(new PropertyValueFactory<Room,Character>("block"));
        floor.setCellValueFactory(new PropertyValueFactory<Room,Integer>("floor"));
        capacity.setCellValueFactory(new PropertyValueFactory<Room, Integer>("capacity"));

        rooms.getItems().clear();
        for (int i = 0; i < roomList.size(); i++)
        {
            rooms.getItems().add(roomList.get(i));
        }
    }

    @FXML private void removeButton(){
        Room selected = rooms.getSelectionModel().getSelectedItem();

        removedRooms.addRoom(selected);
        roomList.removeRoom(selected);
        rooms.getItems().remove(selected);
        numberOfRemovedRooms++;

        initializeComboBox();

    }

    private void initializeComboBox()
    {
        roomBox.getItems().clear();
        for (int i = 0; i < roomList.size(); i++)
        {
            roomBox.getItems().add(roomList.get(i).toString());
        }

    }

    private Room getRoom(ComboBox<String> combo){
        Room room = null;
        for (int i = 0; i < roomList.size(); i++)
        {
            if (combo.getSelectionModel().getSelectedItem().equals(roomList.get(i).toString()))
            {
                room = roomList.get(i);
                break;
            }
        }
        return room;
    }

    private void editRoom(){
        System.out.println("Hello");

        Room newRoom;
        char block = blockFieldEdit.getText().charAt(0);
        int floor = Integer.parseInt(floorFieldEdit.getText());
        String number = roomNumberFieldEdit.getText();
        int capacity = Integer.parseInt(capacityFieldEdit.getText());
        newRoom = new Room(number, capacity, block, floor);

        scheduleManager.editRoom(getRoom(roomBox), newRoom);
    }

    private void addRoom(){
        Room newRoom;
        char block = blockFieldAdd.getText().charAt(0);
        int floor = Integer.parseInt(floorFieldAdd.getText());
        String number = roomNumberFieldAdd.getText();
        int capacity = Integer.parseInt(capacityFieldAdd.getText());
        newRoom = new Room(number, capacity, block, floor);

        scheduleManager.addRoom(newRoom);
    }

    @FXML private void btnSave()
    {
        Alert alertRemoving = new Alert(Alert.AlertType.CONFIRMATION,
            "Are you sure you want to remove " + numberOfRemovedRooms + " rooms?", ButtonType.YES, ButtonType.CANCEL);
        alertRemoving.setHeaderText("Are you sure you want to continue?");
        alertRemoving.setTitle(null);

        Alert alertEmpty = new Alert(Alert.AlertType.ERROR, "Please ensure you have not left any\n"
            + " field empty when adding a room", ButtonType.OK);
        alertEmpty.setHeaderText("Error has occurred!");
        alertEmpty.setTitle(null);

        if (numberOfRemovedRooms != 0)
        {

            alertRemoving.showAndWait();

            if (alertRemoving.getResult() == ButtonType.YES)
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

        if (roomBox.getSelectionModel().getSelectedItem() != null)
        {
            editRoom();
            roomNumberFieldEdit.clear();
            capacityFieldEdit.clear();
            floorFieldEdit.clear();
            blockFieldEdit.clear();

        }

        if (!isNullOrEmpty(roomNumberFieldAdd.getText()) && !isNullOrEmpty(
            capacityFieldAdd.getText()) && !isNullOrEmpty(
            blockFieldAdd.getText()) && !isNullOrEmpty(floorFieldAdd.getText()))
        {
            addRoom();
            roomNumberFieldAdd.clear();
            capacityFieldAdd.clear();
            floorFieldAdd.clear();
            blockFieldAdd.clear();
        }
        else
        {
            alertEmpty.showAndWait();
        }

        initializeRoomList();
        initializeComboBox();
        initializeTable();
    }

    private static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }

    private static boolean isNullOrZero(Object integer) {
        return integer == null || integer.equals(0);
    }
}
