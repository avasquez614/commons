package org.craftercms.commons.security.policies;

import org.craftercms.commons.security.exception.PolicyFormatException;

public interface ActionFormatter<T extends Action> {

    T parse(String source) throws PolicyFormatException;

    String format(T action) throws PolicyFormatException;

}
