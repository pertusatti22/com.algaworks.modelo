package accounts;

public class AccountsStatement {

    public void showAccountsList(Accounts[] accounts){
        for (Accounts account:accounts) {
            account.showAccountDetails();
        }

    }
}
