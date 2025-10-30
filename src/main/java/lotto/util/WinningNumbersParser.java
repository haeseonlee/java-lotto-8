package lotto.util;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersParser {

    private static final String DELIMITER = ",";

    private WinningNumbersParser() {
    }

    public static List<Integer> parse(String input) {
        validateNotEmptyInput(input);
        List<Integer> winningNumbers = Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
        validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private static void validateNotEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        LottoValidator.validateCorrectSize(winningNumbers, ErrorMessage.NOT_SIX_COUNT);
        LottoValidator.validateCorrectRange(winningNumbers, ErrorMessage.INVALID_WINNING_NUMBER_RANGE);
        LottoValidator.validateDuplicateNumber(winningNumbers, ErrorMessage.DUPLICATE_WINNING_NUMBER);
    }

}
