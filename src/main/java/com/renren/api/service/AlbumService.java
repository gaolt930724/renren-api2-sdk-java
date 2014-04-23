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

public class AlbumService {
	private RennExecutor executor;

    private AccessToken token;

    private ObjectMapper mapper;
	
    /**
     * @param executor
     * @param token
     * @param mapper
     */
    public AlbumService(RennExecutor executor, AccessToken token, ObjectMapper mapper) {
        super();
        this.executor = executor;
        this.token = token;
        this.mapper = mapper;
    }

    /**
     * 获取某个用户的某个相册
     * @param albumId 相册的ID
     * @param ownerId 相册所有者的ID
     * @return Album 相册
     * @throws   RennException 
     * NO_RIGHT 您没有权限获取此相册。 
     * ALBUM_NOT_EXIST 相册不存在。 
     * SERVICE_BUSY 服务器繁忙，请稍后再试。 
     */
    public Album getAlbum (Long  albumId, Long  ownerId) throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        if (albumId != null) {
            textParams.put("albumId", RennParam.asString(albumId));
        }
        if (ownerId != null) {
            textParams.put("ownerId", RennParam.asString(ownerId));
        }
        Map<String, String> bodyParams = new HashMap<String, String>();
        Map<String, File[]> fileParams = new HashMap<String, File[]>();
        RennRequest request = new RennRequest("/v2/album/get", Method.GET, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (Album)mapper.mapCommon(response.getResponse().toString(), Album.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
    /**
     * 以分页的方式获取某个用户的相册列表
     * @param ownerId 相册所有者的ID
     * @param pageSize 页面大小。取值范围1-100，默认大小20
     * @param pageNumber 页码。取值大于零，默认值为1
     * @return Album 相册
     * @throws   RennException 
     * SERVICE_BUSY 服务器繁忙，请稍后再试。 
     * PAGE_SIZE_NOT_IN_RANGE 页面大小不在1-100范围内。 
     * PAGE_NUMBER_MUST_LARGER_0 页码必须大于0。 
     */
    public Album [] listAlbum (Long  ownerId, Integer  pageSize, Integer  pageNumber) throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        if (ownerId != null) {
            textParams.put("ownerId", RennParam.asString(ownerId));
        }
        if (pageSize != null) {
            textParams.put("pageSize", RennParam.asString(pageSize));
        }
        if (pageNumber != null) {
            textParams.put("pageNumber", RennParam.asString(pageNumber));
        }
        Map<String, String> bodyParams = new HashMap<String, String>();
        Map<String, File[]> fileParams = new HashMap<String, File[]>();
        RennRequest request = new RennRequest("/v2/album/list", Method.GET, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (Album [])mapper.mapCommon(response.getResponse().toString(), Album.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
    /**
     * 创建一个相册
     * @param location 相册拍摄的地点。不能超过60个字符。
     * @param description 相册的描述。不能超过200个字符。
     * @param name 相册的名字。不能超过30个字符
     * @param accessControl 相册的访问控制
     * @param password 相册的访问密码,1-16个字符
     * @return Album 相册
     * @throws   RennException 
     * ALBUM_ACCESS_ERROR 相册访问控制不正确。 
     * ALBUM_LOCATION_TOO_LONG 相册地点不能超过60个字符。 
     * ALBUM_PASSWORD_LENGTHTOO_LONG 相册密码不能超过16个字符。 
     * ALBUM_DESCRIPTION_TOO_LONG 相册描述不能超过200个字符。 
     * ALBUM_NAME_EMPTY 相册名称不能为空。 
     * PASSWORD_MUST_NOTNULL 创建密码相册，必须输入密码。 
     * ALBUM_INPUT_DENY 抱歉，某些信息是不能发布的哦：）谢谢您的谅解。 
     * SERVICE_BUSY 服务器繁忙，请稍后再试。 
     * ALBUM_NAME_TOO_LONG 相册名称不能超过30个字符。 
     */
    public Album putAlbum (String  location, String  description, String  name, AccessControl  accessControl, String  password) throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        if (location != null) {
	    textParams.put("location", location);
        }
        if (description != null) {
	    textParams.put("description", description);
        }
        if (name != null) {
	    textParams.put("name", name);
        }
        if (accessControl != null) {
            textParams.put("accessControl", RennParam.asString(accessControl));
        }
        if (password != null) {
	    textParams.put("password", password);
        }
        Map<String, String> bodyParams = new HashMap<String, String>();
        Map<String, File[]> fileParams = new HashMap<String, File[]>();
        RennRequest request = new RennRequest("/v2/album/put", Method.POST, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (Album)mapper.mapCommon(response.getResponse().toString(), Album.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
}
