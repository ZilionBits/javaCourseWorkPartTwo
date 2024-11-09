package lt.decorator.first;

public class Sandbox {
    public static void main(String[] args) {

        Greeter first = new GreeterImpl();

        System.out.println(first.greet("Bob", "Bobby"));

        Greeter firstUpperCase = new GreeterUpperCaseDecorator(first);

        System.out.println(firstUpperCase.greet("Bob", "Bobby"));

        Greeter firstExclamation = new GreeterExclamationMarkDecorator(first);

        System.out.println(firstExclamation.greet("Bob", "Bobby"));

        Greeter firstSpaceBetween = new GreeterSpaceBetweenLetterDecorator(first);

        System.out.println(firstSpaceBetween.greet("Bob", "Bobby"));
    }
}
