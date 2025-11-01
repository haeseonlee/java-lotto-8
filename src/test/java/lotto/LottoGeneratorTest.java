package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

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
}
