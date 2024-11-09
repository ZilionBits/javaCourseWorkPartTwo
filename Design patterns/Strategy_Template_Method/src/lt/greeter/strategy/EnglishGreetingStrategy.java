package lt.greeter.strategy;

public class EnglishGreetingStrategy implements GreeterLanguageStrategy {

    @Override
    public String getGreetingString() {
        return "Hello";
    }
}
