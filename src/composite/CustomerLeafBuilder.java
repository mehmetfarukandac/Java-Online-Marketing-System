package composite;


public class CustomerLeafBuilder implements IUsers {
    private String username;
    private String password;
    private String phone;
    private String balance;

    public CustomerLeafBuilder(String username, String password, String phone, String balance) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.balance = balance;
    }

    public CustomerLeafBuilder() {

    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public CustomerLeafBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public CustomerLeafBuilder setUsername(String username) {
        this.username = username;
        return this;
    }



    public String getPhone() {
        return phone;
    }



    public CustomerLeafBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getBalance() {
        return balance;
    }

    public CustomerLeafBuilder setBalance(String balance) {
        this.balance = balance;
        return this;
    }

    @Override
    public void getdisplay() {
        System.out.println("==========================");
        System.out.println("username ="+getUsername());
        System.out.println("Password ="+getPassword());
        System.out.println("Phone ="+getPhone());
        System.out.println("Balance="+getBalance());
        System.out.println("==========================");
    }

    @Override
    public void getAdd(IUsers iUsers) {

    }

    @Override
    public void getRemove(IUsers iUsers) {

    }

    @Override
    public IUsers getChild(int child) {
        return null;
    }
}
