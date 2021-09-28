package newPack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class AdminPage extends Application {

    public void setColor(Button bt, String color) {
        bt.setStyle("-fx-background-color:" +color);
    }

    @Override
    public void start(Stage stage) throws Exception {
       RealLoginAccess loginPage=new RealLoginAccess();
       File file=new File("ControlCheckBox.txt");
        BufferedWriter writer =new BufferedWriter(new FileWriter(file));
        if(loginPage.rememberme.isSelected()){
            writer.write("true");
        }
        else{
            writer.write("false");
        }
        writer.close();


        BorderPane borderPane = new BorderPane();
        VBox vBoxTotal = new VBox(30);
        HBox hBoxUp = new HBox(40);
        HBox hBoxLow = new HBox();
        vBoxTotal.getChildren().addAll(hBoxUp, hBoxLow);
        borderPane.setCenter(vBoxTotal);
        vBoxTotal.setAlignment(Pos.CENTER);
        StackPane stackTopPane = new StackPane();
        Label topLabel = new Label("Admin Panel");
        topLabel.setStyle("-fx-font-size:25");
        VBox vBoxBottomPane = new VBox();
        borderPane.setBottom(vBoxBottomPane);

        //Buttons
        Button btExit = new Button(" Exit ");
        Button customer = new Button("     CUSTOMERS     ");
        customer.setOnAction(event -> {
            CustomerPage customerPage = new CustomerPage();
            try {
                customerPage.start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        //Orders Button
        Button buttonOrder = new Button("    ORDERS    ");
        buttonOrder.setOnAction(e->{
            OrderList orderList = new OrderList();
            try {
                orderList.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Button products = new Button("     PRODUCTS    ");
        products.setOnAction(event -> {
            ProductPage productPage = new ProductPage();
            try {
                productPage.start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        hBoxUp.getChildren().addAll(customer, products);
        hBoxLow.getChildren().add(buttonOrder);
        hBoxLow.setAlignment(Pos.CENTER);
        stackTopPane.getChildren().addAll(topLabel);
        vBoxBottomPane.getChildren().add(btExit);
        vBoxBottomPane.setAlignment(Pos.BOTTOM_RIGHT);

        borderPane.setTop(stackTopPane);
        btExit.setOnAction(event -> {
            stage.close();
        });

        //Paddings
        vBoxTotal.setPadding(new Insets(0, 0, 30, 180));
        stackTopPane.setPadding(new Insets(100, 0, 40, 0));
        vBoxBottomPane.setPadding(new Insets(0, 15, 15, 0));

        //CSS
        topLabel.setStyle("-fx-font-size:25; -fx-text-fill:#e67e22");
        borderPane.setStyle("-fx-background-color:#ecf0f1");
        stackTopPane.setStyle("-fx-background-color:#8e44ad");
        setColor(customer, "#f5fffa");
        setColor(products, "#f5fffa");
        setColor(btExit, "#f5fffa");
        btExit.setStyle("-fx-background-color:#8e44ad; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22; ");
        buttonOrder.setStyle("-fx-background-color:#e67e22; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");
        customer.setStyle("-fx-background-color:#e67e22; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");
        products.setStyle("-fx-background-color:#e67e22; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");



        Scene scene = new Scene(borderPane, 600, 380);
        stage.setScene(scene);
        stage.show();
    }
}