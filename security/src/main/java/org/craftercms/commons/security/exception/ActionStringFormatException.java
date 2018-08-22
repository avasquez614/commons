package org.craftercms.commons.security.exception;

public class ActionStringFormatException extends PolicyFormatException {

    public static final String KEY = "security.policy.action.invalidStrFormat";

    public ActionStringFormatException(String str, String expectedFormat) {
        super(KEY, str, expectedFormat);
    }

}
