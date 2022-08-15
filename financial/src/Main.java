import accounts.Accounts;
import accounts.AccountsPayable;
import accounts.AccountsReceivable;
import accounts.AccountsStatement;
import exception.AccountOperationException;
import people.Customer;
import people.Provider;

public class Main {

    public static void main(String[] args) {
        // Providers
        Provider realState = new Provider();
        realState.setName("Casa & Cia Negócios Imobiliários");

        Provider market = new Provider();
        market.setName("Mercado do João");

        // Customers
        Customer atacadista = new Customer();
        atacadista.setName("Triângulo Quadrado Atacadista");
        Customer telecom = new Customer();
        telecom.setName("FoneNet Telecom");

        // Accounts Payable
        AccountsPayable accountP1 = new AccountsPayable();
        accountP1.setDescription("Aluguel da matriz");
        accountP1.setValue(1230d);
        accountP1.setDueDate("10/05/2022");
        accountP1.setProvider(realState);

        AccountsPayable accountP2 = new AccountsPayable(market, "Compras do mês", 390d, "19/05/2012");

        AccountsPayable accountP3 = new AccountsPayable(realState, "Aluguel da filial", 700d, "11/05/2012");

        try {
            accountP1.payAccount();
            accountP2.cancelAccount();
            accountP2.cancelAccount();
        } catch (AccountOperationException e) {
            System.out.println("Você executou uma operação ilegal: " + e.getMessage());
        }

        try {
            accountP3.payAccount();
            accountP3.payAccount();
        } catch (AccountOperationException e) {
            System.out.println("Você executou uma operação ilegal: " + e.getMessage());
        }

        // Accounts Receivable

        AccountsReceivable accountR1 = new AccountsReceivable();
        accountR1.setDescription("Desenvolvimento de projeto de logística em Java");
        accountR1.setValue(89500d);
        accountR1.setDueDate("23/08/2022");
        accountR1.setCustomer(atacadista);

        AccountsReceivable accountR2 = new AccountsReceivable(telecom, "Manutenção em sistema de conta online", 55200d, "13/08/2022");

        try {
            accountR1.receiveAccount();
            accountR2.cancelAccount();
        } catch (AccountOperationException e) {
            System.out.println("Você executou uma operação ilegal: " + e.getMessage());
        }

        // Statements

        AccountsStatement statement = new AccountsStatement();
        Accounts[] accounts = new Accounts[]{accountP1,accountP2,accountP3,accountR1,accountR2};

        // statement.showAccountsList(accounts);
    }
}
