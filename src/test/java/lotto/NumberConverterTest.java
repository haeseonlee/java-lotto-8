package lotto;

import lotto.util.NumberConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberConverterTest {

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

}
