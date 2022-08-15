package accounts;

import exception.AccountOperationException;
import people.Customer;

public class AccountsReceivable extends Accounts{
    protected Customer customer;
    public AccountsReceivable(Customer customer, String description, Double value, String dueDate) {
        this();
        this.description = description;
        this.value = value;
        this.dueDate = dueDate;
        this.customer = customer;
    }

    public AccountsReceivable() {
        super();
    }

    @Override
    public void showAccountDetails() {
        System.out.println("|" + dueDate + "|" + super.accountsStatus + "|" + customer.getName() + "|" + description + "|" + value + "|");
    }

    public void receiveAccount() throws AccountOperationException{
        if(accountsStatus != AccountsStatus.PENDING){
            throw new AccountOperationException("A conta não pode ser recebida!");
        }
        System.out.println("Descricao: " + description + " - Valor: " + value + " - Vencimento: " + dueDate + " - Cliente: " + customer.getName());
        this.accountsStatus = AccountsStatus.PAYED;
    }

    @Override
    public void cancelAccount() throws AccountOperationException {
        if(value > 50000) {
            throw new AccountOperationException("A conta não pode ser cancelada, porque seu valor excede o limite permitido");
        }
        super.cancelAccount();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
