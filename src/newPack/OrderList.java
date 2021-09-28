package newPack;

import composite.ProductLeafBuilder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import message.AMesagge;
import message.AdminBill;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrderList extends Application {
    public static TableView<ProductLeafBuilder> table;
    public static String productNameOrder;
    public static String priceOrder;

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane borderPane = new BorderPane();
        VBox vBox=new VBox(20);

        TableColumn<ProductLeafBuilder,String> productNameColumn =new TableColumn("Product Name");
        productNameColumn.setPrefWidth(204);
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));

        //Income Column
        TableColumn<ProductLeafBuilder,String> priceColumn =new TableColumn("Price");
        priceColumn.setPrefWidth(204);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        table=new TableView<>();
        table.setItems(getDisplay());
        table.getColumns().addAll(productNameColumn, priceColumn);

        //ORDER BUTTON
        Button buttonOrder = new Button("Get Bill");
        buttonOrder.setOnAction(e->{
            ObservableList<ProductLeafBuilder> userSelected;
            userSelected = table.getSelectionModel().getSelectedItems();
            productNameOrder = userSelected.get(0).getProductID();
            priceOrder = userSelected.get(0).getPrice();
            AMesagge aMesagge = new AdminBill();
            aMesagge.yazdir();
        });
        //Cancel Button
        Button btnCancel =new Button("Cancel");
        btnCancel.setOnAction(e->{
            AdminPage adminPage = new AdminPage();
            try {
                adminPage.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        buttonOrder.setStyle("-fx-background-color:orange; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");
        btnCancel.setStyle("-fx-background-color:purple; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");
        Label label = new Label("CLICK ON THE TABLE ITEM FIRST, THEN CLICK THE BUTTON.");

        GridPane gridPane = new GridPane();
        gridPane.add(label,0,0);
        gridPane.add(buttonOrder,0,1);
        gridPane.add(btnCancel,1,1);
        vBox.getChildren().add(table);

        borderPane.setCenter(vBox);
        borderPane.setBottom(gridPane);


        Scene scene =new Scene(borderPane,1150,500);

        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public ObservableList<ProductLeafBuilder> getDisplay(){
        File fileInfo = new File("Orders.txt");
        ObservableList<ProductLeafBuilder> list= FXCollections.observableArrayList();
        try {
            Scanner reader=new Scanner(fileInfo);

            while (reader.hasNextLine()) {
                String productName=reader.nextLine();
                String price=reader.nextLine();
                list.add(new ProductLeafBuilder(productName,price));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
