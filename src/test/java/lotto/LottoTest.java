package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoGenerator;
import lotto.util.NumberConverter;
import lotto.util.TicketGenerator;
import lotto.util.WinningNumbersParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 ~ 45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 로또_번호_범위_벗어나면_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
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

    @DisplayName("구입 금액만큼 로또를 발권할 수 있는 티켓을 생성한다")
    @Test
    void 구입_금액만큼_로또_티켓_생성() {
        int purchaseAmount = 8000;
        assertThat(TicketGenerator.generate(purchaseAmount)).isEqualTo(8);
    }

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액_1000원_단위_아니면_예외_발생() {
        assertThatThrownBy(() -> TicketGenerator.generate(8800))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("티켓 장수만큼 로또가 생성되었는지 확인한다.")
    @Test
    void 티켓_장수만큼_로또_생성() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int ticketAmount = 8;

        List<Lotto> lottos = lottoGenerator.generate(ticketAmount);

        assertThat(lottos)
                .hasSize(ticketAmount)
                .allMatch(Objects::nonNull);
    }

    @DisplayName("당첨 번호 내에 보너스 번호와 같은 숫자가 존재하면 예외가 발생한다.")
    @Test
    void 당첨_번호와_보너스번호_겹치면_예외_발생() {

        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
