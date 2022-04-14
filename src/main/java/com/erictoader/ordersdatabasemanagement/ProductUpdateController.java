package com.erictoader.ordersdatabasemanagement;

import com.erictoader.ordersdatabasemanagement.BusinessLogic.ProductBLL;
import com.erictoader.ordersdatabasemanagement.Model.Product;
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


public class ProductUpdateController implements Initializable {

    private Integer selectedID;

    @FXML
    private TextField u_name;

    @FXML
    private TextField u_stock;

    @FXML
    private TextField u_price;

    public void completeFields(Product c) {
        selectedID = c.getId();
        u_name.setText(c.getName());
        u_stock.setText(c.getStock().toString());
        u_price.setText(c.getPrice().toString());
    }

    public void updateProduct(ActionEvent event) {
        Product toUpdate = new Product();
        toUpdate.setId(selectedID);
        toUpdate.setName(u_name.getText());
        toUpdate.setStock(Integer.parseInt(u_stock.getText()));
        toUpdate.setPrice(Integer.parseInt(u_price.getText()));

        ProductBLL productBLL = new ProductBLL();
        productBLL.update(toUpdate);

        showConfirmation(event);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
