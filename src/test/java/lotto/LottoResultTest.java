package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import lotto.service.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("구매한 로또가 등수 별로 몇 개 당첨되었는지 저장한다.")
    @Test
    void 구매로또_등수별_당첨개수_저장() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 8, 9, 10)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 11, 12)), // 4등
                new Lotto(List.of(1, 2, 3, 4, 5, 8))); // 5등
        LottoResult lottoResult = new LottoResult();
        Map<LottoRank, Integer> result = lottoResult.getLottoResult(winningLotto, lottos);

        assertThat(result).containsKeys(LottoRank.MATCH3, LottoRank.MATCH4, LottoRank.MATCH5);
    }
}
