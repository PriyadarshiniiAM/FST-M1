package examples;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
	Calculator calc = new Calculator();

	@Test
	public void addTest() {
		// Perform the add function to get the ACTUAL result
		int result1 = calc.add(10, 20);
		int result2 = calc.add(15, 20);
		int result3 = calc.add(25, 5);

		// Add a assertion statement to verify against EXPECTED result
		assertAll(() -> assertEquals(30, result1), () -> assertEquals(35, result2), () -> assertEquals(30, result3));
	}

	@Test
	public void multiplyTest() {
		// Perform the add function to get the ACTUAL result
		int result = calc.multiply(10, 20);

		// Add a assertion statement to verify against EXPECTED result
		assertEquals(200, result);
	}

	@ParameterizedTest
	@ValueSource(ints = { 10, 20, 25, 100 })
	public void paramSqrtTest(int num1) {
		// perform the add function
		int result = calc.square(num1);
		assertEquals(num1 * num1, result);
	}

	@ParameterizedTest
	@CsvSource({ "10,90", "50,50", "80, 20" })
	public void paramaddTest(int num1, int num2) {
		// perform the add function
		int result1 = calc.add(num1, num2);
		assertEquals(100, result1);
	}

	@ParameterizedTest
	@CsvFileSource(files = "src/test/resources/input.csv", nullValues = { "N/A", "NA", "-" })
	public void AggregateTest(ArgumentsAccessor args) {
		System.out.println(args.getString(0) + "has only" + (args.getInteger(3) + 3) + "sick days remaining");
	}
}
