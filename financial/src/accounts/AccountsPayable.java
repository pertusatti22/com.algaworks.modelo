package accounts;

import exception.AccountOperationException;
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

    public void payAccount() throws AccountOperationException {
        if(accountsStatus != AccountsStatus.PENDING){
            throw new AccountOperationException("A conta não pode ser paga!");
        }
        System.out.println("Descricao: " + description + " - Valor: " + value + " - Vencimento: " + dueDate + " - Fornecedor: " + provider.getName());
        this.accountsStatus = AccountsStatus.PAYED;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
