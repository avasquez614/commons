package org.craftercms.commons.security.policies.impl;

import org.craftercms.commons.security.policies.Resource;
import org.craftercms.commons.security.policies.utils.StringMatcher;

public class DefaultResource implements Resource {

    protected StringMatcher stringMatcher;
    protected String system;
    protected String serviceNamespace;
    protected String organization;
    protected String project;
    protected String type;
    protected String path;

    public DefaultResource(StringMatcher stringMatcher, String system, String serviceNamespace, String organization,
                           String project, String type, String path) {
        this.stringMatcher = stringMatcher;
        this.system = system;
        this.serviceNamespace = serviceNamespace;
        this.organization = organization;
        this.project = project;
        this.type = type;
        this.path = path;
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
    public String getOrganization() {
        return organization;
    }

    @Override
    public String getProject() {
        return project;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public boolean matches(Resource resource) {
        return stringMatcher.match(resource.getSystem(), getSystem()) &&
               stringMatcher.match(resource.getServiceNamespace(), getServiceNamespace()) &&
               stringMatcher.match(resource.getOrganization(), getOrganization()) &&
               stringMatcher.match(resource.getProject(), getProject()) &&
               stringMatcher.match(resource.getType(), getType()) &&
               stringMatcher.match(resource.getPath(), getPath());
    }

}
