package message;

import newPack.StoreMenu;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AMesagge {
    StoreMenu storeMenu = new StoreMenu();
    public void yazdir(){
        JOptionPane.showMessageDialog(null,billMessage(),"BILL",JOptionPane.PLAIN_MESSAGE,null);

    }

    private String billMessage(){
        StringBuilder billMessages = new StringBuilder();

        String getDateFormat = getDateFormat();

        billMessages.append("*****************************************************************************");
        billMessages.append("\n");
        billMessages.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "DATE:" + getDateFormat);
        billMessages.append("\n");
        billMessages.append("USERNAME: " + getUsername() + "\n");
        billMessages.append("TOTAL PRİCE: " + storeMenu.total_amount+ "\n");
        billMessages.append("THANK YOU SO MUCH :)"+ "\n");
        billMessages.append("****************************************************" + getCompanyName()+ "\n");
        billMessages.append("*****************************************************************************");



        return billMessages.toString();
    }

    private String getDateFormat(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        return simpleDateFormat.format(getDate());
    }

    //TEMPLATE
    public abstract String getUsername();
    public abstract String getPrice();
    public abstract String getCompanyName();
    public abstract Date getDate();

}
