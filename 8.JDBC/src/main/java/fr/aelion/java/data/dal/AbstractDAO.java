package fr.aelion.java.data.dal;

import fr.aelion.java.data.source.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDAO<T> {

    protected Connection conn;

    public AbstractDAO() throws Exception {
        this.conn = DB.getConn();
    }

    public abstract List<T> findAll() throws SQLException;

    public abstract Optional<T> findById()  throws SQLException;

    //....
}
