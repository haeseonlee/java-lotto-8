package lotto.util;

public class TicketGenerator {

    private static final int AMOUNT_UNIT = 1000;

    private TicketGenerator() {
    }

    public static int generate(int purchaseAmount) {
        return purchaseAmount / AMOUNT_UNIT;
    }
}
