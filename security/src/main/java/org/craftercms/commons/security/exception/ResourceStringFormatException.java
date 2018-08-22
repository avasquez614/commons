package org.craftercms.commons.security.exception;

public class ResourceStringFormatException extends PolicyFormatException {

    public static final String KEY = "security.policy.resource.invalidStrFormat";

    public ResourceStringFormatException(String str, String expectedFormat) {
        super(KEY, str, expectedFormat);
    }

}
