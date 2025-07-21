package org.gfs.glowcore.core.util.sql.core;

import java.sql.SQLException;
import java.util.Map;

@FunctionalInterface
public interface ResultSetMapper<T> {
    T map(ResultSet rs) throws SQLException;
}