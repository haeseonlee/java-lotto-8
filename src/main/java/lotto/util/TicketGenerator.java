package lotto.util;

public class TicketGenerator {

    private static final int AMOUNT_UNIT = 1000;

    private TicketGenerator() {
    }

    public static int generate(int purchaseAmount) {
        validateThousandAmountUnit(purchaseAmount);
        return purchaseAmount / AMOUNT_UNIT;
    }

    private static void validateThousandAmountUnit(int purchaseAmount) {
        if (purchaseAmount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND_UNIT.getMessage());
        }
    }
}
