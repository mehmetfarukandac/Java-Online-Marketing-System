package composite;

public interface IUsers {
     String getUsername();
     String getPassword();
     void getdisplay();
     void getAdd(IUsers iUsers);
     void getRemove(IUsers iUsers);
     IUsers getChild(int child);
}
