import lt.itakademija.exam.*;

import java.util.HashSet;
import java.util.Set;

public class Euras implements Bank {
    SequenceGenerator uniqueCustomerId = new SequenceGenerator();
    SequenceGenerator uniqueAccountId = new SequenceGenerator();
    Set<Customer> customers = new HashSet<>();
    CurrencyConverter currencyConverter;

    public Euras(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    @Override
    public Customer createCustomer(PersonCode personCode, PersonName personName)
            throws NullPointerException, CustomerCreateException {
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

        Account account = new Account(uniqueAccountId.getNext(), customer, currency, new Money(0.0));
        customer.addAccount(account);

        return account;
    }

    @Override
    public Operation transferMoney(Account account, Account account1, Money money) {
        return null;
    }

    @Override
    public Money getBalance(Currency currency) {
        return null;
    }
}
