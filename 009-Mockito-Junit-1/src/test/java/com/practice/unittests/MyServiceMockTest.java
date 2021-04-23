package com.practice.unittests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.practice.daos.MyDAO;
import com.practice.services.MyService;

@RunWith(MockitoJUnitRunner.class)
public class MyServiceMockTest {

	@Mock
	MyDAO dataServiceMock;
	
	@InjectMocks
	MyService businessImpl;
	
	@Test
	public void testFindTheGreatestFromAllData() {
		when(dataServiceMock.retreiveAllData()).thenReturn(new int[] {24,15,3});
		assertEquals(24, businessImpl.findTheGreatest());
	}
	
	@Test
	public void testFindTheGreatestFromAllDataForOneValue() {
		when(dataServiceMock.retreiveAllData()).thenReturn(new int[] {24});
		assertEquals(24, businessImpl.findTheGreatest());
	}
	
	@Test
	public void testFindTheGreatestFromAllDataForNoValues() {
		when(dataServiceMock.retreiveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatest());
	}
	
}
