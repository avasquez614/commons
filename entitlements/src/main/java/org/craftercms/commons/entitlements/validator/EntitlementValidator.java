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

package org.craftercms.commons.entitlements.validator;

import java.io.File;
import java.util.jar.JarFile;

import org.craftercms.commons.entitlements.exception.EntitlementException;
import org.craftercms.commons.entitlements.model.Module;
import org.craftercms.commons.entitlements.model.EntitlementType;
import org.craftercms.commons.monitoring.VersionMonitor;

/**
 * Defines the operations to perform entitlement validations.
 *
 * @author joseross
 */
public interface EntitlementValidator {

    /**
     * Checks that an entitlement is below the value indicated in the configuration file.
     * @param module module requesting the validation
     * @param entitlementType entitlement to be validated
     * @param currentValue current value provided by the module
     * @param newAmount amount of items to be created
     * @throws EntitlementException if the validation fails
     */
    default void validateEntitlement(Module module, EntitlementType entitlementType, int currentValue, int newAmount)
        throws EntitlementException {
        // Do nothing by default
    }

    /**
     * Provides the id of the current validator.
     * @return id of the validator
     */
    default long getId() {
        return -1;
    }

    /**
     * Provides the client id of the current validator.
     * @return if of the client
     */
    default long getClientId() {
        return -1;
    }

    /**
     * Provides the version of the current validator.
     * @return the version
     */
    default String getVersion() {
        return null;
    }

    /**
     * Provides a general description of the current validator.
     * @return validator description
     */
    String getDescription();

    /**
     * Provides the version of the containing JAR file.
     * @return the version
     */
    default String getPackageVersion() {
        try {
            VersionMonitor versionMonitor = VersionMonitor.getVersion(
                new JarFile(new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI()))
                    .getManifest());
            return versionMonitor.getPackageVersion();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Provides the build of the containing JAR file.
     * @return the build
     */
    default String getPackageBuild() {
        try {
            VersionMonitor versionMonitor = VersionMonitor.getVersion(
                new JarFile(new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI()))
                    .getManifest());
            return versionMonitor.getBuild();
        } catch (Exception e) {
            return null;
        }
    }

}
