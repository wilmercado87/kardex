/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.web.rs.response;

import com.kardex.ejb.vo.MessageVo;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ResponseGeneric implements Serializable {

    private Object objectVo;
    private List<?> objectsVo;
    private MessageVo messageVo;

    public ResponseGeneric() {

    }

    public Object getObjectVo() {
        return objectVo;
    }

    public void setObjectVo(Object objectVo) {
        this.objectVo = objectVo;
    }

    public List<?> getObjectsVo() {
        return objectsVo;
    }

    public void setObjectsVo(List<?> objectsVo) {
        this.objectsVo = objectsVo;
    }

    public MessageVo getMessageVo() {
        return messageVo;
    }

    public void setMessageVo(MessageVo messageVo) {
        this.messageVo = messageVo;
    }

}
