/**
 * Autogenerated by renren-api2-generator 2013-11-21 17:47:04
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

public class FriendService {
	private RennExecutor executor;

    private AccessToken token;

    private ObjectMapper mapper;
	
    /**
     * @param executor
     * @param token
     * @param mapper
     */
    public FriendService(RennExecutor executor, AccessToken token, ObjectMapper mapper) {
        super();
        this.executor = executor;
        this.token = token;
        this.mapper = mapper;
    }

    /**
     * 获取某个用户的好友ID列表
     * @param userId 用户ID。该字段默认为当前用户
     * @param pageSize 页面大小。默认大小500。
     * @param pageNumber 页码。取值大于零，默认值为1
     * @return Integer [] 好友ID列表
     * @throws   RennException 
     * SERVICE_UNAVAILABLE 服务端临时不可用 
     * PAGESIZE_MUST_LARGER_0 页面大小必须大于0。 
     * PAGE_NUMBER_MUST_LARGER_0 页码必须大于0。 
     */
    public Integer [] listFriend (Long  userId, Integer  pageSize, Integer  pageNumber) throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        if (userId != null) {
            textParams.put("userId", RennParam.asString(userId));
        }
        if (pageSize != null) {
            textParams.put("pageSize", RennParam.asString(pageSize));
        }
        if (pageNumber != null) {
            textParams.put("pageNumber", RennParam.asString(pageNumber));
        }
        Map<String, String> bodyParams = new HashMap<String, String>();
        Map<String, File[]> fileParams = new HashMap<String, File[]>();
        RennRequest request = new RennRequest("/v2/friend/list", Method.GET, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (Integer [])mapper.mapCommon(response.getResponse().toString(), Integer.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
}
