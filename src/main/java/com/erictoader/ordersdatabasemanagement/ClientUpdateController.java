package com.erictoader.ordersdatabasemanagement;

import com.erictoader.ordersdatabasemanagement.BusinessLogic.ClientBLL;
import com.erictoader.ordersdatabasemanagement.Model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class ClientUpdateController implements Initializable {

    private Integer selectedID;

    @FXML
    private TextField u_address;

    @FXML
    private TextField u_firstname;

    @FXML
    private TextField u_lastname;

    @FXML
    private TextField u_phonenumber;


    public void completeFields(Client c) {
        selectedID = c.getId();
        u_address.setText(c.getAddress());
        u_firstname.setText(c.getFirst_name());
        u_lastname.setText(c.getLast_name());
        u_phonenumber.setText(c.getPhone_number());
    }


    public void updateClient(ActionEvent event) {
        Client toUpdate = new Client();
        toUpdate.setId(selectedID);
        toUpdate.setLast_name(u_lastname.getText());
        toUpdate.setFirst_name(u_firstname.getText());
        toUpdate.setAddress(u_address.getText());
        toUpdate.setPhone_number(u_phonenumber.getText());

        ClientBLL clientBLL = new ClientBLL();
        clientBLL.update(toUpdate);

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
