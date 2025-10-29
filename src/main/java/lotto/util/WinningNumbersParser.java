package lotto.util;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersParser {

    private static final String DELIMITER = ",";

    private WinningNumbersParser() {
    }

    public static List<Integer> parse(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }
}
