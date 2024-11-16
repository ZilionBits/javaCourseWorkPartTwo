import lt.itakademija.exam.*;

import java.util.HashSet;
import java.util.Set;

public class Euras implements Bank {
    SequenceGenerator uniqueCustomerId = new SequenceGenerator();
    SequenceGenerator uniqueAccountId = new SequenceGenerator();
    SequenceGenerator uniqueOperationId = new SequenceGenerator();
    Set<Customer> customers = new HashSet<>();
    CurrencyConverter currencyConverter;

    public Euras(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    @Override
    public Customer createCustomer(PersonCode personCode, PersonName personName) {
        if(personCode == null) {
            throw new NullPointerException("Person code is required.");
        }
        if(personName == null) {
            throw new NullPointerException("Person name is required.");
        }

        if(customers.stream().anyMatch(c -> c.getPersonCode().equals(personCode))){
            throw new CustomerCreateException("Customer already exists.");
        }

        Customer customer = new Customer(uniqueCustomerId.getNext(),personCode,personName);
        customers.add(customer);

        return customer;
    }

    @Override
    public Account createAccount(Customer customer, Currency currency) {

        if(customer == null || currency == null){
            throw new NullPointerException("Must give customer.");
        }

        if(!customers.contains(customer)){
            throw new AccountCreateException("Customer does not exist.");
        }

        Account account = new Account(uniqueAccountId.getNext(), customer, currency, new Money(0.0));

        customer.addAccount(account);

        return account;
    }

    @Override
    public Operation transferMoney(Account account, Account account1, Money money) {

        if(account.getBalance().isLessThan(money)){
            throw new InsufficientFundsException("Not enough gold my Lord.");
        }

        Operation operation = new Operation(uniqueOperationId.getNext(), account, account1, money);
        account = operation.getDebitAccount();
        account1 = operation.getCreditAccount();

        if(!(account.getCurrency().equals(account1.getCurrency()))){
            account.setBalance(account.getBalance().substract(money));
            account1.setBalance(account1.getBalance().add(currencyConverter.convert(account.getCurrency(),account1.getCurrency(),money)));
        }

        return operation;
    }

    @Override
    public Money getBalance(Currency currency) {

        return customers.stream().flatMap(c -> c.getAccounts().stream())
                .map(a -> currencyConverter.convert(a.getCurrency(),currency,a.getBalance()))
                .reduce(new Money(0), Money::add);
    }
}
