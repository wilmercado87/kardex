/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.generic;

import com.kardex.ejb.utilities.OrikaMapper;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;

/**
 *
 * @author ADMIN
 */
@Singleton
@Startup
public class BaseEJB {
    
    protected MapperFactory mapper;

    @PostConstruct
    public void init() {
        System.out.println("SingletonBean BaseEJB started");
        mapper = OrikaMapper.getInstance().getMapperFactory();
    }
    
    public Object convertEntityToVo(Class entity, Class vo, Object entityMapping){
        BoundMapperFacade mFacade = mapper.getMapperFacade(entity, vo);
        return mFacade.map(entityMapping);
    }
    
    public Object convertVoToEntity(Class vo, Class entity, Object voMapping){
        BoundMapperFacade mFacade = mapper.getMapperFacade(vo, entity);
        return mFacade.map(voMapping);
    }
}
