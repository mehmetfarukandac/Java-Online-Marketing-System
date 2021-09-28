package newPack;

import composite.ProductLeafBuilder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import message.AMesagge;
import message.CustomerBill;
import operations.ProductStrategy;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class StoreMenu extends Application {
    public static TableView<ProductLeafBuilder> table;
    public static Label info_name = new Label();
    public static Label info_balance = new Label();
    public static ObservableList<BasketItems> list1 = FXCollections.observableArrayList();
    public static int total_amount = 0;
    public static Label basket_total = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage storestage) throws IOException {
        RealLoginAccess loginPage = new RealLoginAccess();
        File fileCheck = new File("ControlCheckBox.txt");
        BufferedWriter writerCheck = new BufferedWriter(new FileWriter(fileCheck));
        if (loginPage.rememberme.isSelected()) {
            writerCheck.write("true");
        } else {
            writerCheck.write("false");
        }
        writerCheck.close();


        storestage.setTitle("Store");


        //Logo
        Image image = new Image("newPack/logo_B2me.png");
        ImageView logo = new ImageView(image);

        // Table Basket
        TableView<BasketItems> basket = new TableView<>();
        TableColumn<BasketItems, String> product_name = new TableColumn("Product Name");
        product_name.setPrefWidth(204);
        product_name.setCellValueFactory(new PropertyValueFactory<>("product_Name"));

        //Income Column
        TableColumn<BasketItems, String> product_price = new TableColumn("Product Price");
        product_price.setPrefWidth(204);
        product_price.setCellValueFactory(new PropertyValueFactory<>("product_Price"));
        basket.getColumns().addAll(product_name, product_price);


        //Menu Buttons
        Button b1 = new Button("BUTON-1");
        Button b2 = new Button("BUTON-2");
        Button b3 = new Button("BUTON-3");
        Button b4 = new Button("BUTON-4");

        //Shop Product List
        //Table Columns
        //Companyname Column
        TableColumn<ProductLeafBuilder, String> productIDColumn = new TableColumn("Product Name");
        productIDColumn.setPrefWidth(204);
        productIDColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));

        //Income Column
        TableColumn<ProductLeafBuilder, String> productNameColumn = new TableColumn("Product ID");
        productNameColumn.setPrefWidth(204);
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));

        //Username COLUMNS
        TableColumn<ProductLeafBuilder, String> priceColumn = new TableColumn("Price");
        priceColumn.setPrefWidth(204);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Password COLUMNS
        TableColumn<ProductLeafBuilder, String> companyNameColumn = new TableColumn("Company Name");
        companyNameColumn.setPrefWidth(204);
        companyNameColumn.setCellValueFactory(new PropertyValueFactory<>("companyName"));

        //Table View
        table = new TableView<>();
        table.setItems(getDisplay());
        table.getColumns().addAll(productIDColumn, productNameColumn, priceColumn, companyNameColumn);


        //Basket
        Label basket_total_title = new Label("TOTAL   :          ");

        Button buttonBuy = new Button("Buy");
        buttonBuy.setOnAction(event -> {

            try {
               boolean flag= updateBalance(loginPage.usernameinp.getText(), total_amount);

               if (flag) {
                   File basketFile = new File("Basket.txt");
                   File confirmationFile = new File("Confirmation.txt");
                   BufferedWriter writer = new BufferedWriter(new FileWriter(confirmationFile));
                   Scanner reader = new Scanner(basketFile);
                   while (reader.hasNextLine()) {
                       String username = reader.nextLine();
                       String productName = reader.nextLine();
                       String price = reader.nextLine();

                       writer.write(username);
                       writer.newLine();
                       writer.write(productName);
                       writer.newLine();
                       writer.write(price);
                       writer.newLine();
                   }

                   writer.close();
                   reader.close();

                   basketFile.delete();

                   list1.clear();
                   basket.setItems(list1);
               }
               else{
                   JOptionPane.showMessageDialog(null,"Error Your Balance is not enough","Error",JOptionPane.ERROR_MESSAGE,null);
               }
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


            JOptionPane.showMessageDialog(null, "\n" + "Thank You." + "\n" + "Your order has been received." + "\n" + "\n" + " Your cargo is being prepared. :)", "SUCCESSFULL", JOptionPane.PLAIN_MESSAGE, null);

            AMesagge aMesagge = new CustomerBill();
            aMesagge.yazdir();
            ArrayList<String> arrayList = new ArrayList();
            arrayList.add(loginPage.usernameinp.getText());
            arrayList.add(Integer.toString(total_amount));
            File file = new File("Orders.txt");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
                if (file.length()!=0)
                    writer.newLine();
                writer.write(loginPage.usernameinp.getText());
                writer.newLine();
                writer.write(Integer.toString(total_amount));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            total_amount = 0;
        });


        //basket
        Button buttonBasket = new Button("Basket");
        buttonBasket.setOnAction(e -> {

            ObservableList<ProductLeafBuilder> userSelected;
            userSelected = table.getSelectionModel().getSelectedItems();

            list1.add(new BasketItems(userSelected.get(0).getProductID(), userSelected.get(0).getPrice()));
            total_amount += parseInt(userSelected.get(0).getPrice());
            basket_total.setText(total_amount + "TL");
            basket.setItems(list1);


            File confirmation = new File("Basket.txt");


            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(confirmation, true));


                if (confirmation.length() != 0)
                    writer.newLine();
                writer.write(loginPage.usernameinp.getText());
                writer.newLine();
                writer.write(userSelected.get(0).getProductID());
                writer.newLine();
                writer.write(userSelected.get(0).getPrice());

                writer.close();

            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        });


        // Panels
        StackPane root = new StackPane();
        BorderPane storeborder = new BorderPane();

        StackPane logopane = new StackPane();
        HBox HMenu = new HBox();
        VBox VGroup = new VBox();
        HMenu.getChildren().addAll(b1, b2, b3, b4);
        logopane.getChildren().add(logo);
        //VGroup.getChildren().addAll(logopane,HMenu,shoptable);
        VGroup.getChildren().addAll(logopane, table);
        storeborder.setCenter(VGroup);

        VBox RightVbox = new VBox();
        //User info gridpanel

        File file = new File("Customers.txt");
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String username = reader.nextLine();
                String password = reader.nextLine();
                String phone = reader.nextLine();
                String balance = reader.nextLine();

                if (loginPage.usernameinp.getText().equalsIgnoreCase(username)) {
                    info_name.setText("USERNAME: " + username);
                    info_balance.setText("BALANCE: " + balance);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        GridPane acinfogrid = new GridPane();
        acinfogrid.add(info_name, 0, 0);
        acinfogrid.add(info_balance, 0, 1);

        //Right basket panel
        BorderPane operationsborder = new BorderPane();
        VBox VBasket = new VBox();
        HBox basket_labels = new HBox();
        HBox Hbasketbtn = new HBox(25);

        operationsborder.setBottom(VBasket);
        VBasket.getChildren().addAll(basket_labels, Hbasketbtn);
        basket_labels.getChildren().addAll(basket_total_title, basket_total);

        operationsborder.setTop(basket);

        Hbasketbtn.getChildren().addAll(buttonBasket, buttonBuy);

        RightVbox.getChildren().addAll(acinfogrid, operationsborder);
        storeborder.setRight(RightVbox);
        root.getChildren().add(storeborder);


        //Style_#############################################################################
        logo.setFitHeight(150);
        logo.setFitWidth(150);
        logopane.setStyle("-fx-background-color: #be7644");
        logopane.setPrefHeight(180);

        VGroup.prefWidthProperty().bind(storestage.widthProperty().multiply(0.70));
        //RightVbox.setStyle("-fx-padding: 30px 80px 30px 80px");
        RightVbox.setStyle("-fx-border-style:solid inside");
        RightVbox.setStyle("-fx-border-color: red");
        buttonBasket.setStyle("-fx-background-color:blue; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");
        buttonBuy.setStyle("-fx-background-color:green; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");
        RightVbox.prefWidthProperty().bind(storestage.widthProperty().multiply(0.30));

        basket_labels.setStyle("-fx-padding: 20px 0px 0px 80px");
        Hbasketbtn.setStyle("-fx-padding: 30px 50px 30px 80px");
        buttonBuy.setPrefSize(80, 40);
        buttonBasket.setPrefSize(80, 40);


        acinfogrid.setStyle("-fx-padding: 0 50px 50px 50px");
        acinfogrid.setPrefHeight(180);

        //operationsborder.setStyle("-fx-background-color: #1f2341");
        operationsborder.setPrefWidth(300);

        //Style_#############################################################################

        //Scene Show Settings
        Scene scene = new Scene(root, 1200, 720);
        storestage.setScene(scene);
        storestage.show();


    }

    public ObservableList<ProductLeafBuilder> getDisplay() {
        File fileInfo = new File("Products.txt");
        ObservableList<ProductLeafBuilder> list = FXCollections.observableArrayList();
        try {
            Scanner reader = new Scanner(fileInfo);

            while (reader.hasNextLine()) {
                String income = reader.nextLine();
                String companyName = reader.nextLine();
                String username = reader.nextLine();
                String password = reader.nextLine();
                list.add(new ProductLeafBuilder(income, companyName, username, password));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeTofile(ArrayList<String> list, String url) throws IOException {
        File file = new File(url);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < list.size(); i++) {

            writer.write(list.get(i).toString());
            if (!(i == (list.size() - 1)))
                writer.newLine();

        }
        writer.close();

    }

    public boolean updateBalance(String usernameInp, int total_amount) throws IOException {
        ArrayList<String> listCustomer = new ArrayList<>();
        File customerFile = new File("Customers.txt");
        Scanner reader = new Scanner(customerFile);
        int flag = 0;
        boolean bool = true;

        while (reader.hasNextLine()) {
            String username = reader.nextLine();
            String password = reader.nextLine();
            String phone = reader.nextLine();
            String balance = reader.nextLine();
            if (username.equalsIgnoreCase(usernameInp)) {
                int newBalance = parseInt(balance) - total_amount;
                if (newBalance > 0) {
                    info_balance.setText("BALANCE: " + Integer.toString(newBalance));
                    listCustomer.add(username);
                    listCustomer.add(password);
                    listCustomer.add(phone);
                    listCustomer.add(Integer.toString(newBalance));
                } else {
                    flag++;
                    break;
                }
            } else {
                listCustomer.add(username);
                listCustomer.add(password);
                listCustomer.add(phone);
                listCustomer.add(balance);

            }
            if (flag == 0) {
                writeTofile(listCustomer, "Customers.txt");
                bool = true;
            } else {
                bool = false;
            }
        }
        reader.close();
        return bool;
    }
}
