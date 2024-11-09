package lt.decorator.first;

public class GreeterImpl implements Greeter{
    @Override
    public String greet(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName;
    }
}
