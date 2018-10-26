package com.hanma.elm.service;

import com.hanma.elm.config.BaseConfig;
import eleme.openapi.sdk.api.entity.message.OMessage;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.api.service.MessageService;

import java.util.ArrayList;
import java.util.List;

public class MessageServiceImp extends BaseConfig implements IMessageService {

    MessageService messageService = new MessageService(config, token);

    @Override
    public List<OMessage> getNonReachedOMessages(int appId) {
        List<OMessage> list = new ArrayList<>();
        try{
            list = messageService.getNonReachedOMessages(appId);

        } catch (ServiceException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<String> getNonReachedMessages(int appId) {
        return null;
    }
}
