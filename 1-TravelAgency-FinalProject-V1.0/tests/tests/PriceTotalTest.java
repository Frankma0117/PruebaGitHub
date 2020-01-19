package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import models.TravelAgency;

public class PriceTotalTest {
	private TravelAgency travelAgencyObj;
	
	@Before
	public void setUp() throws Exception {
		travelAgencyObj = new TravelAgency(5,5,5);
	}

	
	@Test
	public void testTotalPrice() {
		double price = travelAgencyObj.totalValueReservations();
		double expectative = 795000;
		assertEquals(expectative,price,0.1);
	}

}
