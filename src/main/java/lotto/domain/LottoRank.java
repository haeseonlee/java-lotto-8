package lotto.domain;

public enum LottoRank {
    MATCH3(3, false, 5_000, "3개 일치 (5,000원)"),
    MATCH4(4, false, 50_000, "4개 일치 (50,000원)"),
    MATCH5(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    MATCH5_BONUS(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MATCH6(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    NONE_MATCH(0, false, 0, "낙첨");

    private final int count;
    private final boolean bonusMatch;
    private final int prize;
    private final String message;

    LottoRank(int count, boolean bonusMatch, int prize, String message) {
        this.count = count;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
        this.message = message;
    }
}
