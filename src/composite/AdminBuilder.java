package composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

public class AdminBuilder implements IUsers{

    private String Username;
    private String Name;
    private String Surname;
    private String Password;
    private String Phone;
    private String Gender;

    List<IUsers> list = new ArrayList<IUsers>();

    public Admin getAdmin(){
        return new Admin(Username,Name,Surname,Password,Phone,Gender);
    }

    @Override
    public String getUsername() {
        return Username;
    }

    public AdminBuilder setUsername(String username) {
        Username = username;
        return this;
    }

    public AdminBuilder setName(String name) {
        Name = name;
        return this;
    }


    public AdminBuilder setSurname(String surname) {
        Surname = surname;
        return this;
    }

    @Override
    public String getPassword() {
        return Password;
    }

    public AdminBuilder setPassword(String password) {
        Password = password;
        return this;
    }

    public String getPhone() {
        return Phone;
    }


    public AdminBuilder setPhone(String phone) {
        Phone = phone;
        return this;
    }



    public AdminBuilder setGender(String gender) {
        Gender = gender;
        return this;
    }

    @Override
    public void getdisplay() {
        System.out.println("==========================");
        System.out.println("Username ="+getUsername());
        System.out.println("Password ="+getPassword());
        System.out.println("Phone ="+getPhone());
        System.out.println("==========================");

        Iterator<IUsers> it = list.iterator();

        while(it.hasNext())
        {
            IUsers employee = it.next();
            employee.getdisplay();
        }

    }

    @Override
    public void getAdd(IUsers iUsers) {
        list.add(iUsers);
    }

    @Override
    public void getRemove(IUsers iUsers) {
        list.remove(iUsers);
    }

    @Override
    public IUsers getChild(int child) {
        return list.get(child);
    }
}
