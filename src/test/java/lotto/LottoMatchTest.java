package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import lotto.service.LottoMatch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTest {
    @DisplayName("당첨 번호와 로또 번호를 비교해 일치하는 당첨 등수를 반환한다")
    @Test
    void 일치하는_당첨_등수_반환() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(LottoMatch.match(winningLotto, lotto)).isEqualTo(LottoRank.MATCH6);
    }
}
