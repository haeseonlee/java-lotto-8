package lotto.util;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersParser {

    private static final String DELIMITER = ",";

    private WinningNumbersParser() {
    }

    public static List<Integer> parse(String input) {
        validateNotEmptyInput(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public static void validateNotEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

}
