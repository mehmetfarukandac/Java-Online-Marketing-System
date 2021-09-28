package operations;

import javafx.scene.control.TextField;
import newPack.CustomerPage;
import store.electronic.SamsungGalaxyA30;
import store.electronic.SamsungGalaxyA70;
import store.food.PlainMilk;
import store.food.ProteinMilk;
import store.furniture.DecoristerDiva3;
import store.furniture.DecoristerDiva4;
import store.textile.BackgroundCurtain;
import store.textile.ZebraCurtain;

import java.io.IOException;

public class Context {
    ZebraCurtain zebraCurtain = new ZebraCurtain();
    BackgroundCurtain backgroundCurtain = new BackgroundCurtain();
    SamsungGalaxyA30 samsungGalaxyA30 =new SamsungGalaxyA30();
    SamsungGalaxyA70 samsungGalaxyA70 = new SamsungGalaxyA70();
    PlainMilk plainMilk = new PlainMilk();
    ProteinMilk proteinMilk = new ProteinMilk();
    DecoristerDiva4 decoristerDiva4 = new DecoristerDiva4();
    DecoristerDiva3 decoristerDiva3 = new DecoristerDiva3();

    public Context(ZebraCurtain zebraCurtain, BackgroundCurtain backgroundCurtain, SamsungGalaxyA30 samsungGalaxyA30, SamsungGalaxyA70 samsungGalaxyA70, PlainMilk plainMilk, ProteinMilk proteinMilk, DecoristerDiva4 decoristerDiva4, DecoristerDiva3 decoristerDiva3) {
        this.zebraCurtain = zebraCurtain;
        this.backgroundCurtain = backgroundCurtain;
        this.samsungGalaxyA30 = samsungGalaxyA30;
        this.samsungGalaxyA70 = samsungGalaxyA70;
        this.plainMilk = plainMilk;
        this.proteinMilk = proteinMilk;
        this.decoristerDiva4 = decoristerDiva4;
        this.decoristerDiva3 = decoristerDiva3;
    }
    public Context(){

    }

    private CustomerStrategy strategy;
    private ProductStrategy productStrategy;

    CustomerPage customerPage = new CustomerPage();
    public void addMethod(){
        strategy.add(customerPage.TFusername,customerPage.TFpassword,customerPage.TFphone,customerPage.TFbalance,customerPage.table);
    }

    public void deleteMethod(){
        strategy.delete(customerPage.table);
    }


    public Context(CustomerStrategy strategy) {
        this.strategy = strategy;
    }
    public Context(ProductStrategy strategy) {
        this.productStrategy = productStrategy;
    }


    public void write() throws IOException {
        zebraCurtain.write(zebraCurtain.productId,zebraCurtain.productName,zebraCurtain.price,zebraCurtain.companyName);
        backgroundCurtain.write(backgroundCurtain.productId,backgroundCurtain.productName,backgroundCurtain.price,backgroundCurtain.companyName);
        samsungGalaxyA30.write(samsungGalaxyA30.productId,samsungGalaxyA30.productName,samsungGalaxyA30.price,samsungGalaxyA30.companyName);
        samsungGalaxyA70.write(samsungGalaxyA70.productId,samsungGalaxyA70.productName,samsungGalaxyA70.price,samsungGalaxyA70.companyName);
        plainMilk.write(plainMilk.productId,plainMilk.productName,plainMilk.price,plainMilk.companyName);
        proteinMilk.write(proteinMilk.productId,proteinMilk.productName,proteinMilk.price,proteinMilk.companyName);
        decoristerDiva4.write(decoristerDiva4.productId,decoristerDiva4.productName,decoristerDiva4.price,decoristerDiva4.companyName);
        decoristerDiva3.write(decoristerDiva3.productId,decoristerDiva3.productName,decoristerDiva3.price,decoristerDiva3.companyName);
    }


}
