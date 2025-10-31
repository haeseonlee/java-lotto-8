package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import lotto.service.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class LottoResultTest {

    private WinningLotto winningLotto;
    private List<Lotto> lottos;
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        lottos = List.of(new Lotto(List.of(1, 2, 3, 8, 9, 10)), // 5등
                new Lotto(List.of(1, 2, 3, 4, 11, 12)), // 4등
                new Lotto(List.of(1, 2, 3, 4, 5, 8))); // 3등
        lottoResult = new LottoResult();
    }

    @DisplayName("구매한 로또가 등수 별로 몇 개 당첨되었는지 저장한다.")
    @Test
    void 구매로또_등수별_당첨개수_저장() {
        Map<LottoRank, Integer> result = lottoResult.getLottoResult(winningLotto, lottos);

        assertThat(result).containsKeys(LottoRank.MATCH3, LottoRank.MATCH4, LottoRank.MATCH5);
    }

    @DisplayName("당첨된 로또의 총 상금을 구해 반환한다.")
    @Test
    void 당첨_로또_총_상금_반환() {
        Map<LottoRank, Integer> result = lottoResult.getLottoResult(winningLotto, lottos);

        int totalPrize = lottoResult.getTotalPrize(result);
        int expectedPrize = LottoRank.MATCH3.getPrize() + LottoRank.MATCH4.getPrize() + LottoRank.MATCH5.getPrize();

        assertThat(totalPrize).isEqualTo(expectedPrize);
    }

    @DisplayName("총 수익률을 구해 반환한다.")
    @Test
    void 총_수익률_반환() {
           }
}
