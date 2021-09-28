package message;

import newPack.RealLoginAccess;
import newPack.StoreMenu;

import java.util.Date;

public class CustomerBill extends AMesagge{
    RealLoginAccess loginPage = new RealLoginAccess();
    StoreMenu storeMenu = new StoreMenu();


        @Override
        public String getUsername () {
            return loginPage.usernameinp.getText();
        }


        @Override
        public String getPrice () {
            return Integer.toString(storeMenu.total_amount);
        }

        @Override
        public String getCompanyName () {
            return "AndacBeyazit";
        }

        @Override
        public Date getDate () {
            return new Date();
        }

}
