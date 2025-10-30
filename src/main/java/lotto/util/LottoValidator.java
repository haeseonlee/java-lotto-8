package lotto.util;

import java.util.List;

import static lotto.util.LottoConstants.*;

public class LottoValidator {

   private LottoValidator() {
    }

    public static void validateCorrectSize(List<Integer> numbers, ErrorMessage errorMessage) {
        if (numbers.size() != REGULAR_SIZE) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public static void validateCorrectRange(List<Integer> numbers, ErrorMessage errorMessage) {
        numbers.stream()
                .filter(number -> number < MIN_RANGE_NUMBER || number > MAX_RANGE_NUMBER)
                .forEach(number -> {
                    throw new IllegalArgumentException(errorMessage.getMessage());
                });
    }

    public static void validateDuplicateNumber(List<Integer> numbers, ErrorMessage errorMessage) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }
}
