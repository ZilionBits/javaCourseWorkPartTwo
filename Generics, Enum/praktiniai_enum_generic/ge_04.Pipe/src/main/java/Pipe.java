import java.util.ArrayList;

public class Pipe<T> {

    ArrayList<T> pipe = new ArrayList<>();


    public void putIntoPipe(T value){
        pipe.add(0, value);
    }

    public T takeFromPipe(){
        if(pipe.isEmpty()){
            return null;
        }
        T temp = pipe.get(pipe.size()-1);
        pipe.remove(temp);
        return temp;
    }

    public boolean isInPipe(){
        return !pipe.isEmpty();
    }
}
