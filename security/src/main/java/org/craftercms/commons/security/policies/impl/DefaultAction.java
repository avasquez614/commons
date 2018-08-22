package org.craftercms.commons.security.policies.impl;

import org.craftercms.commons.security.policies.Action;
import org.craftercms.commons.security.policies.utils.StringMatcher;

public class DefaultAction implements Action {

    protected StringMatcher stringMatcher;
    protected String system;
    protected String serviceNamespace;
    protected String resourceType;
    protected String name;

    public DefaultAction(StringMatcher stringMatcher, String system, String serviceNamespace, String resourceType,
                         String name) {
        this.stringMatcher = stringMatcher;
        this.system = system;
        this.serviceNamespace = serviceNamespace;
        this.resourceType = resourceType;
        this.name = name;
    }

    @Override
    public String getSystem() {
        return system;
    }

    @Override
    public String getServiceNamespace() {
        return serviceNamespace;
    }

    @Override
    public String getResourceType() {
        return resourceType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean matches(Action action) {
        return stringMatcher.match(action.getSystem(), getSystem()) &&
               stringMatcher.match(action.getServiceNamespace(), getServiceNamespace()) &&
               stringMatcher.match(action.getResourceType(), getResourceType()) &&
               stringMatcher.match(action.getName(), getName());
    }

}
