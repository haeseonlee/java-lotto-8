package lotto.util;

public class NumberConverter {

    private NumberConverter() {
    }

    public static int convert(String input) {
        return Integer.parseInt(input);
    }

    public static void validateNotEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }
}
