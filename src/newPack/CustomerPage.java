package newPack;

import composite.CustomerLeafBuilder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import menu.CustomerMenuOperations;
import operations.*;

import java.io.*;
import java.util.Scanner;

public class CustomerPage extends Application {
    public static TableView<CustomerLeafBuilder> table;
    public static TextField TFusername,TFpassword,TFphone,TFbalance;



    @Override
    public void start(Stage primaryStage) throws Exception {

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
        //Username Column
        TableColumn<CustomerLeafBuilder,String> usernameColumn =new TableColumn("Username");
        usernameColumn.setPrefWidth(204);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        //Password Column
        TableColumn<CustomerLeafBuilder,String> passwordColumn =new TableColumn("Password");
        passwordColumn.setPrefWidth(204);
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));


        //Password COLUMNS
        TableColumn<CustomerLeafBuilder,String> phoneColumn =new TableColumn("Phone");
        phoneColumn.setPrefWidth(204);
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));


        //Gender COLUMNS
        TableColumn<CustomerLeafBuilder,String> balanceColumn =new TableColumn("Balance");
        balanceColumn.setPrefWidth(204);
        balanceColumn.setCellValueFactory(new PropertyValueFactory<>("balance"));

        //Table View
        table=new TableView<>();
        table.setItems(getDisplay());
        table.getColumns().addAll(usernameColumn, passwordColumn, phoneColumn,balanceColumn);

        //Username Field
        TFusername =new TextField();
        TFusername.setPromptText("Username");

        //Name Field
        TFpassword =new TextField();
        TFpassword.setPromptText("Password");

        //Phone Field
        TFphone =new TextField();
        TFphone.setPromptText("Phone");

        //Balance Field
        TFbalance =new TextField();
        TFbalance.setPromptText("Balance");

        //add button
        Button btadd =new Button("Add");
        btadd.setOnAction(e->{
            CustomerStrategy customerStrategy = new CustomerMenuOperations();
            Context context = new Context(customerStrategy);
            context.addMethod();
        });
        //Delete Button
        Button btndelete =new Button("Delete");
        btndelete.setOnAction(e->{
            CustomerStrategy customerStrategy = new CustomerMenuOperations();
            Context context = new Context(customerStrategy);
            context.deleteMethod();
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
                ObservableList<CustomerLeafBuilder> list=getSearch(search,table);
                table.setItems(list);


            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        botPane1.getChildren().addAll(TFusername, TFpassword, TFphone, TFbalance);
        botPane2.getChildren().addAll(btadd, btndelete,btnCancel,btnExit);



        layout.setTop(topPane);
        layout.setCenter(CenterPane);
        CenterPane.getChildren().addAll(table,botPane);



//CSS
        search.setStyle("-fx-background-radius:100");
        layout.setStyle("-fx-backgrund-color:gray");
        btsearch.setStyle("-fx-backgrund-color:gray");
        btnCancel.setStyle("-fx-background-color:orange; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");
        btadd.setStyle("-fx-background-color:Green; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");
        btndelete.setStyle("-fx-background-color:blue; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");
        btnExit.setStyle("-fx-background-color:red; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");



        Scene scene =new Scene(layout,1150,500);

        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }



    public  ObservableList<CustomerLeafBuilder> getDisplay(){
        File fileInfo = new File("Customers.txt");
        ObservableList<CustomerLeafBuilder> list= FXCollections.observableArrayList();
        try {
            Scanner reader=new Scanner(fileInfo);

            while (reader.hasNextLine()) {
                String username=reader.nextLine();
                String password=reader.nextLine();
                String phone=reader.nextLine();
                String balance=reader.nextLine();
                list.add(new CustomerLeafBuilder(username,password,phone,balance));
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public  ObservableList<CustomerLeafBuilder> getSearch(TextField ID,TableView<CustomerLeafBuilder> table)throws  IOException{
        ObservableList<CustomerLeafBuilder> list =FXCollections.observableArrayList();

        File fileInfo=new File("Customers.txt");
        Scanner reader=new Scanner(fileInfo);
        while(reader.hasNextLine()){
            String Username=reader.nextLine();
            String Password= reader.nextLine();
            String Phone =reader.nextLine();
            String Balance=reader.nextLine();




            if(Username.toUpperCase().trim().contains(ID.getText().trim().toUpperCase())|| Phone.toUpperCase().trim().contains(ID.getText().trim().toUpperCase())){
                list.add(new CustomerLeafBuilder(Username,Password, Phone,Balance));

            }
        }

        if(ID.getText().trim().length()==0){
            table.setItems(getDisplay());
        }
        reader.close();

        return list;
    }

}
