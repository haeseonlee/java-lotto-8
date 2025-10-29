package lotto;

import lotto.util.NumberConverter;
import lotto.util.WinningNumbersParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 입력값을 숫자로 변환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"8000", "7"})
    void 문자열_입력값을_숫자로_변환한다(String text) {
        int result = NumberConverter.convert(text);
        assertThat(result).isEqualTo(Integer.parseInt(text));
    }

    @DisplayName("구입 금액이 비어있으면 예외가 발생한다.")
    @Test
    void 구입_금액이_비어있으면_예외_발생() {
        assertThatThrownBy(() -> NumberConverter.convert(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 입력값_숫자_아니면_예외_발생() {
        assertThatThrownBy(() -> NumberConverter.convert("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 당첨 번호를 숫자 리스트에 저장한다.")
    @Test
    void 당첨번호_리스트에_저장() {
        String winningNumbers = "1,2,3,4,5,6";
        assertThat(List.of(1, 2, 3, 4, 5, 6)).isEqualTo(WinningNumbersParser.parse(winningNumbers));
    }
}
