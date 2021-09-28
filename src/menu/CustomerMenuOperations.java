package menu;

import composite.CustomerLeafBuilder;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import newPack.CustomerPage;
import operations.CustomerStrategy;
import operations.Operations;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMenuOperations implements CustomerStrategy {


    @Override
    public void add(TextField TFusername, TextField TFpassword, TextField TFphone, TextField TFbalance, TableView<CustomerLeafBuilder> table) {
        File fileNames = new File("Users.txt");
        try {
            Scanner reader = new Scanner(fileNames);
            int flag=0;
            while(reader.hasNextLine()){
                String username=reader.nextLine();
                String    password=reader.nextLine();
                if(username.trim().toUpperCase().equals(TFusername.getText().trim().toUpperCase()))
                    flag++;
            }

            reader.close();



            if((TFusername.getText().contains(" "))){
                JOptionPane.showMessageDialog(null,"Username cannot contain space","Username",JOptionPane.ERROR_MESSAGE,null);

            }
            else if((TFpassword.getText().contains(" "))){
                JOptionPane.showMessageDialog(null,"Username cannot contain space","Username",JOptionPane.ERROR_MESSAGE,null);

            }

            else if(!(TFusername.getText().trim().length()>=6)&&!(TFusername.getText().trim().length()<15)){
                JOptionPane.showMessageDialog(null,"Username cannot contain space","Username",JOptionPane.ERROR_MESSAGE,null);

            }

            else if(!(TFusername.getText().trim().length()<=15)){
                JOptionPane.showMessageDialog(null,"Username cannot contain space","Username",JOptionPane.ERROR_MESSAGE,null);

            }

            else if(!(TFpassword.getText().trim().length()<=15)){
                JOptionPane.showMessageDialog(null,"Password should be at most 15 Characters","Password",JOptionPane.ERROR_MESSAGE,null);

            }
            else if(!(TFphone.getText().trim().length()==11)){
                JOptionPane.showMessageDialog(null,"Phone should be equal 11 Characters","Phone",JOptionPane.ERROR_MESSAGE,null);

            }
            else if((TFphone.getText().contains(" "))){
                JOptionPane.showMessageDialog(null,"Phone cannot contain space","Phone",JOptionPane.ERROR_MESSAGE,null);

            }

            else if(!(TFpassword.getText().trim().length()>=6)){
                JOptionPane.showMessageDialog(null,"Password should be at least 6 Characters","Password",JOptionPane.ERROR_MESSAGE,null);

            }

            else if(flag==1){
                JOptionPane.showMessageDialog(null,"This ID s already taken by another user","ID",JOptionPane.ERROR_MESSAGE,null);

            }

            else{



                File fileInfo = new File("Customers.txt");
                File fileUser = new File("Users.txt");
                BufferedWriter UsersInfo= new BufferedWriter(new FileWriter(fileInfo,true));
                BufferedWriter Users = new BufferedWriter(new FileWriter(fileUser, true));


                if(fileInfo.length()!=0)
                    UsersInfo.newLine();
                UsersInfo.write(TFusername.getText().trim());
                UsersInfo.newLine();
                UsersInfo.write(TFpassword.getText().trim());
                UsersInfo.newLine();
                UsersInfo.write(TFphone.getText().trim());
                UsersInfo.newLine();
                UsersInfo.write(TFbalance.getText().trim());


                if(fileUser.length()!=0)
                    Users.newLine();
                Users.write(TFusername.getText().trim());
                Users.newLine();
                Users.write(TFpassword.getText().trim());


                CustomerPage customerPage =new CustomerPage();

                UsersInfo.close();
                Users.close();
                table.getItems().removeAll();
                table.setItems(customerPage.getDisplay());

            }

            TFusername.clear();
            TFbalance.clear();
            TFphone.clear();
            TFpassword.clear();


        }
        catch (IOException ed){
            ed.printStackTrace();
        }
    }

    @Override
    public void delete(TableView<CustomerLeafBuilder> table) {
        Operations operations = new Operations() ;
        try {
            ObservableList<CustomerLeafBuilder> userSelected;

            userSelected=table.getSelectionModel().getSelectedItems();
            CustomerLeafBuilder selected=userSelected.get(0);
            if(table.getSelectionModel().isEmpty()==false) {


                File fileInfo = new File("Customers.txt");
                File fileUsers = new File("Users.txt");
                ArrayList Info=new ArrayList();
                ArrayList Users=new ArrayList();


                Scanner readInfo = new Scanner(fileInfo);
                Scanner readUsers = new Scanner(fileUsers);

                while (readUsers.hasNextLine()) {
                    String username = readUsers.nextLine();
                    String password = readUsers.nextLine();

                    int flag = 0;


                    if (selected.getUsername().trim().toUpperCase().equals(username.trim().toUpperCase()) && selected.getPassword().trim().toUpperCase().equals(password.trim().toUpperCase())) {
                        flag = 1;

                    }

                    if (flag == 0) {
                        Users.add(username);
                        Users.add(password);

                    }

                }
                while (readInfo.hasNext()) {
                    String Username = readInfo.next();
                    String Password = readInfo.next();
                    String Phone = readInfo.next();
                    String Balance = readInfo.next();

                    int flag = 0;
                    if (selected.getUsername().trim().toUpperCase().equals(Username.trim().toUpperCase()) &&
                            selected.getPassword().trim().toUpperCase().equals(Password.trim().toUpperCase()) &&
                            selected.getPhone().trim().toUpperCase().equals(Phone.trim().toUpperCase()) &&
                            selected.getBalance().trim().toUpperCase().equals(Balance.trim().toUpperCase())) {
                        flag = 1;

                    }
                    if (flag == 0) {

                        Info.add(Username);
                        Info.add(Password);
                        Info.add(Phone);
                        Info.add(Balance);
                    }

                }
                readInfo.close();
                readUsers.close();
                operations.writeTofile(Users, "Users.txt");
                operations.writeTofile(Info, "Customers.txt");

                CustomerPage customerPage =new CustomerPage();

                table.getItems().removeAll();
                table.setItems(customerPage.getDisplay());
            }
            else{
                JOptionPane.showMessageDialog(null,"You must click one item","CLİCK",JOptionPane.ERROR_MESSAGE,null);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
