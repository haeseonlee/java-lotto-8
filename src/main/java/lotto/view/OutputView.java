package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printTicketAmount(int ticketAmount) {
        System.out.printf("%d개를 구매했습니다.", ticketAmount);
    }

    public void printAllLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printWinningStatistics(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            Integer count = result.getOrDefault(rank, 0);
            System.out.println(rank.getMessage() + " - " + count + "개");
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
