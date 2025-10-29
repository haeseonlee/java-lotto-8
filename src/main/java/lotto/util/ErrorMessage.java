package lotto.util;

public enum ErrorMessage {
    EMPTY_INPUT("입력값이 비어있습니다. 다시 입력해 주세요."),
    NOT_NUMERIC_INPUT("숫자 이외의 값은 입력할 수 없습니다. 다시 입력해 주세요."),
    NOT_SIX_COUNT("당첨 번호는 6자리로 이루어져야 합니다. 다시 입력해 주세요."),
    NOT_THOUSAND_UNIT("구입 금액은 1,000원 단위입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
