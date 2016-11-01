package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import java.util.*;

public class ColleenTest {

 /********************************
 ********************************
 ********************************
       Card Tests
  ********************************
  ********************************
  *********************************/

 @Test
 public void cardToStringTest() {
  Card card = new Card(Card.Face.TWO, Card.Suit.DIAMOND);
  String cardstring = card.toString();
  assertEquals(cardstring, "TWODIAMOND");
 }

 @Test
 public void cardIsVisibleTrueTest() {
  Card card = new Card(Card.Face.TWO, Card.Suit.HEART);
  card.setVisible(true);
  boolean visibility = card.isVisible();
  assertTrue(visibility);

 }

 @Test
 public void cardIsVisibleFalseTest() {
  Card card = new Card(Card.Face.QUEEN, Card.Suit.SPADE);
  card.setVisible(false);
  boolean visibility = card.isVisible();
  assertFalse(visibility);
 }

 @Test
 public void cardNewDeckTest() {
  ArrayList < Card > cards = Card.newDeck();
  assertEquals(cards.size(), 52);
 }

 @Test
 public void cardGetValueTest() {
  Card card = new Card(Card.Face.THREE, Card.Suit.CLUB);
  assertEquals(card.face.getValue(), 3);
 }


 /********************************
 ********************************
 ********************************
     Dealer Tests
  ********************************
  ********************************
  *********************************/


 @Test
 public void dealerConstructorTest() {
  Dealer dealer = new Dealer();
  List < Card > deck = dealer.getHand();
  assertEquals(deck.get(0).face.getValue(), 2);
 }

 @Test
 public void dealerAcceptCardTest() {
  Dealer dealer = new Dealer();
  dealer.acceptCard(new Card(Card.Face.SEVEN, Card.Suit.CLUB));
  List < Card > deck = dealer.getHand();
  assertEquals(deck.get(52).face.getValue(), 7);
 }

 /************* Dealer Class Insurance Tests *************/

 @Test
 public void dealerIsInsuranceAvailableFalseTest() {
  Dealer dealer = new Dealer();
  assertFalse(dealer.isInsuranceAvailable());
 }

/*THIS FAILS, BUT WOULD PASS IF THE CODE DIDNT HAVE BUGS*/
 @Test
 public void dealerIsInsuranceAvailableTrueTest() {
  Dealer dealer = new Dealer();
  Card card = new Card(Card.Face.ACE, Card.Suit.HEART);
  card.setVisible(true);
  dealer.acceptCard(card);
  assertTrue(dealer.isInsuranceAvailable());
 }
 /*************                           *************/

  @Test
  public void dealerShuffleDeckTest(){
    Dealer dealer = new Dealer();
    List<Card> dealerUnShuffledDeck = dealer.getHand();
    List<Card> plainDeck = Card.newDeck();
    assertEquals(dealerUnShuffledDeck, plainDeck);
    dealer.shuffleDeck();
    List<Card> shuffledDeck = dealer.getHand();
    assertNotEquals(shuffledDeck, plainDeck);
  }

 @Test
 public void dealerSetDeckTest() {
  Dealer dealer = new Dealer();
  List < Card > deck = Card.newDeck();
  dealer.setDeck(deck);
  List < Card > dealerHand = dealer.getHand();
  assertEquals(dealerHand.get(0).face.getValue(), 2);
 }


 @Test
 public void dealerDealCardTest() {
  Dealer dealer = new Dealer();
  dealer.acceptCard(new Card(Card.Face.QUEEN, Card.Suit.HEART));
  dealer.acceptCard(new Card(Card.Face.THREE, Card.Suit.DIAMOND));
  List < Card > deck1 = dealer.getHand();

  assertEquals(deck1.get(53).face, Card.Face.THREE);
  Player player = new Player();
  dealer.dealCard(player);
  List < Card > deck2 = dealer.getHand();

  assertEquals(deck1.get(52).face, Card.Face.THREE);
 }


 @Test
 public void dealerCompareAndSettlePlayerWinTest() {

   Dealer dealer = new Dealer();
   dealer.acceptCard(new Card(Card.Face.FIVE, Card.Suit.HEART));
   dealer.acceptCard(new Card(Card.Face.SIX, Card.Suit.DIAMOND));


   Player player = new Player();
   player.acceptCard(new Card(Card.Face.TEN, Card.Suit.HEART));
   player.acceptCard(new Card(Card.Face.NINE, Card.Suit.DIAMOND));
   player.makeBet();

   dealer.compareHandAndSettle(player);
   //The player should now have a bet of 20
   int currentBet = player.getCurrentBet();

   assertEquals(currentBet, 20);

  }

  // @Test
  // public void dealerCompareAndSettlePlayerBustTest() {
  //
  //   Dealer dealer = new Dealer();
  //   dealer.acceptCard(new Card(Card.Face.TEN, Card.Suit.HEART));
  //   dealer.acceptCard(new Card(Card.Face.NINE, Card.Suit.DIAMOND));
  //
  //
  //   Player player = new Player();
  //   player.acceptCard(new Card(Card.Face.NINE, Card.Suit.HEART));
  //   player.acceptCard(new Card(Card.Face.NINE, Card.Suit.DIAMOND));
  //   player.acceptCard(new Card(Card.Face.NINE, Card.Suit.DIAMOND));
  //
  //   player.makeBet();
  //
  //   dealer.compareHandAndSettle(player);
  //
  //   assertNotEquals(player.getCurrentBet();, 20);
  //
  //  }


  /********************************
  ********************************
  ********************************
       Player Tests
   ********************************
   ********************************
   *********************************/


 /************* Player Class Insurance Tests *************/

 @Test
 public void playerMoveMoneyToInsuranceWithEnoughFundsTest() {
  Player player = new Player();
  player.moveMoneyToInsurance(500);
  int insurance = player.makeInsuranceBet();
  assertEquals(insurance, 500);
 }

 /*This throws an error, as it is supposed to*/
  @Test
  public void playeMoveMoneyToInsuranceInsufficientFundsTest() {
   Player player = new Player();
   player.moveMoneyToInsurance(1500);
   int insurance = player.makeInsuranceBet();
   assertEquals(insurance, 0);
  }

 /************* Player Class Bet Tests *************/

 @Test
 public void playerDoubltDownBetTest() {
  Player player = new Player();
  player.makeBet();
  int doubledBet1 = player.doubleDownBet();
  assertEquals(doubledBet1, 20);
  int doubledBet2 = player.doubleDownBet();
  assertEquals(doubledBet2, 40);
 }

  @Test
  public void playerMakeBetTest() {
   Player player = new Player();
   int bet = player.makeBet();
   assertEquals(bet, 10);
  }

 @Test
 public void playeGetCurrentBetTest() {
  Player player = new Player();
  player.makeBet();
  player.doubleDownBet();
  int currentBet = player.getCurrentBet();
  assertEquals(currentBet, 20);
 }

 @Test
 public void playerMoneyToBetWithEnoughFundsTest() {
  Player player = new Player();
  player.moveMoneyToBet(500);
  int bet = player.getCurrentBet();
  assertEquals(bet, 500);
 }

 //This throws an error, like it's meant to
 @Test
 public void playerMoneyToBetWithBadFundsTest() {
  Player player = new Player();
  player.moveMoneyToBet(1500);
  int bet = player.getCurrentBet();
  assertEquals(bet, 500);
 }

 /************* Other Player class tests *************/

 @Test
 public void playerToStringTest() {
  Player player = new Player();
  player.acceptCard(new Card(Card.Face.QUEEN, Card.Suit.HEART));
  player.moveMoneyToBet(500);
  player.moveMoneyToInsurance(100);
  assertEquals(player.toString(), "Player: [QUEENHEART]w 400b 500i 100");
 }

 @Test
 public void playerNextHandTest() {
  Player player = new Player();
  player.acceptCard(new Card(Card.Face.QUEEN, Card.Suit.HEART));
  player.moveMoneyToBet(500);
  player.moveMoneyToInsurance(100);
  player.nextHand();
  assertEquals(player.toString(), "Player: [QUEENHEART]w nullb nulli null");
 }


 @Test
 public void playerGetActionTest() {
  Player player = new Player();
  PlayerAction.ActionType action = player.getAction();
  assertEquals(action, PlayerAction.ActionType.STAND);
 }

 @Test
 public void playerAcceptMoneyTest() {
  Player player = new Player();
  player.acceptMoney(5000);
  int wallet = player.currentWallet;
  assertEquals(wallet, 6000);
 }


 @Test
 public void playerAcceptCardTest() {
  Player player = new Player();
  player.acceptCard(new Card(Card.Face.QUEEN, Card.Suit.HEART));
  List < Card > hand = player.getHand();
  assertEquals(hand.get(0).toString(), "QUEENHEART");
 }



}
