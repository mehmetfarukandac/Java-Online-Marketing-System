package newPack;

import javafx.application.Application;
import javafx.stage.Stage;
import login.ILogin;
import operations.ProductStrategy;
import store.electronic.SamsungGalaxyA30;
import store.electronic.SamsungGalaxyA70;
import store.food.PlainMilk;
import store.food.ProteinMilk;
import store.furniture.DecoristerDiva3;
import store.furniture.DecoristerDiva4;
import store.textile.BackgroundCurtain;
import store.textile.ZebraCurtain;

public class Main extends Application {

    public static void main(String[] args) throws ExceptionInInitializerError {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        ILogin login=new ProxyLoginAccess();
        login.grantLoginAccess(primaryStage);


    }
}
