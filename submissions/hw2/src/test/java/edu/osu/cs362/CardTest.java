package edu.osu.cs362;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;


public class CardTest  {


      /*Constructor test*/
      @Test
       public void cardConstructorTest() {
         Card testCard1 = new Card(Card.Face.THREE, Card.Suit.CLUB);
         assertEquals(testCard1.suit, Card.Suit.CLUB);

       }

       /*test of getValue method of Face enum*/
       @Test
        public void getValueTest() {
          Card testCard1 = new Card(Card.Face.THREE, Card.Suit.CLUB);
          assertEquals(testCard1.face.getValue(), 3);

        }

        /*test 'equals' method of Card class on two cards that should be equal*/
        @Test
        public void equalsTestForEqualCards() {
          Card testCard1 = new Card(Card.Face.THREE, Card.Suit.DIAMOND);
          Card testCard2 = new Card(Card.Face.THREE, Card.Suit.DIAMOND);
          assertTrue(testCard1.equals(testCard2));
        }

        /*test 'equals' method of Card class on two cards that should
        NOT be equal, because they have different suits*/
        @Test
        public void equalsTestForCardsWithDifferentSuits() {
          Card testCard1 = new Card(Card.Face.THREE, Card.Suit.CLUB);
          Card testCard2 = new Card(Card.Face.THREE, Card.Suit.DIAMOND);
          assertFalse(testCard1.equals(testCard2));
        }

        /*test 'equals' method of Card class on two cards that should
        NOT be equal, because they have different faces*/
        @Test
        public void equalsTestForCardsWithDifferentFaces() {
          Card testCard1 = new Card(Card.Face.THREE, Card.Suit.CLUB);
          Card testCard2 = new Card(Card.Face.FOUR, Card.Suit.CLUB);
          assertFalse(testCard1.equals(testCard2));
        }

        /*Test of the overriden toString method in Card class*/
        @Test
        public void toStringTest() {
          Card testCard1 = new Card(Card.Face.THREE, Card.Suit.CLUB);
          assertEquals(testCard1.toString(), "THREECLUB");
        }

        /*Test to ensure that the new deck method creats protoDeck of
        52 cards*/
        @Test
        public void newDeckTest() {
           ArrayList<Card> cards = Card.newDeck();
          assertEquals(cards.size(), 52);
        }

        /*Test to set card to invisible*/
        @Test
        public void setInvisibleTest() {
          Card testCard1 = new Card(Card.Face.THREE, Card.Suit.CLUB);

          /*Set card invisible*/
          testCard1.setVisible(false);
          /*Assert that card is now invisible*/
          assertFalse(testCard1.isVisible());
        }


        /*Test to set card to visible*/
        @Test
        public void setVisibleTest() {
          Card testCard1 = new Card(Card.Face.THREE, Card.Suit.CLUB);

          /*Set card invisible*/
          testCard1.setVisible(false);

          /*Make sure card is set as invisible*/
          assertFalse(testCard1.isVisible());

          /*Set visible and test that it is now visibile*/
          testCard1.setVisible(true);
          assertTrue(testCard1.isVisible());
        }





}
