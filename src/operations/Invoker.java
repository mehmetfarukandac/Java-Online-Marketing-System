package operations;

import java.io.IOException;

public class Invoker {
    private IActionCommand compareUsers;
    private IActionCommand compareAdmins;

    public Invoker(){

    }

    public Invoker setCompareUsers(IActionCommand compareUsers) throws IOException {
        this.compareUsers = compareUsers;
        compareUsers.Execute();
        return this;
    }
    public Invoker setCompareAdmins(IActionCommand compareAdmins) throws IOException {
        this.compareAdmins = compareAdmins;
        compareAdmins.Execute();
        return this;
    }

}
