package operations;

import composite.CustomerLeafBuilder;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public interface CustomerStrategy {
    void add(TextField TFusername, TextField TFpassword, TextField TFphone, TextField TFbalance, TableView<CustomerLeafBuilder> table);
    void delete(TableView<CustomerLeafBuilder> table);
}
