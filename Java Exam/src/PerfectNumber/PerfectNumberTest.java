package PerfectNumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PerfectNumberTest {

	@Test
	public static void isPerfectNumberTest() {
	
		boolean result = PerfectNumbers.isPerfectNumber(6);
		assertEquals(true, result);
	}

}
