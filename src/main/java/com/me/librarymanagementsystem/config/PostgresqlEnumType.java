package com.me.librarymanagementsystem.config;

import lombok.SneakyThrows;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.EnumType;
import java.sql.PreparedStatement;
import java.sql.Types;

@SuppressWarnings("rawtypes")
public class PostgresqlEnumType extends EnumType {
    @Override
    @SneakyThrows
    public void nullSafeSet(PreparedStatement ps, Object obj, int index,
                            SharedSessionContractImplementor session) {
        if (obj == null) {
            ps.setNull(index, Types.OTHER);
        } else {
            ps.setObject(index, obj.toString(), Types.OTHER);
        }
    }
}
