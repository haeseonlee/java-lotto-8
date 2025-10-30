package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;

public class LottoMatch {

    public static LottoRank match(WinningLotto winningLotto, Lotto lotto) {
        int matchCount = winningLotto.countMatchingNumbers(lotto);
        boolean bonusMatch = winningLotto.isBonusMatch(lotto);

        return LottoRank.getRank(matchCount, bonusMatch);
    }
}
