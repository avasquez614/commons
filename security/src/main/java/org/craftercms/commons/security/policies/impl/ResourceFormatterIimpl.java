package org.craftercms.commons.security.policies.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.craftercms.commons.security.exception.ResourceStringFormatException;
import org.craftercms.commons.security.policies.Resource;
import org.craftercms.commons.security.policies.ResourceFormatter;
import org.craftercms.commons.security.policies.utils.StringMatcher;

public class ResourceFormatterIimpl implements ResourceFormatter<Resource> {

    protected static final String DEFAULT_RESOURCE_STR_SEPARATOR = ":";
    protected static final String RESOURCE_STR_FORMAT = "crn:system:serviceNamespace:org:project:type:path";

    protected String resourceStrSeparator;
    protected StringMatcher stringMatcher;

    public ResourceFormatterIimpl() {
        this.resourceStrSeparator = DEFAULT_RESOURCE_STR_SEPARATOR;
    }

    @Override
    public Resource parse(String source) {
        String[] components = StringUtils.split(source, resourceStrSeparator);
        if (ArrayUtils.isNotEmpty(components) && components.length == 7) {
            return new DefaultResource(stringMatcher, components[1], components[2], components[3], components[4],
                                       components[5], components[6]);
        } else {
           throw new ResourceStringFormatException(source, RESOURCE_STR_FORMAT);
        }
    }

    @Override
    public String format(Resource resource) {
        StringBuilder sb = new StringBuilder();
        sb.append(resource.getSystem()).append(resourceStrSeparator);
        sb.append(resource.getServiceNamespace()).append(resourceStrSeparator);
        sb.append(resource.getOrganization()).append(resourceStrSeparator);
        sb.append(resource.getProject()).append(resourceStrSeparator);
        sb.append(resource.getType()).append(resourceStrSeparator);
        sb.append(resource.getPath());

        return sb.toString();
    }

}
