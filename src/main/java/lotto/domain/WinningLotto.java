package lotto.domain;

import lotto.util.ErrorMessage;

import java.util.List;

public class WinningLotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private void validateNumberRage(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
    }
}
