package org.example.repositoryDAO.DAOImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.JDBC.DBConnectionPool;
import org.example.entity.Address;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.IAddressDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AddressDAOImpl implements IAddressDAO {

    private static final String SQL_SELECT_ALL = "SELECT id_address, streetName, streetNumber FROM addresses";
    private static final String SQL_INSERT = "INSERT INTO addresses(id_address, streetName, streetNumber) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE addresses SET  streetName = ?, streetNumber = ? WHERE id_address = ?";
    private static final String SQL_DELETE = "DELETE FROM addresses WHERE id_address = ? ";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM addresses WHERE id_address = ? ";
    private static final Logger LOGGER = LogManager.getLogger(AddressDAOImpl.class);
    private Connection conn = DBConnectionPool.getInstance().getConnection();


    @Override
    public List<Address> list() {
        return null;
    }

    @Override
    public Address getById(Integer id) throws DAO_exception {
        return null;
    }

    @Override
    public void update(Address v) throws DAO_exception {

    }

    @Override
    public void insert(Address V) throws DAO_exception, SQLException {

    }

    @Override
    public void delete(Address id) throws DAO_exception {

    }
}
