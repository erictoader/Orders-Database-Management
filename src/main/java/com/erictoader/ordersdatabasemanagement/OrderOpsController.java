package com.erictoader.ordersdatabasemanagement;

import com.erictoader.ordersdatabasemanagement.BusinessLogic.OrdersBLL;
import com.erictoader.ordersdatabasemanagement.Model.Orders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


public class OrderOpsController implements Initializable{
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Orders> ordersTable;

    @FXML
    private TableColumn<Orders, Integer> id;

    @FXML
    private TableColumn<Orders, Integer> cid;

    @FXML
    private TableColumn<Orders, Integer> pid;

    @FXML
    private TableColumn<Orders, Integer> quantity;


    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-stage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cid.setCellValueFactory(new PropertyValueFactory<>("id_client"));
        pid.setCellValueFactory(new PropertyValueFactory<>("id_product"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        OrdersBLL ordersBLL = new OrdersBLL();
        List<Orders> ordersList = ordersBLL.findAll();

        ObservableList<Orders> list = FXCollections.observableArrayList(ordersList);
        ordersTable.setItems(list);
    }


    public void add(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("orders-add.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
