import java.util.*;

public class Hand implements Comparable {
   private ArrayList<Card> hand;

   public Hand(){
      hand = new ArrayList<Card>();
   }

   public void add(Card c){
      hand.add(c);
   }

   public void sortHand(){
      Collections.sort(hand); //Sorts smallest to largest
   }

   public String toString(){
      return hand.toString();
   }



   public String handValue() {
     //return "TODO: String of Best Hand; may need helper methods";
     //BEST
     //Royal Flush
     String firstSuit = hand(0).suit;
     if(hand(0).value==10 &&
        hand(1).toString.equals("11"+firstSuit) &&
        hand(2).toString.equals("12"+firstSuit) &&
        hand(3).toString.equals("13"+firstSuit) &&
        hand(4).toString.equals("14"+firstSuit))
       return "Royal Flush";
     //Straight Flush
     for(int i = 0; i < 5; i++)
      if(hand(0).value==i &&
        (hand(1).value==i+1 && hand(1).suit.equals(firstSuit)) &&
        (hand(2).value==i+3 && hand(2).suit.equals(firstSuit)) &&
        (hand(3).value==i+4 && hand(3).suit.equals(firstSuit)) &&
        (hand(4).value==i+5 && hand(4).suit.equals(firstSuit)))
        return "Straight Flush";
     //Four of a Kind
     if(hand(0).value == hand(3).value || hand(1).value == hand(4).value)
        return "Four of a Kind,";
     //Full House
     if((hand(0).value==hand(1) && hand(2).value==hand(4).value) ||
        (hand(0).value==hand(2) && hand(3).value==hand(4).value) )
        return "Full House";
     //Flush
     String[] otherSuits = { hand(1).suit, hand(2).suit, hand(3).suit, hand(4).suit};
     boolean flush = false;
     for(int i = 0; i < 5; i++) {
        if(firstSuit.equals(otherSuits[0]) && firstSuit.equals(otherSuits[i]))
          flush = true;
        else {
          flush = false;
          break;
        }
      }
        if(flush)
          return "Flush";
     //Straight
     if(hand(0).value == hand(4).value-4)
      return "Straight";
     //Three of a Kind
     for(int i = 0; i < 3; i++)
        if(hand(i).value == hand(i+1).value-1 && hand(i+1).value == hand(i+2).value -1 || hand(i).value == hand(i+1).value+1 && hand(i+1).value == hand(i+2).value + 1) {
          return "Three of a Kind";
        }
     //Two Pair
     int count = 0;
     for(int i = 0; i < 4; i++)
        if((hand(i).value == hand(i+1).value-1 || hand(i).value == hand(i+1).value+1)) {
          i++;
          count++;
        if(count == 2)
          return "Two Pair";
        }
     //One Pair
     for(int i = 0; i < 4; i++)
        if(hand(i).value == hand(i+1).value-1 || hand(i).value == hand(i+1).value+1) {
          return "One Pair";
        }
     //High Card
     return hand(4).value+"";
     //WORST

   }

   public int compareTo(Object y){
      Hand hand1 = this;
      //TODO: Compare hands by ordering above
      if(hand1.handValue().equals("Royal Flush"))
        return 9;
      if(hand1.handValue().equals("Straight Flush"))
        return 8;
      if(hand1.handValue().equals("Four of a Kind"))
        return 7;
      if(hand1.handValue().equals("Full House"))
        return 6;
      if(hand1.handValue().equals("Flush"))
        return 5;
      if(hand1.handValue().equals("Three of a Kind"))
        return 4;
      if(hand1.handValue().equals("Two Pair"))
        return 3;
      if(hand1.handValue().equals("One Pair"))
        return 2;
      else{ return 1;}
   }
}
