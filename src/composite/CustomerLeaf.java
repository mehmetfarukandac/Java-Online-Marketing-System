package composite;

public class CustomerLeaf extends CustomerLeafBuilder{
    private String username;
    private String password;
    private String phone;
    private String balance;

    public CustomerLeaf(String username, String password , String phone , String balance) {
        super();
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "CustomerLeaf{" +
                "username='" + username + '\'' +
                ", name='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                '}';
    }
}
