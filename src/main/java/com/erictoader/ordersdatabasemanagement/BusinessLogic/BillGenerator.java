package com.erictoader.ordersdatabasemanagement.BusinessLogic;

import com.erictoader.ordersdatabasemanagement.Model.Client;
import com.erictoader.ordersdatabasemanagement.Model.Orders;
import com.erictoader.ordersdatabasemanagement.Model.Product;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
*   This class is for generating and storing a bill containing an order's information in a PDF format
*   @author Toader Eric-Stefan
*/
public class BillGenerator {
    /*
    *   Constructor for creating a bill object and storing a file locally
    *   @param c The client that made the order
    *   @param p The product ordered
    *   @param o The actual order with its associated Client-Product information
    */
    public BillGenerator(Client c, Product p, Orders o) {
        Document doc = new Document();
        try
        {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("Bill" + o.getId() +".pdf"));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm:ss");
            LocalDateTime orderTime = LocalDateTime.now();
            doc.open();

            doc.add(new Paragraph("Date and Time: " + dtf.format(orderTime)));
            doc.add(new Paragraph("Order ID: " + o.getId()));
            doc.add(new Paragraph(" "));

            doc.add(new Paragraph("Client ID: " + c.getId()));
            doc.add(new Paragraph("Name: " + c.getLast_name() + c.getFirst_name()));
            doc.add(new Paragraph("Phone number: " + c.getPhone_number()));
            doc.add(new Paragraph("Address: " + c.getAddress()));
            doc.add(new Paragraph(" "));

            doc.add(new Paragraph("Product ID: " + p.getId()));
            doc.add(new Paragraph("Product name: " + p.getName()));
            doc.add(new Paragraph("Quantity: " + o.getQuantity()));
            doc.add(new Paragraph("TOTAL: " + o.getQuantity() * p.getPrice()));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Eric Toader - Orders Management Application"));

            doc.close();
            writer.close();
        } catch (DocumentException | IOException e)
        {
            e.printStackTrace();
        }
    }
}
