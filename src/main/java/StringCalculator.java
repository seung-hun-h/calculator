public class StringCalculator {
	private String separator = ",;";
	private final Calculator calculator;

	public StringCalculator() {
		this.calculator = new Calculator();
	}

	public int add(String input) {
		if (input.isBlank()) {
			return 0;
		}

		if (input.contains("//") && input.contains("\n")) {
			separator += input.substring(input.indexOf("//") + 2, input.indexOf("\n"));
			input = input.substring(input.indexOf("\n") + 1);
		}

		int result = 0;
		String[] split = input.split(String.format("[%s]", separator));
		for (String token : split) {
			if (isNegativeNumber(token)) {
				throw new RuntimeException();
			}

			if (isPositiveNumber(token)) {
				result = calculator.add(result, Integer.parseInt(token));
			}
		}

		return result;
	}

	private boolean isNegativeNumber(String token) {
		return token.matches("^-\\d+$");
	}

	private boolean isPositiveNumber(String token) {
		return token.matches("^\\d+$");
	}
}
