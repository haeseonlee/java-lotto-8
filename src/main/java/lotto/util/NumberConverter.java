package lotto.util;

public class NumberConverter {

    private NumberConverter() {
    }

    public static int convert(String input) {
        try {
            validateNotEmptyInput(input);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_INPUT.getMessage());
        }
    }

    private static void validateNotEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }
}
