package com.laboon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class GameTest {

// Typing "N", the player should go north.
// Doubling the objects: Player and House,
// verifying the moveNorth method on the mock object House should be called once.
// The result from the method doSomething("N") should equal 0.
	
	@Test
	public void testMoveNorth() {
		Player p = mock(Player.class);
		House h = mock(House.class);
	    Game g = new Game(p, h);
	    int result = g.doSomething("N");
	    
	    verify(h,times(1)).moveNorth();
	    assertEquals(result,0);
	}
	
// Typing "l" or "L", the player should go look for items in the current room.
// Doubling the objects: Player and House,
// verifying the look method on the mock object House should be called once.
// The result from the method doSomething("l") should equal 0.
	
	@Test
	public void testMovetoLook() {
		Player mp = mock(Player.class);
		House mh = mock(House.class);
	    Game ng = new Game(mp, mh);
	    int result = ng.doSomething("l");

	    verify(mh,times(1)).look(mp,null);
	    assertEquals(result,0);
	}

	
// Typing "D" or "d", the player should go drink.
// Doubling the objects: Player and House,
// Stubbing the method drink and assuming it always returns boolean value true.
// verifying the drink method on the mock object Player should be called once.	
// the result from the method doSomething("D") should equal 1.
	
	@Test
	public void testMovetoDrink() {
		Player dp = mock(Player.class);
		House dh = mock(House.class);
	    Game dg = new Game(dp, dh);
	    
	    when(dp.drink()).thenReturn(true);
	 	    
	    int result = dg.doSomething("D");

	    verify(dp,times(1)).drink();
	    assertEquals(result,1);
	}

	
// Typing commands out of the instruction list, 
// message "what?" should be printed out.
// The result from the method doSomething("a") should equal 0.	
		
	@Test
	public void testElseComm() {
		Player ep = mock(Player.class);
		House eh = mock(House.class);
	    Game eg = new Game(ep, eh);
	    
	    int result = eg.doSomething("a");

	    assertEquals(result,0);
	}
	
	
// This tests that the method run will return 0 when the player wins.
// Doubling the objects: Player and House,
// Stubbing the method drink and assuming it always returns boolean value true.	
// The result from the method run should equal 0.
	
	@Test
	public void testRunWin() {
		Player wp = mock(Player.class);
		House wh = mock(House.class);
	    Game wg = new Game(wp, wh);
	    
	    when(wp.drink()).thenReturn(true);
	    
	    int result = wg.run();
	 
	    assertEquals(result,0);
	}
	
// This tests that the method run will return 1 when the player loses.
// Doubling the objects: Player and House,
// Stubbing the method drink and assuming it always returns boolean value false.	
// The result from the method run should equal 1.
	
	@Test
	public void testRunLose() {
		Player lp = mock(Player.class);
		House lh = mock(House.class);
	    Game lg = new Game(lp, lh);
	    
	    when(lp.drink()).thenReturn(false);
	    
	    int result = lg.run();
	 
	    assertEquals(result,1);
	}
	
}
