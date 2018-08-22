package org.craftercms.commons.security.policies;

import org.craftercms.commons.security.exception.PolicyFormatException;

public interface ResourceFormatter<T extends Resource> {

    T parse(String source) throws PolicyFormatException;

    String format(T resource) throws PolicyFormatException;

}
