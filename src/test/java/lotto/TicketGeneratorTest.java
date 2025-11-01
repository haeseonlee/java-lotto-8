package lotto;

import lotto.util.TicketGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TicketGeneratorTest {

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
}
