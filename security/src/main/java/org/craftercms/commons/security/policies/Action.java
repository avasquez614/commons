package org.craftercms.commons.security.policies;

public interface Action {

    String getSystem();

    String getServiceNamespace();

    String getResourceType();

    String getName();

    boolean matches(Action action);

}
