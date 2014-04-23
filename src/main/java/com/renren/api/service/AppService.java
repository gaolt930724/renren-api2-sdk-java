/**
 * Autogenerated by renren-api2-generator 2014-04-16 15:13:50
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.renren.api.service;

import java.io.File;
import java.util.*;

import com.renren.api.AccessToken;
import com.renren.api.ObjectMappingException;
import com.renren.api.RennException;
import com.renren.api.RennExecutor;
import com.renren.api.RennParam;
import com.renren.api.RennRequest;
import com.renren.api.RennRequest.Method;
import com.renren.api.RennResponse;
import com.renren.api.mapper.JsonMappingException;
import com.renren.api.mapper.ObjectMapper;

public class AppService {
	private RennExecutor executor;

    private AccessToken token;

    private ObjectMapper mapper;
	
    /**
     * @param executor
     * @param token
     * @param mapper
     */
    public AppService(RennExecutor executor, AccessToken token, ObjectMapper mapper) {
        super();
        this.executor = executor;
        this.token = token;
        this.mapper = mapper;
    }

    /**
     * 获取某个应用的信息，部分信息取自缓存，不能立即生效
     * @return App App
     * @throws   RennException 
     * SERVICE_BUSY 服务器繁忙，请稍后再试。 
     */
    public App getApp () throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        Map<String, String> bodyParams = new HashMap<String, String>();
        Map<String, File[]> fileParams = new HashMap<String, File[]>();
        RennRequest request = new RennRequest("/v2/app/get", Method.GET, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (App)mapper.mapCommon(response.getResponse().toString(), App.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
}
