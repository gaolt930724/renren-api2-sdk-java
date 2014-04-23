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

public class PageService {
	private RennExecutor executor;

    private AccessToken token;

    private ObjectMapper mapper;
	
    /**
     * @param executor
     * @param token
     * @param mapper
     */
    public PageService(RennExecutor executor, AccessToken token, ObjectMapper mapper) {
        super();
        this.executor = executor;
        this.token = token;
        this.mapper = mapper;
    }

    /**
     * 判断用户是否为某个公共主页的粉丝
     * @param pageId pageId
     * @param userId 目标用户Id,如果不传此参数则默认获取token用户是否为指定page的粉丝
     * @return Boolean 是否是公共主页粉丝
     * @throws   RennException 
     */
    public Boolean isfanPage (Integer  pageId, Integer  userId) throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        if (pageId != null) {
            textParams.put("pageId", RennParam.asString(pageId));
        }
        if (userId != null) {
            textParams.put("userId", RennParam.asString(userId));
        }
        Map<String, String> bodyParams = new HashMap<String, String>();
        Map<String, File[]> fileParams = new HashMap<String, File[]>();
        RennRequest request = new RennRequest("/v2/page/isfan", Method.GET, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (Boolean)mapper.mapCommon(response.getResponse().toString(), Boolean.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
    /**
     * 获取用户的所有公共主页信息。
     * @param userId 目标用户Id,如果不传此参数则默认获取token用户的page信息
     * @param pageSize 页大小1-500之间
     * @param pageNumber 页码大于等于1
     * @return PageInfo Page的信息
     * @throws   RennException 
     */
    public PageInfo [] listPageUser (Integer  userId, Integer  pageSize, Integer  pageNumber) throws RennException {
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
        RennRequest request = new RennRequest("/v2/page/user/list", Method.GET, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (PageInfo [])mapper.mapCommon(response.getResponse().toString(), PageInfo.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
    /**
     * 获取所有公共主页信息。
     * @param pageSize 页大小1-500之间
     * @param pageNumber 页码大于等于1
     * @return PageInfo Page的信息
     * @throws   RennException 
     */
    public PageInfo [] listPage (Integer  pageSize, Integer  pageNumber) throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        if (pageSize != null) {
            textParams.put("pageSize", RennParam.asString(pageSize));
        }
        if (pageNumber != null) {
            textParams.put("pageNumber", RennParam.asString(pageNumber));
        }
        Map<String, String> bodyParams = new HashMap<String, String>();
        Map<String, File[]> fileParams = new HashMap<String, File[]>();
        RennRequest request = new RennRequest("/v2/page/list", Method.GET, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (PageInfo [])mapper.mapCommon(response.getResponse().toString(), PageInfo.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
    /**
     * 获取指定id公共主页信息。
     * @param pageId pageId
     * @return PageInfo Page的信息
     * @throws   RennException 
     * PAGE_NOT_EXIST 公共主页不存在。 
     */
    public PageInfo getPage (Integer  pageId) throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        if (pageId != null) {
            textParams.put("pageId", RennParam.asString(pageId));
        }
        Map<String, String> bodyParams = new HashMap<String, String>();
        Map<String, File[]> fileParams = new HashMap<String, File[]>();
        RennRequest request = new RennRequest("/v2/page/get", Method.GET, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (PageInfo)mapper.mapCommon(response.getResponse().toString(), PageInfo.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
}
