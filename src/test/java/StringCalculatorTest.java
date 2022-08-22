import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
	@Test
	void calculate() {
	    // given
		StringCalculator calculator = new StringCalculator();

		// when
		int result = calculator.add("//*\n1,2;3*4;12");

		// then
		assertEquals(22, result);
	}

	@Test
	void calculateNegativeNumber() {
		// given
		StringCalculator calculator = new StringCalculator();

		// when & then
		assertThrows(RuntimeException.class, () -> calculator.add("//*\n1,2;-3*4;12"));
	}
}