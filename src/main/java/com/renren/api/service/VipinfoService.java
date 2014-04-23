/**
 * Autogenerated by renren-api2-generator 2013-11-21 17:47:03
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

public class VipinfoService {
	private RennExecutor executor;

    private AccessToken token;

    private ObjectMapper mapper;
	
    /**
     * @param executor
     * @param token
     * @param mapper
     */
    public VipinfoService(RennExecutor executor, AccessToken token, ObjectMapper mapper) {
        super();
        this.executor = executor;
        this.token = token;
        this.mapper = mapper;
    }

    /**
     * 获取某个用户的VIP信息
     * @param userId 被获取VIP信息的用户ID
     * @return VIPInfo VIP信息
     * @throws   RennException 
     */
    public VIPInfo getVipinfo (Long  userId) throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        if (userId != null) {
            textParams.put("userId", RennParam.asString(userId));
        }
        Map<String, String> bodyParams = new HashMap<String, String>();
        Map<String, File[]> fileParams = new HashMap<String, File[]>();
        RennRequest request = new RennRequest("/v2/vipinfo/get", Method.GET, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (VIPInfo)mapper.mapCommon(response.getResponse().toString(), VIPInfo.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
}
