package org.example.service;

import org.example.entity.BehaviourAttentionCall;

import java.util.List;

public interface IBehaviourAttentionCall {

    List<BehaviourAttentionCall> findAllBehaviourAttentionCalls();

    BehaviourAttentionCall getBehaviourAttentionCallById(Integer integer);

    void updateBehaviourAttentionCall(BehaviourAttentionCall attentionCall);

    void insertBehaviourAttentionCall(BehaviourAttentionCall attentionCall);

    void deleteBehaviourAttentionCallById(BehaviourAttentionCall integer);
}
