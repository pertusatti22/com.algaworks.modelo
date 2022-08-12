package accounts;

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

    public void receiveAccount(){
        if(accountsStatus != AccountsStatus.PENDING){
            System.out.println("A Conta " + this.description + " não pode ser recebida!");
        } else {
            System.out.println("Descricao: " + description + " - Valor: " + value + " - Vencimento: " + dueDate + " - Cliente: " + customer.getName());
            this.accountsStatus = AccountsStatus.PAYED;
        }
    }

    @Override
    public void cancelAccount() {
        if(value <= 50000){
            super.cancelAccount();
        } else {
            System.out.println("A Conta " + this.description + " não pode ser cancelada, porque seu valor de " + this.value + " excede o limite permitido");
        }

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
