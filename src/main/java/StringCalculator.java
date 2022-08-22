import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	private static final String DEFAULT_SEPARATOR = ",;";

	public int add(String text) {
		if (isBlank(text)) {
			return 0;
		}

		return sum(toInts(split(text)));
	}

	private String[] split(String text) {
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (matcher.find()) {
			String customSeparator = matcher.group(1);
			return matcher.group(2).split(String.format("[%s]", customSeparator));
		}

		return text.split(String.format("[%s]", DEFAULT_SEPARATOR));
	}

	private int sum(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}

	private int[] toInts(String[] values) {
		int[] numbers = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			int number = toPositive(values[i]);
			numbers[i] = number;
		}

		return numbers;
	}

	private int toPositive(String values) {
		int number = Integer.parseInt(values);
		if (number < 0) {
			throw new RuntimeException();
		}
		return number;
	}

	private boolean isBlank(String input) {
		return input == null || input.isBlank();
	}
}
