package lotto.util;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersParser {

    private static final String DELIMITER = ",";
    private static final int REGULAR_LENGTH = 6;

    private WinningNumbersParser() {
    }

    public static List<Integer> parse(String input) {
        validateNotEmptyInput(input);
        validateCorrectLength(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateNotEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateCorrectLength(String input) {
        if (input.split(DELIMITER).length != REGULAR_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_COUNT.getMessage());
        }
    }

}
