package lt.greeter.strategy;

public class Greeter {
    private GreeterLanguageStrategy greeterLanguageStrategy;

    public Greeter(GreeterLanguageStrategy greeterLanguageStrategy) {
        this.greeterLanguageStrategy = greeterLanguageStrategy;
    }

    public void setGreeterLanguageStrategy(GreeterLanguageStrategy greeterLanguageStrategy) {
        this.greeterLanguageStrategy = greeterLanguageStrategy;
    }

    public String greet(String firstName, String lastName) {
        return greeterLanguageStrategy.getGreetingString()
                +" "+firstName+" "+lastName;
    }
}
