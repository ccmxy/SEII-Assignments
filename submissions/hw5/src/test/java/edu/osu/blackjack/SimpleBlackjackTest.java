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
  public void dealerTipsEveryPlayer(){

    DealerAction da = mock(DealerAction.class);
    PlayerAction pa = mock(PlayerAction.class);
    PlayerAction pa2 = mock(PlayerAction.class);
    PlayerAction pa3 = mock(PlayerAction.class);
    CommonAction ca = mock(CommonAction.class);


    when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);
    when(pa2.getAction()).thenReturn(PlayerAction.ActionType.STAND);
    when(pa3.getAction()).thenReturn(PlayerAction.ActionType.STAND);

  //  when(da.dealCard(ca)).thenReturn()

    // InOrder inOrder = inOrder(pa,pa2,deal);  // have tried moving this above and below blackjack instantiation

    SimpleBlackjack j = new SimpleBlackjack(da,new PlayerAction[]{pa,pa2,pa3});
    j.playRound();

    InOrder inOrder = inOrder(pa,pa2,da);  //  **** ERROR ON THIS LINE ***
    // inOrder.verify(pa, times(1)).makeBet();

    // InOrder.verify(pa2, times(1)).makeBet();\\acceptCard
  }


}
