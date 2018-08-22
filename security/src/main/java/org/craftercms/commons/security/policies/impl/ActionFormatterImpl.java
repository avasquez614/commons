package org.craftercms.commons.security.policies.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.craftercms.commons.security.exception.ActionStringFormatException;
import org.craftercms.commons.security.policies.Action;
import org.craftercms.commons.security.policies.ActionFormatter;
import org.craftercms.commons.security.policies.utils.StringMatcher;

public class ActionFormatterImpl implements ActionFormatter<Action> {

    protected static final String DEFAULT_ACTION_STR_SEPARATOR = ":";
    protected static final String ACTION_STR_FORMAT = "system:serviceNamespace:resourceType:name";

    protected String actionStrSeparator;
    protected StringMatcher stringMatcher;

    public ActionFormatterImpl() {
        this.actionStrSeparator = DEFAULT_ACTION_STR_SEPARATOR;
    }

    @Override
    public Action parse(String source) {
        String[] components = StringUtils.split(source, actionStrSeparator);
        if (ArrayUtils.isNotEmpty(components) && components.length == 4) {
            return new DefaultAction(stringMatcher, components[0], components[1], components[2], components[3]);
        } else {
           throw new ActionStringFormatException(source, ACTION_STR_FORMAT);
        }
    }

    @Override
    public String format(Action action) {
        StringBuilder sb = new StringBuilder();
        sb.append(action.getSystem()).append(actionStrSeparator);
        sb.append(action.getServiceNamespace()).append(actionStrSeparator);
        sb.append(action.getResourceType()).append(actionStrSeparator);
        sb.append(action.getName());

        return sb.toString();
    }

}
