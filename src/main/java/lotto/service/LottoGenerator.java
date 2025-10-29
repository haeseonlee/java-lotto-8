package lotto.service;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {

    public List<Lotto> generate(int ticketAmount) {
        return IntStream.range(0, ticketAmount)
                .mapToObj(number -> Lotto.generate())
                .toList();
    }
}
