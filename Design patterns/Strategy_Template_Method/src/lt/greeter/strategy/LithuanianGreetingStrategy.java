package lt.greeter.strategy;

public class LithuanianGreetingStrategy implements GreeterLanguageStrategy{
    @Override
    public String getGreetingString() {
        return "Labas";
    }
}
