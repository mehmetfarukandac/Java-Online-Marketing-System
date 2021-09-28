package composite;

public class Admin extends AdminBuilder{
    private String Username;
    private String Name;
    private String Surname;
    private String Password;
    private String Phone;
    private String Gender;

    public Admin(String username, String name, String surname, String password, String phone, String gender) {
        super();
        this.Username = username;
        this.Name = name;
        this.Surname = surname;
        this.Password = password;
        this.Phone = phone;
        this.Gender = gender;
    }



    @Override
    public String toString() {
        return "Admin{" +
                "Username='" + Username + '\'' +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Password='" + Password + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}
