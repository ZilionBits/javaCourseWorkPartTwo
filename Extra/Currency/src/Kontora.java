import lt.itakademija.exam.*;

public class Kontora implements CurrencyConverter {

    private CurrencyRatesProvider currencyRatesProvider;

    public Kontora(CurrencyRatesProvider currencyRatesProvider) {
        this.currencyRatesProvider = currencyRatesProvider;
    }

    @Override
    public Money convert(Currency currency, Currency currency1, Money money) {

        if(currency.equals(currency1)){
            return money;
        }

        Money convertRate = currencyRatesProvider.getRate(currency, currency1);

        if(convertRate == null){
            throw new CurrencyConversionException("Given pair convert rate not found.");
        }

        return money.multiply(convertRate);
    }
}
