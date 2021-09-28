package newPack;

import javafx.application.Application;
    import javafx.stage.Stage;
import login.ILogin;


public class ProxyLoginAccess  implements ILogin  {
        ILogin realLoginAccess;


    @Override
    public void grantLoginAccess(Stage stage) {
    if(realLoginAccess==null)
        realLoginAccess=new RealLoginAccess();

        realLoginAccess.grantLoginAccess(stage);


    }
}