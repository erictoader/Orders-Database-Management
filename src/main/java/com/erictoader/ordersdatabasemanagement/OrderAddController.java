package com.erictoader.ordersdatabasemanagement;

import com.erictoader.ordersdatabasemanagement.BusinessLogic.BillGenerator;
import com.erictoader.ordersdatabasemanagement.BusinessLogic.ClientBLL;
import com.erictoader.ordersdatabasemanagement.BusinessLogic.OrdersBLL;
import com.erictoader.ordersdatabasemanagement.BusinessLogic.ProductBLL;
import com.erictoader.ordersdatabasemanagement.Model.Client;
import com.erictoader.ordersdatabasemanagement.Model.Orders;
import com.erictoader.ordersdatabasemanagement.Model.Product;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


public class OrderAddController  implements Initializable{
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField quantity;

    @FXML
    private TableColumn<Client, String> clientAddress;

    @FXML
    private TableColumn<Client, String> clientFName;

    @FXML
    private TableColumn<Client, Integer> clientID;

    @FXML
    private TableColumn<Client, String> clientLName;

    @FXML
    private TableColumn<Client, String> clientPNumber;

    @FXML
    private TableView<Client> clientsTable;

    @FXML
    private TableColumn<Product, Integer> productID;

    @FXML
    private TableColumn<Product, String> productName;

    @FXML
    private TableColumn<Product, Integer> productPrice;

    @FXML
    private TableColumn<Product, Integer> productStock;

    @FXML
    private TableView<Product> productsTable;


    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("orders-operations.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientID.setCellValueFactory(new PropertyValueFactory<>("id"));
        clientLName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        clientFName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        clientPNumber.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        clientAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        ClientBLL clientBLL = new ClientBLL();
        List<Client> clientList = clientBLL.findAll();

        ObservableList<Client> listC = FXCollections.observableArrayList(clientList);

        productID.setCellValueFactory(new PropertyValueFactory<>("id"));
        productName.setCellValueFactory(new PropertyValueFactory<>("name"));
        productStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        ProductBLL productBLL = new ProductBLL();
        List<Product> productList = productBLL.findAll();

        ObservableList<Product> listP = FXCollections.observableArrayList(productList);

        clientsTable.setItems(listC);
        productsTable.setItems(listP);
    }


    public void add(ActionEvent event) {
        Client client = clientsTable.getSelectionModel().getSelectedItem();
        Product product = productsTable.getSelectionModel().getSelectedItem();
        Integer q = Integer.parseInt(quantity.getText());

        Alert.AlertType type = Alert.AlertType.INFORMATION;
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(((Node)event.getSource()).getScene().getWindow());

        if(q > product.getStock()) {
            alert.getDialogPane().setHeaderText("Operation could not be completed");
            alert.getDialogPane().setContentText("Insufficient stock");
            alert.showAndWait();
        }
        else {
            OrdersBLL ordersBLL = new OrdersBLL();
            Orders newOrder = new Orders(ordersBLL.findAll().size(), client.getId(), product.getId(), q);
            ordersBLL.insert(newOrder);
            new BillGenerator(client,product,newOrder);
            product.setStock(product.getStock() - q);
            ProductBLL productBLL = new ProductBLL();
            productBLL.update(product);

            List<Product> productList = productBLL.findAll();
            ObservableList<Product> listP = FXCollections.observableArrayList(productList);
            productsTable.setItems(listP);

            alert.getDialogPane().setHeaderText("Operation successful");
            alert.showAndWait();
        }
    }
}
