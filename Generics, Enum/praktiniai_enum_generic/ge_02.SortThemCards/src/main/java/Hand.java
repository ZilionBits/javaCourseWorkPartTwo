import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {

    private ArrayList<Card> cardsInHand = new ArrayList<>();

    public void add(Card card){
        cardsInHand.add(card);
    }

    public void print(){
        for(Card cards : cardsInHand){
            System.out.println(cards.toString());
        }
    }

    public void sort(){
        Collections.sort(cardsInHand);
    }

    public void sortBySuit(){
        Collections.sort(cardsInHand, new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand o) {
        int hand1 = cardsInHand.stream().mapToInt(Card::getValue).sum();
        int hand2 = o.cardsInHand.stream().mapToInt(Card::getValue).sum();
        return Integer.compare(hand1, hand2);
    }
}
