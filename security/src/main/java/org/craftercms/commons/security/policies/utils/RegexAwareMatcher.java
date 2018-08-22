package org.craftercms.commons.security.policies.utils;

import org.apache.commons.lang3.StringUtils;

public class RegexAwareMatcher implements StringMatcher {

    @Override
    public boolean match(String sourceStr, String targetStr) {
        return StringUtils.equals(sourceStr, targetStr) || sourceStr.matches(targetStr);
    }

}
