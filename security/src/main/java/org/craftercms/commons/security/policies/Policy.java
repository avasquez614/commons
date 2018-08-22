package org.craftercms.commons.security.policies;

import java.util.List;

public interface Policy {

    String getVersion();

    String getName();

    String getDescription();

    List<Statement> getStatements();

    boolean evaluate(Resource resource, Action action, Effect effect);

}
