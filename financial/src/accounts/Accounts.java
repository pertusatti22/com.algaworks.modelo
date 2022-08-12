package accounts;

public abstract class Accounts {
    protected String description;
    protected Double value;
    protected String dueDate;
    protected AccountsStatus accountsStatus;

    public Accounts() {
        this.accountsStatus = AccountsStatus.PENDING;
    }

    public abstract void showAccountDetails();

    public void cancelAccount(){
        if(accountsStatus == AccountsStatus.PENDING){
            this.accountsStatus = AccountsStatus.CANCELED;
            System.out.println("A conta " + this.description + " foi cancelada!");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

}
