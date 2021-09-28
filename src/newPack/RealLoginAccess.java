package newPack;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import login.ILogin;
import operations.ActionCompareUsers;
import operations.IActionCommand;
import operations.Operations;
import operations.Invoker;

import java.io.*;
import java.util.Scanner;

public class RealLoginAccess implements ILogin {
    //Remember me Button
    public static CheckBox rememberme =new CheckBox("Remember me");
    public static TextField usernameinp=new TextField();
    public static PasswordField passwordinp=new PasswordField();
    public static Stage primaryStage = new Stage();

    public static  void checkbox (TextField nameinp ,PasswordField passinp) throws  IOException{

        File checkfile =new File("ControlCheckBox.txt");
        File lastuserfile =new File("LastUser.txt");
        if(lastuserfile.length()!=0) {
            Scanner reader = new Scanner(checkfile);
            Scanner readeruser = new Scanner(lastuserfile);
            String username = readeruser.nextLine();
            String pass = readeruser.nextLine();
            if (reader.next().equals("true")) {
                nameinp.setText(username);
                passinp.setText(pass);
                rememberme.setSelected(true);
            }

            reader.close();
            readeruser.close();
        }
    }


    @Override
    public void grantLoginAccess(Stage stage) {

        primaryStage.setTitle("Log In");
        VBox boxBot=new VBox(40);
        //box1 boxBot
        HBox boxBot1 = new HBox(15);
        boxBot.getChildren().add(boxBot1);
        HBox boxForgot =new HBox();
        GridPane layout = new GridPane();

        BorderPane pane = new BorderPane();
        pane.setCenter(layout);
        pane.setBottom(boxBot);

        //setting top
        HBox boxTop = new HBox(200);
        pane.setTop(boxTop);

        //Boxes For Top
        HBox boxImage = new HBox();

        HBox boxRegister = new HBox();
        boxImage.setAlignment(Pos.CENTER_LEFT);



        //boxRegister Register button
        Button register = new Button("REGISTER");
        register.setOnAction(e -> {
            RegisterCustomer registerCustomer = new RegisterCustomer();
            try {
                registerCustomer.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        boxRegister.getChildren().add(register);
        boxRegister.setAlignment(Pos.TOP_RIGHT);



        //icon adding
        Image image = new Image("newPack/logo_B2me.png");
        ImageView image1 = new ImageView(image);
        image1.setFitWidth(105);
        image1.setFitHeight(105);
        boxImage.getChildren().add(image1);

        //Username block

        usernameinp.setPromptText("Username");

        //Password block

        passwordinp.setPromptText("Password");

        try {
            checkbox(usernameinp,passwordinp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Log in Button
        Button btlog = new Button(" Log In ");
        boxBot1.getChildren().addAll(rememberme, btlog);
        btlog.setOnAction(event -> {

            try {

                Operations operations=new Operations();
                IActionCommand compareUsers=new ActionCompareUsers(operations);
                Invoker receiver = new Invoker();
                receiver.setCompareUsers(compareUsers);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        //Forgot password Button
        Button btforgot=new Button("Forgot Password");

        btforgot.setOnAction(e->{
            ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage();
            forgotPasswordPage.getPage();
        });
        boxForgot.getChildren().add(btforgot);
        boxBot.getChildren().add(boxForgot);




        //Paddings
        layout.setPadding(new Insets(30, 70, 25, 0));
        boxTop.setPadding(new Insets(20, 0, 0, 0));
        boxBot1.setPadding(new Insets(0, 0, 0, 25));
        boxRegister.setPadding(new Insets(25, 0, 0, 30));
        boxForgot.setPadding(new Insets(0,30,20,0));
        boxBot.setPadding(new Insets(0,0,110,0));
        boxBot1.setAlignment(Pos.CENTER);
        boxBot.setAlignment(Pos.CENTER);
        boxForgot.setAlignment(Pos.TOP_RIGHT);
        boxTop.setAlignment(Pos.CENTER);
        layout.setAlignment(Pos.CENTER);


        //Labels
        Label lb1 = new Label("Username:");
        Label lb2 = new Label("Password:");


        //GridPane adding Elemenets
        layout.add(lb1, 0, 0);
        layout.add(lb2, 0, 1);
        layout.add(usernameinp, 1, 0);
        layout.add(passwordinp, 1, 1);
        layout.setHgap(15);
        layout.setVgap(15);
        boxTop.getChildren().addAll(boxImage, boxRegister);


        //Css
        lb1.setStyle("-fx-text-fill:#E0FFFF;-fx-font-size:16");
        lb2.setStyle("-fx-text-fill:#E0FFFF;-fx-font-size:16");


        pane.setStyle("-fx-background-color:#3b3e43");
        btlog.setStyle("-fx-background-color:Green; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");
        register.setStyle("-fx-background-color:#2b2d31; -fx-border-color:#a0a2ab;-fx-text-fill:#E0FFFF;");
        rememberme.setStyle("-fx-text-fill:#E0FFFF");
        btforgot.setStyle("-fx-background-color:red; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");

        Scene scene1 = new Scene(pane, 500, 400);

        primaryStage.getIcons().add(image);
        primaryStage.setScene(scene1);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
