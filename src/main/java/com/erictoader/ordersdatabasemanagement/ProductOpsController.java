package com.erictoader.ordersdatabasemanagement;

import com.erictoader.ordersdatabasemanagement.BusinessLogic.ProductBLL;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


public class ProductOpsController implements Initializable {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, Integer> id;

    @FXML
    private TableColumn<Product, String> name;

    @FXML
    private TableColumn<Product, Integer> stock;

    @FXML
    private TableColumn<Product, Integer> price;


    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-stage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public void refreshTable() {
        ProductBLL productBLL = new ProductBLL();
        List<Product> productList = productBLL.findAll();

        ObservableList<Product> list = FXCollections.observableArrayList(productList);
        productTable.setItems(list);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        ProductBLL productBLL = new ProductBLL();
        List<Product> productList = productBLL.findAll();

        ObservableList<Product> list = FXCollections.observableArrayList(productList);
        productTable.setItems(list);
    }


    public void add() throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-add.fxml")));
        Stage stage1 = new Stage();
        stage1.setTitle("Input product details");
        Scene scene1 = new Scene(root1);
        stage1.setScene(scene1);
        stage1.setResizable(false);
        stage1.show();
    }


    public void remove(ActionEvent event) {
        Product toDelete = productTable.getSelectionModel().getSelectedItem();

        ProductBLL productBLL = new ProductBLL();
        productBLL.delete(toDelete.getId());

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
        Product toUpdate = productTable.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("product-update.fxml"));
        Parent root1 = loader.load();
        Stage stage1 = new Stage();
        stage1.setTitle("Update product details");
        Scene scene1 = new Scene(root1);
        stage1.setScene(scene1);
        stage1.setResizable(false);
        ProductUpdateController productUpdateController = loader.getController();
        productUpdateController.completeFields(toUpdate);
        stage1.show();
    }

}