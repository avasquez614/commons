package org.craftercms.commons.security.exception;

public class PolicyFormatException extends PolicyException {

    public PolicyFormatException(String key, Object... args) {
        super(key, args);
    }

}
