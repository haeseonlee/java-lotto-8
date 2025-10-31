package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    public Map<LottoRank, Integer> getLottoResult(WinningLotto winningLotto, List<Lotto> lottos) {
        Map<LottoRank, Integer> stats = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRank rank = LottoMatch.match(winningLotto, lotto);
            stats.put(rank, stats.getOrDefault(rank, 0) + 1);
        }
        return stats;
    }

    public int getTotalPrize(Map<LottoRank, Integer> stats) {
        int totalPrize = 0;
        for (Map.Entry<LottoRank, Integer> entry : stats.entrySet()) {
            LottoRank rank = entry.getKey();
            Integer count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }
        return totalPrize;
    }
}
