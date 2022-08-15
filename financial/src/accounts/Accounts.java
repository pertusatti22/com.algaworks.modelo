package accounts;

import exception.AccountOperationException;

public abstract class Accounts {
    protected String description;
    protected Double value;
    protected String dueDate;
    protected AccountsStatus accountsStatus;

    public Accounts() {
        this.accountsStatus = AccountsStatus.PENDING;
    }

    public abstract void showAccountDetails();

    public void cancelAccount() throws AccountOperationException {
        if(accountsStatus == AccountsStatus.PAYED) {
            throw new AccountOperationException("A conta já está paga!");
        } else if(accountsStatus == AccountsStatus.CANCELED) {
            throw new AccountOperationException("A conta já está cancelada!");
        }
        this.accountsStatus = AccountsStatus.CANCELED;
        System.out.println("A conta " + this.description + " foi cancelada!");
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
