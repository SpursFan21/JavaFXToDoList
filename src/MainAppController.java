// src/MainAppController.java
package src;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainAppController {

    @FXML
    private TextField newTaskField;
    @FXML
    private ListView<String> taskList;

    @FXML
    private void handleAddTask() {
        String task = newTaskField.getText();
        if (task != null && !task.trim().isEmpty()) {
            taskList.getItems().add(task);
            newTaskField.clear();
        }
    }
}
