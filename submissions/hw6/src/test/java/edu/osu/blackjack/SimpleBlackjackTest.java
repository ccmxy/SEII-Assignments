package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import static org.mockito.Mockito.*;
import org.mockito.InOrder;
import java.util.*;



public class SimpleBlackjackTest {

  @Test
  public void testMock(){
DealerAction dt = mock(DealerAction.class);
PlayerAction pa = mock(PlayerAction.class);

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
//Sign of a bug: Deal card was not called 9 times...
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
  public void dealerOffersBetToAllPlayers(){

    DealerAction da = mock(DealerAction.class);
    PlayerAction pa = mock(PlayerAction.class);
    PlayerAction pa2 = mock(PlayerAction.class);
    PlayerAction pa3 = mock(PlayerAction.class);

    when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);
    when(pa2.getAction()).thenReturn(PlayerAction.ActionType.STAND);
    when(pa3.getAction()).thenReturn(PlayerAction.ActionType.STAND);

    SimpleBlackjack j = new SimpleBlackjack(da,new PlayerAction[]{pa,pa2,pa3});
    j.playRound();

    verify(pa, times(1)).makeBet();
    verify(pa2, times(1)).makeBet();
    verify(pa3, times(1)).makeBet();

  }



/*Test to ensure that doubling down forces players to
double wager, take a single card and finish*/
  @Test
  public void testDoubleDownFunctionality() {
    DealerAction da = mock(DealerAction.class);
    PlayerAction pa = mock(PlayerAction.class);

    when(pa.getAction()).thenReturn(PlayerAction.ActionType.DOUBLE);

    SimpleBlackjack j = new SimpleBlackjack(da,new PlayerAction[]{pa});
    j.playRound();

    //create inOrder object passing any mocks that need to be verified in order
    InOrder inOrder = inOrder(pa, da);

    //ensure that they were only allowed to take one action
    inOrder.verify(pa, times(1)).getAction();
    //ensure that that action was to double down on their bet
    inOrder.verify(pa, times(1)).doubleDownBet();
  }
}
