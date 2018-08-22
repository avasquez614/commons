package org.craftercms.commons.security.policies;

import java.util.List;

public interface Statement {

    List<Resource> getResources();

    List<Action> getActions();

    Effect getEffect();

    boolean evaluate(Resource resource, Action action, Effect effect);

}
