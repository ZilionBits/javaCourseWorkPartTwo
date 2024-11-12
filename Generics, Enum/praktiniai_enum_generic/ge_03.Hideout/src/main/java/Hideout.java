public class Hideout<T> {

    T hideout;

    public void putIntoHideout(T toHide) {
        hideout = toHide;
    }

    public T takeFromHideout(){
        T temp = hideout;
        hideout = null;
        return temp;
    }

    public boolean isInHideout(){
        return hideout != null;
    }
}
