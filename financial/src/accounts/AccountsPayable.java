package accounts;

import people.Provider;

public class AccountsPayable extends Accounts {
    protected Provider provider;

    public AccountsPayable(Provider provider, String description, Double value, String dueDate) {
        this();
        this.description = description;
        this.value = value;
        this.dueDate = dueDate;
        this.provider = provider;
    }

    public AccountsPayable() {
        super();
    }

    @Override
    public void showAccountDetails() {
        System.out.println("|" + dueDate + "|" + super.accountsStatus + "|" + provider.getName() + "|" + description + "|" + value + "|");
    }

    public void payAccount(){
        if(accountsStatus != AccountsStatus.PENDING){
            System.out.println("A Conta " + this.description + " não pode ser paga!");
        } else {
            System.out.println("Descricao: " + description + " - Valor: " + value + " - Vencimento: " + dueDate + " - Fornecedor: " + provider.getName());
            this.accountsStatus = AccountsStatus.PAYED;
        }
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
