package operations;


import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Operations {
    public boolean compareCustomer(TextField usernameInp, PasswordField passwordInp) throws IOException {
        File users =new File("Users.txt");
        Scanner reader=new Scanner(users);
        int flag=0;
        while(reader.hasNextLine()){
            String username= reader.nextLine();
            String password= reader.nextLine();
            if(usernameInp.getText().equalsIgnoreCase(username)&&passwordInp.getText().equalsIgnoreCase(password)){
               flag++;
                File lastuser =new File("LastUser.txt");
                BufferedWriter writer=new BufferedWriter(new FileWriter(lastuser));
                writer.write(username);
                writer.newLine();
                writer.write(password);
                writer.close();

            }
        }
        if(flag==1){

            return true;
        }
        else{
            return false;
        }

    }

    public boolean compareAdmin(TextField usernameInp, PasswordField passwordInp) throws IOException {
        File users =new File("Admins.txt");
        Scanner reader=new Scanner(users);
        int flag=0;
        while(reader.hasNextLine()){
            String username= reader.nextLine();
            String password= reader.nextLine();
            if(usernameInp.getText().equalsIgnoreCase(username)&&passwordInp.getText().equalsIgnoreCase(password)){
                flag++;
                File lastuser =new File("LastUser.txt");
                BufferedWriter writer=new BufferedWriter(new FileWriter(lastuser));
                writer.write(username);
                writer.newLine();
                writer.write(password);
                writer.close();
            }
        }
        if(flag==1){
            return true;
        }
        else{
            return false;
        }


    }

    public  void writeTofile(ArrayList<String> list,String url) throws IOException {
        File file = new File(url);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < list.size(); i++) {

            writer.write(list.get(i).toString());
            if (!(i == (list.size() - 1)))
                writer.newLine();

        }
        writer.close();

    }

}