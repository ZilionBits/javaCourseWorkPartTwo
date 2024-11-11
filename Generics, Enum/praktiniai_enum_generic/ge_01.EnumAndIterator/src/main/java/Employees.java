import java.util.ArrayList;
import java.util.List;

public class Employees {

    List<Person> persons = new ArrayList<>();

    public void add(Person personToAdd){
        persons.add(personToAdd);
    }

    public void add(List<Person> personsToAdd){
        persons.addAll(personsToAdd);
    }

    public void print(){
        for(Person person : persons){
            System.out.println(person);
        }
    }

    public void print(Education education){
        for(Person person : persons){
            if(person.getEducation().equals(education)){
                System.out.println(person);
            }
        }
    }

    public void fire(Education education){
        for(Person person : persons){
            if(person.getEducation().equals(education)){
                persons.remove(person);
            }
        }
    }
}
