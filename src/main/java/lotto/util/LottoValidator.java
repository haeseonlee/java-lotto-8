package lotto.util;

import java.util.List;

import static lotto.util.LottoConstants.*;

public class LottoValidator {
    private LottoValidator() {
    }

    public void validateCorrectSize(List<Integer> numbers, ErrorMessage errorMessage) {
        if (numbers.size() != REGULAR_SIZE) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void validateCorrectRange(List<Integer> numbers, ErrorMessage errorMessage) {
        numbers.stream()
                .filter(number -> number < MIN_RANGE_NUMBER || number > MAX_RAGE_NUMBER)
                .forEach(number -> {
                    throw new IllegalArgumentException(errorMessage.getMessage());
                });
    }

    public void validateNotDuplicateNumber(List<Integer> numbers, ErrorMessage errorMessage) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

}
