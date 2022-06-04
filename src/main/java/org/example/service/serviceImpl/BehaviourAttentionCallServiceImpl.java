package org.example.service.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.BehaviourAttentionCall;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.MySqlDAOImpl.BehaviourAttentionCallDAOImpl;
import org.example.service.IBehaviourAttentionCall;

import java.util.List;

public class BehaviourAttentionCallServiceImpl implements IBehaviourAttentionCall {

    private static final Logger LOGGER = LogManager.getLogger(BehaviourAttentionCallServiceImpl.class);
    private static BehaviourAttentionCallDAOImpl attentionCallDAO = new BehaviourAttentionCallDAOImpl();

    @Override
    public List<BehaviourAttentionCall> findAllBehaviourAttentionCalls() {
        return null;
    }

    @Override
    public BehaviourAttentionCall getBehaviourAttentionCallById(Integer integer) {
      BehaviourAttentionCall attCall = null;
        try {
            attCall = attentionCallDAO.getById(integer);
        } catch (DAO_exception e) {
          LOGGER.error(e.getMessage());
        }
        return attCall;
    }

    @Override
    public void updateBehaviourAttentionCall(BehaviourAttentionCall attentionCall) {

    }

    @Override
    public void insertBehaviourAttentionCall(BehaviourAttentionCall attentionCall) {

    }

    @Override
    public void deleteBehaviourAttentionCallById(BehaviourAttentionCall integer) {

    }
}
