package org.example.repositoryDAO.MySqlDAOImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.JDBC.DBConnectionPool;
import org.example.entity.BehaviourAttentionCall;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.IBehaviourAttentionCallDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BehaviourAttentionCallDAOImpl implements IBehaviourAttentionCallDAO {

    private static final String SQL_SELECT_ALL = "SELECT id_behaviour_call, detailOfBehaviour, dateOfBehaviourCall, numberOfCall, isTutorAwareOf FROM behaviour_attention_calls";
    private static final String SQL_INSERT = "INSERT INTO behaviour_attention_calls(id_behaviour_call, detailOfBehaviour, dateOfBehaviourCall, numberOfCall, isTutorAwareOf) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE behaviour_attention_calls SET  detailOfBehaviour = ?, dateOfBehaviourCall = ?, numberOfCall = ?, isTutorAwareOf = ? WHERE id_behaviour_call = ?";
    private static final String SQL_DELETE = "DELETE FROM behaviour_attention_calls WHERE id_behaviour_call = ? ";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM behaviour_attention_calls WHERE id_behaviour_call = ? ";
    private static final Logger LOGGER = LogManager.getLogger(BehaviourAttentionCall.class);
    private Connection conn = DBConnectionPool.getInstance().getConnection();

    private BehaviourAttentionCall converInfo(ResultSet rs) throws DAO_exception {

        BehaviourAttentionCall behaviourAttentionCall = null;

        try {
            String detailOfBehaviour = rs.getString("detailOfBehaviour");
            Date dateOfBehaviourCall = rs.getDate("dateOfBehaviourCall");
            int numberOfCall = rs.getInt("numberOfCall");
            boolean isTutorAwareOf = rs.getBoolean("isTutorAwareOf");
            behaviourAttentionCall.setIdBehaviourCall(rs.getInt("id_behaviour_call"));
            behaviourAttentionCall = new BehaviourAttentionCall(detailOfBehaviour, dateOfBehaviourCall, numberOfCall, isTutorAwareOf);

        } catch (SQLException e) {
            throw new DAO_exception("The behaviourAttentionCall could not be created. ", e);
        }
        return behaviourAttentionCall;
    }

    @Override
    public List<BehaviourAttentionCall> list() {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BehaviourAttentionCall> attCall = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                attCall.add(converInfo(rs));
            }
            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
            //stmt.executeUpdate();
        } catch (SQLException | DAO_exception e) {
            LOGGER.debug(e.getMessage());
        } finally {
            try {
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
            DBConnectionPool.getInstance().freeConnection(conn);
        }
        return attCall;
    }

    @Override
    public BehaviourAttentionCall getById(Integer id) throws DAO_exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        BehaviourAttentionCall attentionCall = null;
        try {
            stmt = conn.prepareStatement(SQL_FIND_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String detailOfBehaviour = rs.getString("detailOfBehaviour");
                Date dateOfBehaviourCall = rs.getDate("dateOfBehaviourCall");
                int numberOfCall = rs.getInt("numberOfCall");
                boolean isTutorAwareOf = rs.getBoolean("isTutorAwareOf");
                attentionCall.setIdBehaviourCall(rs.getInt("id_behaviour_call"));
                attentionCall = new BehaviourAttentionCall(detailOfBehaviour, dateOfBehaviourCall, numberOfCall, isTutorAwareOf);
            } else {
                throw new DAO_exception("This register is not found ");
            }
            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
            // stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error en esta sentencia SQL");
            LOGGER.debug(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAO_exception("There is an error at closing rs", e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new DAO_exception("There is an error at closing stmt", e);
                }
                DBConnectionPool.getInstance().freeConnection(conn);
            }
        }
        return attentionCall;
    }

    @Override
    public void update(BehaviourAttentionCall v) throws DAO_exception {

    }

    @Override
    public void insert(BehaviourAttentionCall v) throws DAO_exception, SQLException {

    }

    @Override
    public void delete(BehaviourAttentionCall v) throws DAO_exception {

    }
}
