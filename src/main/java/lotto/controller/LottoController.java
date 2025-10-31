package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import lotto.service.LottoGenerator;
import lotto.service.LottoResult;
import lotto.util.NumberConverter;
import lotto.util.TicketGenerator;
import lotto.util.WinningNumbersParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;
    private final LottoResult lottoResult;

    public LottoController(InputView inputView, OutputView outputView, LottoGenerator lottoGenerator, LottoResult lottoResult) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
        this.lottoResult = lottoResult;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        int ticketAmount = getTicketAmount(purchaseAmount);
        List<Lotto> lottos = lottoGenerator.generate(ticketAmount);

        outputView.printTicketAmount(ticketAmount);
        outputView.printAllLottos(lottos);

        WinningLotto winningLotto = getWinningLotto();

        Map<LottoRank, Integer> result = lottoResult.getLottoResult(winningLotto, lottos);
        outputView.printWinningStatistics(result);

        double profitRate = lottoResult.getProfitRate(result, purchaseAmount);
        outputView.printProfitRate(profitRate);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                String purchaseAmount = inputView.readPurchaseAmount();
                return NumberConverter.convert(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getTicketAmount(int purchaseAmount) {
        while (true) {
            try {
                return TicketGenerator.generate(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                purchaseAmount = NumberConverter.convert(inputView.readPurchaseAmount());
            }
        }
    }

    private WinningLotto getWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = WinningNumbersParser.parse(inputView.readWinningNumbers());
                int bonusNumber = NumberConverter.convert(inputView.readBonusNumbers());
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
