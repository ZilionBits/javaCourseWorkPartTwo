package lt.decorator.first;

public class GreeterSpaceBetweenLetterDecorator implements Greeter {

    private Greeter original;

    public GreeterSpaceBetweenLetterDecorator(Greeter original) {
        this.original = original;
    }

    @Override
    public String greet(String firstName, String lastName) {
        return original.greet(firstName, lastName).replace("", " ");
    }
}
