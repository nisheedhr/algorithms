package com.datastructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.datastructures.UFConnectedFriends;

public class UFConnectedFriendsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	/**
	 * 1 2 
	 * 3 4
	 * 6 7
	 * 4 6
	 * 3 8
	 * 5 10
	 * 2 5
	 * 8 9
	 * 5 9
	 * 1 10
	 * @throws Exception
	 */
	public void testConnectFriends() throws Exception {
		UFConnectedFriends ufc = new UFConnectedFriends(10);
		assertEquals(false, ufc.connectFriends(1, 2));
		assertEquals(false, ufc.connectFriends(3, 4));
		assertEquals(false, ufc.connectFriends(6, 7));
		assertEquals(false, ufc.connectFriends(4, 6));
		assertEquals(false, ufc.connectFriends(3, 8));
		assertEquals(false, ufc.connectFriends(5, 10));
		assertEquals(false, ufc.connectFriends(2, 5));
		assertEquals(false, ufc.connectFriends(8, 9));
		assertEquals(true, ufc.connectFriends(5, 9));
		assertEquals(true, ufc.connectFriends(1, 2));
	}

	@Test
	public void testGetMax() throws Exception {
		int arr[] = { 1,2,6, 9};
		UFConnectedFriends ufc = new UFConnectedFriends(arr);
		ufc.connectFriends(1, 2);
		assertEquals(2, ufc.getMax(1));
		ufc.connectFriends(2, 6);
		assertEquals(6, ufc.getMax(1));
		ufc.connectFriends(6, 9);
		assertEquals(9, ufc.getMax(1));
	}

}
