package View;


import Model.RoomList;
import Model.StudentList;
import Model.ScheduleModelManager;

import Utils.MyFileHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.event.ActionEvent;

public class RoomsController
{
    private Region root;
    private ScheduleModelManager modelManager;
    private MyFileHandler viewHandler;

    @FXML private Button getRemove;
    @FXML private Button backButton;
    @FXML private TextArea allRoomsArea;


    public void init(MyFileHandler viewHandler, ScheduleModelManager modelManager, Region root)
    {
        this.modelManager = modelManager;
        this.root = root;
        this.viewHandler = viewHandler;
        reset();
    }

    public void reset()
    {
        updateStudentArea();
    }

    public Region getRoot()
    {
        return root;
    }

    public void handleActions(ActionEvent e)
    {

    }

    private void updateStudentArea()
    {
        RoomList rooms = ScheduleModelManager.getAllRooms();
        allRoomsArea.setText(rooms.toString());
    }
}
