package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import static org.mockito.Mockito.*;
import org.mockito.InOrder;
import java.util.*;



public class VerifiedTest {
  @Test
  public void PlayerIsInitiallyDealtTwoCardsTest(){

    DealerAction dt = mock(DealerAction.class);
    PlayerAction pa = mock(PlayerAction.class);

    when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);

    SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
    j.playRound();

    verify(dt, times(2)).dealCard(pa);
  }

  @Test
  public void dealerIsInsuranceAvailableTrueTest() {
   Dealer dealer = new Dealer();
   //Create an ace
   Card card = new Card(Card.Face.ACE, Card.Suit.HEART);
   //Make it visible (face up)
   card.setVisible(true);
   //Give it to the dealer
   dealer.acceptCard(card);
   assertTrue(dealer.isInsuranceAvailable());
  }

  @Test
  public void dealerCompareAndSettlePlayerBustTest() {

    Dealer dealer = new Dealer();
    //Give the dealer a score of 19
    dealer.acceptCard(new Card(Card.Face.TEN, Card.Suit.HEART));
    dealer.acceptCard(new Card(Card.Face.NINE, Card.Suit.DIAMOND));


    Player player = new Player();

    //Give the player a score of 27.
    //Because their score is above 21, this is called a bust
    //and the player should lose their bet.

    player.acceptCard(new Card(Card.Face.NINE, Card.Suit.HEART));
    player.acceptCard(new Card(Card.Face.NINE, Card.Suit.DIAMOND));
    player.acceptCard(new Card(Card.Face.NINE, Card.Suit.DIAMOND));

    //Standard bet of 10 is placed
    player.makeBet();

    dealer.compareHandAndSettle(player);
    int currentWallet = player.currentWallet;

    //The player's wallet has gone from the default of
    // 1000 to 990
    assertEquals(currentWallet, 990);

   }


}
