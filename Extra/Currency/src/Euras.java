import lt.itakademija.exam.*;

import java.util.HashSet;
import java.util.Set;

public class Euras implements Bank {
    SequenceGenerator uniqueCustomerId = new SequenceGenerator();
    SequenceGenerator uniqueAccountId = new SequenceGenerator();
    Set<Customer> customers = new HashSet<>();

    @Override
    public Customer createCustomer(PersonCode personCode, PersonName personName)
            throws NullPointerException, CustomerCreateException {
        if(personCode == null) {
            throw new NullPointerException("Person code is required.");
        }
        if(personName == null) {
            throw new NullPointerException("Person name is required.");
        }

        return new Customer(uniqueCustomerId.getNext(),personCode,personName);
    }

    @Override
    public Account createAccount(Customer customer, Currency currency) {


        return new Account(uniqueAccountId.getNext(),customer,currency,new Money(0.0));
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
