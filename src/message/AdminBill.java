package message;

import newPack.OrderList;

import java.util.Date;

public class AdminBill extends AMesagge{
    OrderList orderList = new OrderList();

    @Override
    public String getUsername () {
        return orderList.productNameOrder;
    }

    @Override
    public String getPrice () {
        return orderList.priceOrder;
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
