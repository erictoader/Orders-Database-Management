package com.erictoader.ordersdatabasemanagement;

import com.erictoader.ordersdatabasemanagement.BusinessLogic.ClientBLL;
import com.erictoader.ordersdatabasemanagement.Model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ClientAddController {

    @FXML
    private TextField address;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField phonenumber;


    public void addNewClient(ActionEvent event) {
        Client toAdd = new Client();
        toAdd.setLast_name(lastname.getText());
        toAdd.setFirst_name(firstname.getText());
        toAdd.setAddress(address.getText());
        toAdd.setPhone_number(phonenumber.getText());

        ClientBLL clientBLL = new ClientBLL();
        clientBLL.insert(toAdd);

        showConfirmation(event);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }


    private void showConfirmation(ActionEvent event) {
        Alert.AlertType type = Alert.AlertType.INFORMATION;
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(((Node)event.getSource()).getScene().getWindow());
        alert.getDialogPane().setHeaderText("Operation successful");
        alert.showAndWait();
    }
}
