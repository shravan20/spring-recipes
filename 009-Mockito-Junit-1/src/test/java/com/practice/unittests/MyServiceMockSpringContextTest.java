package com.practice.unittests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.practice.daos.MyDAO;
import com.practice.services.MyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyServiceMockSpringContextTest {

	@MockBean
	MyDAO dataServiceMock;
	
	@Autowired	
	MyService bussinessImpl;
	
	@Test
	public void TestFindTheGreatestFromAllTheData() {
		when(dataServiceMock.retreiveAllData()).thenReturn(new int[] {24,15,3});
		assertEquals(24, bussinessImpl.findTheGreatest());
	}
	
	@Test
	public void TestFindTheGreatestFromAllTheDataForOneValue() {
		when(dataServiceMock.retreiveAllData()).thenReturn(new int[] {24});
		assertEquals(24, bussinessImpl.findTheGreatest());
	}
	
	@Test
	public void TestFindTheGreatestFromAllTheDataForNoValue() {
		when(dataServiceMock.retreiveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, bussinessImpl.findTheGreatest());
	}
}