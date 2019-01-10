/*
 * Copyright (C) 2007-2019 Crafter Software Corporation.
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

package org.craftercms.commons.entitlements.validator.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.craftercms.commons.entitlements.exception.EntitlementException;
import org.craftercms.commons.entitlements.validator.DbIntegrityValidator;

/**
 * Default Implementation of {@link DbIntegrityValidator}.
 *
 * @author joseross
 */
public class DefaultDbIntegrityValidatorImpl implements DbIntegrityValidator {

    /**
     * SQL statement to update the validation value.
     */
    private static final String UPDATE = "update _meta set integrity = ?";

    /**
     * SQL statement to get the validation value.
     */
    private static final String QUERY = "select integrity from _meta";

    /**
     * SQL statement to generate the validation value.
     */
    protected String query = "select crc32(group_concat(concat(table_name, column_name))) from "
        + "information_schema.columns where table_schema = 'crafter'";


    /**
     * {@inheritDoc}
     */
    @Override
    public void store(final Connection connection) throws SQLException {
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                long value = result.getLong(1);
                try(PreparedStatement update = connection.prepareStatement(UPDATE)) {
                    update.setLong(1, value);
                    update.executeUpdate();
                    connection.commit();
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate(final Connection connection) throws EntitlementException, SQLException {
        try(Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(QUERY);
            if (result.next()) {
                long stored = result.getLong(1);
                result = statement.executeQuery(query);
                if(result.next()) {
                    long actual = result.getLong(1);
                    if(stored != actual) {
                        throw new EntitlementException("Incompatible database detected, unable to start");
                    }
                }
            }
        }
    }

}
