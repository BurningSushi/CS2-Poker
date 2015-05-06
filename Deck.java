import java.util.*;

public class Deck {
   private ArrayList<Card> deck;
   private Random rng = new Random();

   public Deck(){
      deck = new ArrayList<Card>();
      //TODO: Add a card (2-14) of each suit (h,s,d,c)
      for(int i = 2; i < 14; i++;){
        deck.add(i,D);
        deck.add(i,S);
        deck.add(i,H);
        deck.add(i,C);
      }
   }

   public Card remove(){
      int rand = rng.nextInt(deck.size()-1);
      return deck.remove(rand);
   }

   public String toString(){
      return deck.toString();
   }
}
