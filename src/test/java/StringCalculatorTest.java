import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
	@Test
	void calculate() {
	    // given
		StringCalculator calculator = new StringCalculator();

		// when
		int result = calculator.add("//*\n3*4");

		// then
		assertEquals(7, result);
	}

	@Test
	void calculateNegativeNumber() {
		// given
		StringCalculator calculator = new StringCalculator();

		// when & then
		assertThrows(RuntimeException.class, () -> calculator.add("//*\n-3*4"));
	}
}