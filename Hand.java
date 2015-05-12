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
     String firstSuit = hand.get(0).suit;
     if(hand.get(0).value==10 &&
        hand.get(1).toString().equals("J"+firstSuit) &&
        hand.get(2).toString().equals("Q"+firstSuit) &&
        hand.get(3).toString().equals("K"+firstSuit) &&
        hand.get(4).toString().equals("A"+firstSuit))
       return "Royal Flush";
     //Straight Flush
     for(int i = 0; i < 5; i++)
      if(hand.get(0).value==i &&
        (hand.get(1).value==i+1 && hand.get(1).suit.equals(firstSuit)) &&
        (hand.get(2).value==i+3 && hand.get(2).suit.equals(firstSuit)) &&
        (hand.get(3).value==i+4 && hand.get(3).suit.equals(firstSuit)) &&
        (hand.get(4).value==i+5 && hand.get(4).suit.equals(firstSuit)))
        return "Straight Flush";
     //Four of a Kind
     if(hand.get(0).value == hand.get(3).value || hand.get(1).value == hand.get(4).value)
        return "Four of a Kind,";
     //Full House
     if((hand.get(0).value==hand.get(1).value && hand.get(2).value==hand.get(4).value) ||
        (hand.get(0).value==hand.get(2).value && hand.get(3).value==hand.get(4).value) )
        return "Full House";
     //Flush
     String[] otherSuits = { hand.get(1).suit, hand.get(2).suit, hand.get(3).suit, hand.get(4).suit};
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
     if(hand.get(0).value == hand.get(4).value-4)
      return "Straight";
     //Three of a Kind
     for(int i = 0; i < 3; i++)
        if(hand.get(i).value == hand.get(i+1).value-1 && hand.get(i+1).value == hand.get(i+2).value -1 || hand.get(i).value == hand.get(i+1).value+1 && hand.get(i+1).value == hand.get(i+2).value + 1) {
          return "Three of a Kind";
        }
     //Two Pair
     int count = 0;
     for(int i = 0; i < 4; i++)
        if((hand.get(i).value == hand.get(i+1).value-1 || hand.get(i).value == hand.get(i+1).value+1)) {
          i++;
          count++;
        if(count == 2)
          return "Two Pair";
        }
     //One Pair
     for(int i = 0; i < 4; i++)
        if(hand.get(i).value == hand.get(i+1).value-1 || hand.get(i).value == hand.get(i+1).value+1) {
          return "One Pair";
        }
     //High Card
     return hand.get(4).value+"";
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
