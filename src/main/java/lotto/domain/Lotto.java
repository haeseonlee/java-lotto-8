package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.ErrorMessage;
import lotto.util.LottoValidator;

import java.util.List;

import static lotto.util.LottoConstants.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto generate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER, REGULAR_SIZE);
        return new Lotto(randomNumbers);
    }

    public void validateLottoNumbers(List<Integer> numbers) {
        LottoValidator.validateCorrectSize(numbers, ErrorMessage.INVALID_LOTTO_NUMBER_COUNT);
        LottoValidator.validateCorrectRange(numbers, ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
        LottoValidator.validateDuplicateNumber(numbers, ErrorMessage.DUPLICATE_LOTTO_NUMBER);
    }


}
