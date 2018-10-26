package com.hanma.elm.service;



import eleme.openapi.sdk.api.entity.message.OMessage;

import java.util.List;

public interface IMessageService {
    public List<String> getNonReachedMessages(int appId);

    public List<OMessage> getNonReachedOMessages(int appId);
}
