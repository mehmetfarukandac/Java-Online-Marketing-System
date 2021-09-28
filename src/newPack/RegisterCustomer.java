package newPack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class RegisterCustomer extends Application {
    static boolean answer;

    @Override
    public void start(Stage primaryStage){
        BorderPane root = new BorderPane();
        GridPane layout = new GridPane();

        Image image1 = new Image("newPack/logo_B2me.png");
        ImageView image = new ImageView(image1);
        image.setFitWidth(110);
        image.setFitHeight(100);

        //question block
        ChoiceBox<String> choicequestion = new ChoiceBox<>();
        choicequestion.getItems().addAll("What's your favourite book ?", "Define You with one word", "What's your animal's name?","What's your favourite movie?");
        choicequestion.getSelectionModel().select(0);
        TextField questioninp = new TextField();
        questioninp.setPromptText("Answer of Questions");

        //Cancel Button
        Button btnCancel = new Button("  Cancel  ");
        btnCancel.setOnAction(e -> {
            RealLoginAccess loginPage = new RealLoginAccess();
            try {
                loginPage.grantLoginAccess(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });





        TextField usernameinp = new TextField();
        usernameinp.setPromptText("Username");
        PasswordField passwordinp = new PasswordField();
        passwordinp.setPromptText("Password");
        PasswordField repasswordinp = new PasswordField();
        repasswordinp.setPromptText("Re-Password");
        TextField phoneinp = new TextField();
        phoneinp.setPromptText("Phone");



        //Register Button
        Button btregister = new Button(" Register ");
        btregister.setOnAction(e -> {

            try {

                if (!(usernameinp.getText().length() >= 6) && (usernameinp.getText().length() >= 6)) {

                    JOptionPane.showMessageDialog(null,"Your Username and Password Should be min 6 characters","Username",JOptionPane.ERROR_MESSAGE,null);

                } else if (!(passwordinp.getText().equals(repasswordinp.getText()))) {
                    JOptionPane.showMessageDialog(null,"Your Password and RE-Password Should be same","Password",JOptionPane.ERROR_MESSAGE,null);

                } else if (!(phoneinp.getText().length() == 11)) {
                    JOptionPane.showMessageDialog(null,"Your Phone can't be less than 11 ","Phone",JOptionPane.ERROR_MESSAGE,null);


                }else if (!(phoneinp.getText().length() > 0 && questioninp.getText().length() > 0)) {

                    JOptionPane.showMessageDialog(null,"Your Phone and Your answer should be min 1 character","Name",JOptionPane.ERROR_MESSAGE,null);

                } else if (readFile("Admins.txt", usernameinp.getText().trim().toUpperCase())) {

                    JOptionPane.showMessageDialog(null,"This ID is already taken by another user","ID",JOptionPane.ERROR_MESSAGE,null);

                }
                else {
                    writeToFile("Users.txt", usernameinp,passwordinp, repasswordinp, phoneinp, choicequestion, questioninp);
                    RealLoginAccess loginPage = new RealLoginAccess();
                    try {
                        loginPage.grantLoginAccess(primaryStage);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        Label lb1 = new Label("Username:");
        Label lb2 = new Label("Phone:");
        Label lb3 = new Label("Password:");
        Label lb4 = new Label("Re-Password:");
        Label lb5 = new Label("Choose Question:");
        Label lb6 = new Label("Answer:");



        lb1.setStyle("-fx-text-fill:#E0FFFF;-fx-font-size:16");
        lb2.setStyle("-fx-text-fill:#E0FFFF;-fx-font-size:16");
        lb3.setStyle("-fx-text-fill:#E0FFFF;-fx-font-size:16");
        lb4.setStyle("-fx-text-fill:#E0FFFF;-fx-font-size:16");


        layout.add(lb1, 0, 0);
        layout.add(usernameinp, 1, 0);
        layout.add(lb2, 0, 1);
        layout.add(phoneinp, 1, 1);
        layout.add(lb3, 0, 2);
        layout.add(passwordinp, 1, 2);
        layout.add(lb4, 0, 3);
        layout.add(repasswordinp, 1, 3);
        layout.add(lb5, 0, 4);
        layout.add(choicequestion, 1, 4);
        layout.add(lb6, 0, 5);
        layout.add(questioninp, 1, 5);
        layout.add(btnCancel, 2, 6);
        layout.add(btregister, 1, 6);

        lb1.setStyle("-fx-text-fill:#E0FFFF;-fx-font-size:16");
        lb2.setStyle("-fx-text-fill:#E0FFFF;-fx-font-size:16");
        lb3.setStyle("-fx-text-fill:#E0FFFF;-fx-font-size:16");
        lb4.setStyle("-fx-text-fill:#E0FFFF;-fx-font-size:16");
        lb5.setStyle("-fx-text-fill:#FFFFFF;-fx-font-size:16");
        lb6.setStyle("-fx-text-fill:#FFFFFF;-fx-font-size:16");
        root.setStyle("-fx-background-color:#3b3e43");
        btnCancel.setStyle("-fx-background-color:purple; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");
        btregister.setStyle("-fx-background-color:Green; -fx-text-fill:#E0FFFF;-fx-font-veight:bold;-fx-background-radius:22;");
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        StackPane stackPane = new StackPane();
        stackPane.setPadding(new Insets(40,0,0,0));
        stackPane.getChildren().add(image);
        root.setTop(stackPane);
        root.setCenter(layout);

        Scene scene = new Scene(root,700,500);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void writeToFile(String str,  TextField usernameinp, PasswordField passwordinp, PasswordField repasswordinp,TextField phoneinp,ChoiceBox<String> choicequestion,TextField questioninp) {
        File file = new File(str);
        String balance= "10000000";
        try {


            if (readFile("Users.txt", phoneinp.getText().toUpperCase().trim())) {
                JOptionPane.showMessageDialog(null,"This Username is already taken by another user","Username",JOptionPane.ERROR_MESSAGE,null);

            } else {

                File fileInfo = new File("Customers.txt");
                File fileQuestion = new File("Question.txt");

                BufferedWriter Users = new BufferedWriter(new FileWriter(file, true));
                BufferedWriter UsersInfo = new BufferedWriter(new FileWriter(fileInfo, true));
                BufferedWriter UsersQuestion = new BufferedWriter(new FileWriter(fileQuestion, true));

                if (fileQuestion.length() != 0)
                    UsersQuestion.newLine();
                UsersQuestion.write(choicequestion.getValue());
                UsersQuestion.newLine();
                UsersQuestion.write(usernameinp.getText());
                UsersQuestion.newLine();
                UsersQuestion.write(questioninp.getText());
                UsersQuestion.newLine();
                UsersQuestion.write(passwordinp.getText());

                if(fileInfo.length()!=0)
                    UsersInfo.newLine();
                UsersInfo.write(usernameinp.getText().trim());
                UsersInfo.newLine();
                UsersInfo.write(passwordinp.getText().trim());
                UsersInfo.newLine();
                UsersInfo.write(phoneinp.getText().trim());
                UsersInfo.newLine();
                UsersInfo.write(balance);

                if(file.length()!=0)
                    Users.newLine();
                Users.write(usernameinp.getText().trim());
                Users.newLine();
                Users.write(passwordinp.getText().trim());



                JOptionPane.showMessageDialog(null,"Register is Successfully . Please Go to the Login Screen","SUCCESSFULL",JOptionPane.PLAIN_MESSAGE,null);



                Users.close();
                UsersInfo.close();
                UsersQuestion.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean readFile(String url, String id) throws FileNotFoundException {

        File file = new File(url);
        Scanner reader = new Scanner(file);
        answer = false;
        while (reader.hasNextLine()) {
            String Username=reader.nextLine();
            String pass=reader.nextLine();

            if (Username.toUpperCase().equals(id))
                answer = true;
        }

        return answer;
    }

}
