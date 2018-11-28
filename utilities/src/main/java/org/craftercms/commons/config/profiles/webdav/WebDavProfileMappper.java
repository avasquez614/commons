/*
 * Copyright (C) 2007-2018 Crafter Software Corporation.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.craftercms.commons.config.profiles.webdav;

import org.apache.commons.configuration2.HierarchicalConfiguration;
import org.apache.commons.configuration2.tree.ImmutableNode;
import org.craftercms.commons.config.profiles.AbstractProfileConfigMapper;

/**
 * Configuration mapper for {@link WebDavProfile}s.
 *
 * @author joseross
 * @auhor avasquez
 */
public class WebDavProfileMappper extends AbstractProfileConfigMapper<WebDavProfile> {

    private static final String CONFIG_KEY_BASE_URL = "baseUrl";
    private static final String CONFIG_KEY_DELIVERY_URL = "deliveryBaseUrl";
    private static final String CONFIG_KEY_USERNAME = "username";
    private static final String CONFIG_KEY_PASSWORD = "password";

    @Override
    protected WebDavProfile mapProfile(HierarchicalConfiguration<ImmutableNode> profileConfig) {
        WebDavProfile profile = new WebDavProfile();
        profile.setBaseUrl(profileConfig.getString(CONFIG_KEY_BASE_URL));
        if(profileConfig.containsKey(CONFIG_KEY_DELIVERY_URL)) {
            profile.setDeliveryBaseUrl(profileConfig.getString(CONFIG_KEY_DELIVERY_URL));
        }
        profile.setUsername(profileConfig.getString(CONFIG_KEY_USERNAME));
        profile.setPassword(profileConfig.getString(CONFIG_KEY_PASSWORD));

        return profile;
    }

}
