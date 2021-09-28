package operations;

import newPack.RealLoginAccess;
import newPack.StoreMenu;
import java.io.IOException;

public class ActionCompareUsers implements IActionCommand{
    private Operations operations;
    RealLoginAccess loginPage=new RealLoginAccess();


    public ActionCompareUsers(Operations operations) {
        this.operations = operations;
    }

    @Override
    public void Execute() throws IOException {
       if(operations.compareCustomer(loginPage.usernameinp,loginPage.passwordinp)){
           StoreMenu storeMenu=new StoreMenu();
           storeMenu.start(loginPage.primaryStage);

       }
       else{
           IActionCommand compareAdmins=new ActionCompareAdmins(operations);
           Invoker receiver = new Invoker();
           receiver.setCompareAdmins(compareAdmins);

           }


    }
}
