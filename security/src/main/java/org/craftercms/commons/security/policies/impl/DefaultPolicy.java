package org.craftercms.commons.security.policies.impl;

import org.craftercms.commons.security.policies.*;

import java.util.List;

public class DefaultPolicy implements Policy {

    protected String version;
    protected String name;
    protected String description;
    protected List<Statement> statements;

    public DefaultPolicy(String version, String name, String description, List<Statement> statements) {
        this.version = version;
        this.name = name;
        this.description = description;
        this.statements = statements;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public boolean evaluate(Resource resource, Action action, Effect effect) {
        return getStatements().stream().anyMatch(s -> s.evaluate(resource, action, effect));
    }

}
