package newPack;

import com.sun.org.apache.xpath.internal.operations.Or;
import composite.ProductLeafBuilder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import operations.Context;
import operations.ProductStrategy;
import store.electronic.SamsungGalaxyA30;
import store.electronic.SamsungGalaxyA70;
import store.food.PlainMilk;
import store.food.ProteinMilk;
import store.furniture.DecoristerDiva3;
import store.furniture.DecoristerDiva4;
import store.textile.BackgroundCurtain;
import store.textile.ZebraCurtain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductPage extends Application {
    public static TableView<ProductLeafBuilder> table;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //STRATEGY------Writing elemnts to File
        Context context = new Context();
        context.write();

        BorderPane layout=new BorderPane();
        HBox topPane=new HBox(4);
        topPane.prefHeight(55);
        topPane.setAlignment(Pos.TOP_RIGHT);
        VBox CenterPane=new VBox(20);
        HBox botPane=new HBox(25);
        HBox botPane1=new HBox(15);
        HBox botPane2=new HBox(12-0);

        botPane.getChildren().addAll(botPane1,botPane2);

        //Paddings
        botPane.setPadding(new Insets(0,0,20,22));
        topPane.setPadding(new Insets(10,15,10,0));



        //Table Columns
        //Companyname Column
        TableColumn<ProductLeafBuilder,String> productIDColumn =new TableColumn("Product Name");
        productIDColumn.setPrefWidth(204);
        productIDColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));

        //Income Column
        TableColumn<ProductLeafBuilder,String> productNameColumn =new TableColumn("Product ID");
        productNameColumn.setPrefWidth(204);
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));

        //Username COLUMNS
        TableColumn<ProductLeafBuilder,String> priceColumn =new TableColumn("Price");
        priceColumn.setPrefWidth(204);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Password COLUMNS
        TableColumn<ProductLeafBuilder,String> companyNameColumn =new TableColumn("Company Name");
        companyNameColumn.setPrefWidth(204);
        companyNameColumn.setCellValueFactory(new PropertyValueFactory<>("companyName"));

        //Table View
        table=new TableView<>();
        table.setItems(getDisplay());
        table.getColumns().addAll(productIDColumn, productNameColumn,  priceColumn, companyNameColumn);

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
        //Exit Button
        Button btnExit =new Button("Exit");
        btnExit.setOnAction(e->{
            primaryStage.close();
        });
        //Search Field
        TextField search=new TextField();
        search.setPromptText("Search...");
        Image image1=new Image("newPack/Search1.jpg");
        ImageView image2 =new ImageView(image1);
        image2.setFitWidth(25);
        image2.setFitHeight(21);
        Button btsearch=new Button("", image2);
        topPane.getChildren().addAll(search,btsearch);
        btsearch.setOnAction(e->{

            try {
                ObservableList<ProductLeafBuilder> list=getSearch(search,table);
                table.setItems(list);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        botPane2.getChildren().addAll(btnCancel,btnExit);



        layout.setTop(topPane);
        layout.setCenter(CenterPane);
        CenterPane.getChildren().addAll(table,botPane);



//CSS
        search.setStyle("-fx-background-radius:100");
        layout.setStyle("-fx-backgrund-color:blue");
        btsearch.setStyle("-fx-backgrund-color:gray");
        btnCancel.setStyle("-fx-background-color:orange; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");
        btnExit.setStyle("-fx-background-color:red; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");


        Scene scene =new Scene(layout,1150,500);

        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public  ObservableList<ProductLeafBuilder> getDisplay(){
        File fileInfo = new File("Products.txt");
        ObservableList<ProductLeafBuilder> list= FXCollections.observableArrayList();
        try {
            Scanner reader=new Scanner(fileInfo);

            while (reader.hasNextLine()) {
                String income=reader.nextLine();
                String companyName=reader.nextLine();
                String username=reader.nextLine();
                String password=reader.nextLine();
                list.add(new ProductLeafBuilder(income,companyName,username,password));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public  ObservableList<ProductLeafBuilder> getSearch(TextField ID,TableView<ProductLeafBuilder> table)throws  IOException{
        ObservableList<ProductLeafBuilder> list =FXCollections.observableArrayList();

        File fileInfo=new File("Products.txt");
        Scanner reader=new Scanner(fileInfo);
        while(reader.hasNextLine()){
            String income=reader.nextLine();
            String companyName=reader.nextLine();
            String username=reader.nextLine();
            String password=reader.nextLine();




            if(income.toUpperCase().trim().contains(ID.getText().trim().toUpperCase())|| companyName.toUpperCase().trim().contains(ID.getText().trim().toUpperCase())){
                list.add(new ProductLeafBuilder(income,companyName, username,password));

            }
        }

        if(ID.getText().trim().length()==0){
            table.setItems(getDisplay());
        }
        reader.close();

        return list;

    }
}
