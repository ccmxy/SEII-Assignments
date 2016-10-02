package edu.osu.cs362;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;


public class CardCollectionTest {


 /*Test of the getCards method to retrieve cardsList from collection,
 as well as a test of the constructor for creating a new list.*/
 @Test
 public void getCardsAndUseConstructorTest() {
  Card testCard1 = new Card(Card.Face.THREE, Card.Suit.CLUB);
  Card testCard2 = new Card(Card.Face.FIVE, Card.Suit.DIAMOND);

  CardCollection testCollection = new CardCollection(testCard1, testCard2);
  List < Card > cardsList = testCollection.getCards();
  assertEquals(cardsList.size(), 2);
 }


 @Test
 public void addSingleCardTest() {
  Card testCard1 = new Card(Card.Face.TWO, Card.Suit.HEART);

  CardCollection testCollection = new CardCollection(testCard1);
  List < Card > cardsList = testCollection.getCards();
  assertEquals(cardsList.size(), 1);

  testCollection.add(new Card(Card.Face.THREE, Card.Suit.DIAMOND));
  testCollection.add(new Card(Card.Face.FOUR, Card.Suit.CLUB));

  cardsList = testCollection.getCards();
  assertEquals(cardsList.size(), 3);
 }


 @Test
 public void addListOfCardsTest() {

  CardCollection testCollection = new CardCollection();

  /*Make sure testCollection cards list is at size 0:*/
  List < Card > testCollectionCardsList = testCollection.getCards();
  assertEquals(testCollectionCardsList.size(), 0);

  /*Create test cards and add them to new list */
  Card testCard1 = new Card(Card.Face.TWO, Card.Suit.HEART);
  Card testCard2 = new Card(Card.Face.THREE, Card.Suit.DIAMOND);
  Card testCard3 = new Card(Card.Face.FOUR, Card.Suit.CLUB);
  List < Card > newCardList = Arrays.asList(testCard1, testCard2, testCard3);

  /*Add new list of cards to testCollection.cards*/
  testCollection.add(newCardList);

  /*Test that list was successfully added*/
  testCollectionCardsList = testCollection.getCards();
  assertEquals(testCollectionCardsList.size(), 3);
 }

 /*Test to ensure that the discardCard lowers the size of the CardCollection
 it is removed from by 1.*/
 @Test
 public void discardCardLowersListSizeTest() {

  CardCollection testCollection = new CardCollection(new Card(Card.Face.THREE, Card.Suit.CLUB),
   new Card(Card.Face.FIVE, Card.Suit.DIAMOND));
  /*Make sure testCollection cards list is at size 2:*/
  List < Card > testCollectionCardsList = testCollection.getCards();
  assertEquals(testCollectionCardsList.size(), 2);

  /*Remove card at position 1: */
  testCollection.discardCard(1);

  /*Collection size should now be 1: */
  testCollectionCardsList = testCollection.getCards();
  assertEquals(testCollectionCardsList.size(), 1);
 }


 /*Test to ensure that when discardCard is
 used on position 0, the card that had been put at position 1
 is now at position 0*/
 @Test
 public void discardCardMovesNextCardPositionTest() {

  CardCollection testCollection = new CardCollection(new Card(Card.Face.THREE, Card.Suit.CLUB),
   new Card(Card.Face.FIVE, Card.Suit.DIAMOND));

  /*Make sure the current card at position 0 is 3:*/
  List < Card > testCollectionCardsList = testCollection.getCards();
  assertEquals(testCollectionCardsList.get(0).face.getValue(), 3);


  /*Remove card at position 0 (the 3): */
  testCollection.discardCard(0);

  /*Test that card at position 0 now has a value of 5: */
  testCollectionCardsList = testCollection.getCards();
  assertEquals(testCollectionCardsList.get(0).face.getValue(), 5);
 }

 /*Test that discardCard  function returns the correct card*/
 @Test
 public void discardCardReturnsCorrectCardTest() {

  CardCollection testCollection = new CardCollection(new Card(Card.Face.THREE, Card.Suit.CLUB),
   new Card(Card.Face.FIVE, Card.Suit.DIAMOND));

  assertEquals(testCollection.discardCard(0), new Card(Card.Face.THREE, Card.Suit.CLUB));

 }


}
