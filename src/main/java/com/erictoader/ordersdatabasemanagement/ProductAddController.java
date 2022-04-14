package com.erictoader.ordersdatabasemanagement;

import com.erictoader.ordersdatabasemanagement.BusinessLogic.ProductBLL;
import com.erictoader.ordersdatabasemanagement.Model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ProductAddController {

    @FXML
    private TextField name;

    @FXML
    private TextField stock;

    @FXML
    private TextField price;


    public void addNewProduct(ActionEvent event) {
        Product toAdd = new Product();
        toAdd.setName(name.getText());
        toAdd.setStock(Integer.parseInt(stock.getText()));
        toAdd.setPrice(Integer.parseInt(price.getText()));

        ProductBLL productBLL = new ProductBLL();
        productBLL.insert(toAdd);

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
