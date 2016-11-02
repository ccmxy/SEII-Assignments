package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import static org.mockito.Mockito.*;
import java.util.*;



public class SimpleBlackjackTest {

  @Test
  public void testMock(){
// Does it run without errors for a simple case?
DealerAction dt = mock(DealerAction.class);
PlayerAction pa = mock(PlayerAction.class);

//  This player is feeling charitiable....
when(pa.getAction()).thenReturn(PlayerAction.ActionType.HIT)
                          .thenReturn(PlayerAction.ActionType.HIT)
                          .thenReturn(PlayerAction.ActionType.HIT)
                          .thenReturn(PlayerAction.ActionType.HIT)
                          .thenReturn(PlayerAction.ActionType.HIT)
                          .thenReturn(PlayerAction.ActionType.HIT)
                    .thenReturn(PlayerAction.ActionType.HIT)
                    .thenReturn(PlayerAction.ActionType.STAND);
SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
j.playRound();
//Sign up a bug: Deal card was not called 9 times.
verify(dt, times(9)).dealCard(pa);
  }


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
  public void DealerIsInitallyDealtTwoCardsTest(){

    DealerAction dt = mock(DealerAction.class);
    PlayerAction pa = mock(PlayerAction.class);

    when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);

    SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
    j.playRound();

    verify(dt, times(2)).dealCard(dt);
  }

  @Test
  public void blackJackTest(){

    DealerAction dt = mock(DealerAction.class);
    PlayerAction pa = mock(PlayerAction.class);
    PlayerAction pb = mock(PlayerAction.class);

    when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);

    SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
    j.playRound();

    verify(dt, times(2)).dealCard(pa);

  }

//   @Test
//   public void playerHasInsuranceTest(){
//
//     DealerAction dt = mock(DealerAction.class);
//     PlayerAction pa = mock(PlayerAction.class);
//     Dealer dealer = mock(Dealer.class);
//     Player player = mock(Player.class);
//
//     //PLayer gets 21
//     List < Card > playerHand =  Arrays.asList(new Card(Card.Face.TEN, Card.Suit.HEART),
//     new Card(Card.Face.NINE, Card.Suit.HEART),new Card(Card.Face.TWO, Card.Suit.HEART));
//
//     //Dealer gets 2
//     List < Card > dealerHand = Arrays.asList(new Card(Card.Face.TWO, Card.Suit.HEART),
//     new Card(Card.Face.TWO, Card.Suit.HEART));
//
//     //Return the 21 point deck for player's hand and 2 point deck fo the dealer
//     when(player.getHand()).thenReturn(playerHand);
//     when(dealer.getHand()).thenReturn(dealerHand);
//
//     SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
//     j.playRound();
//
//
//     verify(pa, times(1)).acceptMoney(40);
//
// }
//
// @Test
// public void playerHasInsuranceTest(){
//
//   DealerAction dt = mock(DealerAction.class);
//   PlayerAction pa = mock(PlayerAction.class);
//   Dealer dealer = mock(Dealer.class);
//   Player player = mock(Player.class);
//
//   //PLayer gets 21
//   List < Card > playerHand =  Arrays.asList(new Card(Card.Face.TEN, Card.Suit.HEART),
//   new Card(Card.Face.NINE, Card.Suit.HEART),new Card(Card.Face.TWO, Card.Suit.HEART));
//
//   //Dealer gets 2
//   List < Card > dealerHand = Arrays.asList(new Card(Card.Face.TWO, Card.Suit.HEART),
//   new Card(Card.Face.TWO, Card.Suit.HEART));
//
//   //Return the 21 point deck for player's hand and 2 point deck fo the dealer
//   when(player.getHand()).thenReturn(playerHand);
//   when(dealer.getHand()).thenReturn(dealerHand);
//
//   SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
//   j.playRound();
//
//
//   verify(pa, times(1)).acceptMoney(40);
//
// }



// /*Bug found!!*/
// @Test
// public void upToThreePlayersTest(){
//
//   DealerAction dt = mock(DealerAction.class);
//   PlayerAction pa = mock(PlayerAction.class);
//   PlayerAction pb = mock(PlayerAction.class);
//   PlayerAction pc = mock(PlayerAction.class);
//
//   when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);
//   SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa,pb,pc});
//   j.playRound();
//   verify(dt, times(2)).dealCard(pa);
//
// }
  //   @Test
  //   public void testBasicFunctionality(){
	// // Does it run without errors for a simple case?
	// Dealer dealer = new Dealer();
	// Player[] players  = new Player[1];
	// players[0] = new Player(){
	// 	@Override
	// 	public int makeBet(){
	// 	    this.currentBet = 1 + ((int)Math.random()*5);
	// 	    return currentBet;
	// 	}
	//     };
	// SimpleBlackjack j = new SimpleBlackjack(dealer,players);
	// j.playRound();
  //
  //   }

}
