package lotto;

import lotto.util.WinningNumbersParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberParserTest {

    @DisplayName("입력받은 당첨 번호를 숫자 리스트에 저장한다.")
    @Test
    void 당첨번호_리스트에_저장() {
        String winningNumbers = "1,2,3,4,5,6";
        assertThat(List.of(1, 2, 3, 4, 5, 6)).isEqualTo(WinningNumbersParser.parse(winningNumbers));
    }

    @DisplayName("당첨 번호가 비어있으면 예외가 발생한다")
    @Test
    void 당첨번호_비어있으면_예외_발생() {
        assertThatThrownBy(() -> WinningNumbersParser.parse(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6자리가 아닌 경우 예외가 발생한다")
    @Test
    void 당첨번호_6자리_아니면_예외_발생() {
        assertThatThrownBy(() -> WinningNumbersParser.parse("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
