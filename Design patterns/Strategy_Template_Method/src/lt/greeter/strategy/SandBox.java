package lt.greeter.strategy;

public class SandBox {
    public static void main(String[] args) {

        Greeter greet = new Greeter(() -> "Labas!");

        System.out.println(greet.greet("Bob", "Bobby"));

        greet.setGreeterLanguageStrategy(new EnglishGreetingStrategy());

        System.out.println(greet.greet("Mike", "Mikey"));

        greet.setGreeterLanguageStrategy(() -> "Hello...");

        System.out.println(greet.greet("Mike", "Mikey"));
    }
}
