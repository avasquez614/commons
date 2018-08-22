package org.craftercms.commons.security.policies.impl;

import org.craftercms.commons.security.policies.Action;
import org.craftercms.commons.security.policies.Effect;
import org.craftercms.commons.security.policies.Resource;
import org.craftercms.commons.security.policies.Statement;

import java.util.List;

public class DefaultStatement implements Statement {

    protected List<Resource> resources;
    protected List<Action> actions;
    protected Effect effect;

    public DefaultStatement(List<Resource> resources, List<Action> actions, Effect effect) {
        this.resources = resources;
        this.actions = actions;
        this.effect = effect;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public List<Action> getActions() {
        return actions;
    }

    public Effect getEffect() {
        return effect;
    }

    @Override
    public boolean evaluate(Resource resource, Action action, Effect effect) {
        return getResources().stream().anyMatch(r -> r.matches(resource)) &&
               getActions().stream().anyMatch(a -> a.matches(action)) &&
               getEffect().equals(effect);
    }

}
