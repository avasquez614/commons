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
package org.craftercms.commons.file.stores;

/**
 * Represents the path of a remote file.
 *
 * @author avasquez
 */
public class RemotePath {

    private String storeType;
    private String path;

    public RemotePath(String storeType, String path) {
        this.storeType = storeType;
        this.path = path;
    }

    /**
     * Returns the remote store type (s3, box, etc).
     */
    public String getStoreType() {
        return storeType;
    }

    /**
     * Returns the path or ID of file in the remote store.
     */
    public String getPath() {
        return path;
    }

}
