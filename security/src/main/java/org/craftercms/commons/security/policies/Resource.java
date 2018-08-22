package org.craftercms.commons.security.policies;

public interface Resource {

    String getSystem();

    String getServiceNamespace();

    String getOrganization();

    String getProject();

    String getType();

    String getPath();

    boolean matches(Resource resource);

}
