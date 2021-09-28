package login;

import javafx.stage.Stage;
import newPack.RealLoginAccess;


public class Login implements ILogin{
    @Override
    public void grantLoginAccess(Stage stage) {
        RealLoginAccess proxyLoginAcces = new RealLoginAccess();
        proxyLoginAcces.grantLoginAccess(stage);
    }
}
