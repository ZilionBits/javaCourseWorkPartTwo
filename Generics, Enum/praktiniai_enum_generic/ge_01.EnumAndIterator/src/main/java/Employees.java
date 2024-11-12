import java.util.ArrayList;
import java.util.Iterator;
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
        Iterator<Person> iterator = persons.iterator();

        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getEducation().equals(education)) {
                System.out.println(person);
            }
        }
//        for(Person person : persons){
//            if(person.getEducation().equals(education)){
//                System.out.println(person);
//            }
//        }
    }

    public void fire(Education education){
        Iterator<Person> iterator = persons.iterator();

        while(iterator.hasNext()){
            Person person = iterator.next();
            if(person.getEducation().equals(education)){
                iterator.remove();
            }
        }
    }
}
