package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoGenerator;
import lotto.service.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoResult lottoResult = new LottoResult();

        LottoController controller = new LottoController(inputView, outputView, lottoGenerator, lottoResult);
        controller.run();
    }
}
