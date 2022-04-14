package com.erictoader.ordersdatabasemanagement;

import com.erictoader.ordersdatabasemanagement.BusinessLogic.ClientBLL;
import com.erictoader.ordersdatabasemanagement.Model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ClientOpsController implements Initializable {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Client> clientTable;

    @FXML
    private TableColumn<Client, Integer> id;

    @FXML
    private TableColumn<Client, String> fname;

    @FXML
    private TableColumn<Client, String> lname;

    @FXML
    private TableColumn<Client, String> pnumber;

    @FXML
    private TableColumn<Client, String> address;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        lname.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        fname.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        pnumber.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));

        ClientBLL clientBLL = new ClientBLL();
        List<Client> clientList = clientBLL.findAll();

        ObservableList<Client> list = FXCollections.observableArrayList(clientList);
        clientTable.setItems(list);
    }


    public void refreshTable() {
        ClientBLL clientBLL = new ClientBLL();
        List<Client> clientList = clientBLL.findAll();

        ObservableList<Client> list = FXCollections.observableArrayList(clientList);
        clientTable.setItems(list);
    }


    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-stage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public void add() throws IOException, InterruptedException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("client-add.fxml")));
        Stage stage1 = new Stage();
        stage1.setTitle("Input client details");
        Scene scene1 = new Scene(root1);
        stage1.setScene(scene1);
        stage1.setResizable(false);
        stage1.show();
    }


    public void remove(ActionEvent event) {
        Client toDelete = clientTable.getSelectionModel().getSelectedItem();

        ClientBLL clientBLL = new ClientBLL();
        clientBLL.delete(toDelete.getId());

        refreshTable();
        showConfirmation(event);
    }


    private void showConfirmation(ActionEvent event) {
        Alert.AlertType type = Alert.AlertType.INFORMATION;
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(((Node)event.getSource()).getScene().getWindow());
        alert.getDialogPane().setHeaderText("Operation successful");
        alert.showAndWait();
    }


    public void update() throws IOException {
        Client toUpdate = clientTable.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("client-update.fxml"));
        Parent root1 = loader.load();
        Stage stage1 = new Stage();
        stage1.setTitle("Update client details");
        Scene scene1 = new Scene(root1);
        stage1.setScene(scene1);
        stage1.setResizable(false);
        ClientUpdateController clientUpdateController = loader.getController();
        clientUpdateController.completeFields(toUpdate);
        stage1.show();
    }
}
