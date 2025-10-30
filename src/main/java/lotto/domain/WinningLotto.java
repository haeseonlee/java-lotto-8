package lotto.domain;

import lotto.util.ErrorMessage;
import lotto.util.LottoConstants;

import java.util.List;

import static lotto.util.LottoConstants.*;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateDuplicateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(winningNumber -> lotto.getNumbers().contains(winningNumber))
                .count();
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_RANGE_NUMBER || bonusNumber > MAX_RANGE_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
