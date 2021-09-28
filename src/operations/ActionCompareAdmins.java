package operations;

import newPack.AdminPage;
import newPack.RealLoginAccess;

import javax.swing.*;
import java.io.IOException;

public class ActionCompareAdmins implements IActionCommand {
    private Operations operations;
    RealLoginAccess loginPage=new RealLoginAccess();


    public ActionCompareAdmins(Operations operations) {
        this.operations = operations;
    }

   @Override
    public void Execute() throws IOException {
        if(operations.compareAdmin(loginPage.usernameinp,loginPage.passwordinp)){
            AdminPage adminPage=new AdminPage();
            try {
                adminPage.start(loginPage.primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Incorrect Username or Password","ERROR",JOptionPane.ERROR_MESSAGE,null);
        }


    }
}
