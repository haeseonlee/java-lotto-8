package lotto.util;

public enum ErrorMessage {
    EMPTY_INPUT("입력값이 비어있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
