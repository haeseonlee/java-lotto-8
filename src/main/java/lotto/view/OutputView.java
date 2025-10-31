package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    public void printTicketAmount(int ticketAmount) {
        System.out.printf("%d개를 구매했습니다.", ticketAmount);
    }

    public void printAllLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
