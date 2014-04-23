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

public class LocationService {
	private RennExecutor executor;

    private AccessToken token;

    private ObjectMapper mapper;
	
    /**
     * @param executor
     * @param token
     * @param mapper
     */
    public LocationService(RennExecutor executor, AccessToken token, ObjectMapper mapper) {
        super();
        this.executor = executor;
        this.token = token;
        this.mapper = mapper;
    }

    /**
     * 通过经纬度获取新鲜事。
     * @param pageSize 页面大小。取值范围1-100，默认大小20
     * @param pageNumber 页码。取值大于零，默认值为1
     * @param locationFeedType 新鲜事类型。
     * @param radius 半径,500-2000米。
     * @param longitude 经度。
     * @param latitude 纬度。
     * @return LocationFeed 地点新鲜事
     * @throws   RennException 
     * SERVICE_UNAVAILABLE 服务端临时不可用 
     * LATITUDE_NOT_IN_RANGE 纬度不在-90-90范围内。 
     * LONGITUDE_NOT_IN_RANGE 经度不在-180-180范围内。 
     * RADIUS_NOT_IN_RANGE 半径不在500-2000米范围内。 
     * PAGESIZE_NOT_IN_RANGE 页面大小不在1-100范围内。 
     * FEED_TYPE_ILLEGAL 地点新鲜事类型不合法。 
     * PAGE_NUMBER_MUST_LARGER_0 页码必须大于0。 
     */
    public LocationFeed [] listLocationFeed (Integer  pageSize, Integer  pageNumber, LocationFeedType  locationFeedType, Integer  radius, Double  longitude, Double  latitude) throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        if (pageSize != null) {
            textParams.put("pageSize", RennParam.asString(pageSize));
        }
        if (pageNumber != null) {
            textParams.put("pageNumber", RennParam.asString(pageNumber));
        }
        if (locationFeedType != null) {
            textParams.put("locationFeedType", RennParam.asString(locationFeedType));
        }
        if (radius != null) {
            textParams.put("radius", RennParam.asString(radius));
        }
        if (longitude != null) {
            textParams.put("longitude", RennParam.asString(longitude));
        }
        if (latitude != null) {
            textParams.put("latitude", RennParam.asString(latitude));
        }
        Map<String, String> bodyParams = new HashMap<String, String>();
        Map<String, File[]> fileParams = new HashMap<String, File[]>();
        RennRequest request = new RennRequest("/v2/location/feed/list", Method.GET, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (LocationFeed [])mapper.mapCommon(response.getResponse().toString(), LocationFeed.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
    /**
     * 根据经纬度定位地点。
     * @param deflection 是否偏转。
     * @param longitude 经度。
     * @param latitude 纬度。
     * @return Location 定位的地点。
     * @throws   RennException 
     * SERVICE_UNAVAILABLE 服务端临时不可用 
     * LATITUDE_NOT_IN_RANGE 纬度不在-90-90范围内。 
     * LONGITUDE_NOT_IN_RANGE 经度不在-180-180范围内。 
     */
    public Location getLocation (Boolean  deflection, Double  longitude, Double  latitude) throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        if (deflection != null) {
            textParams.put("deflection", RennParam.asString(deflection));
        }
        if (longitude != null) {
            textParams.put("longitude", RennParam.asString(longitude));
        }
        if (latitude != null) {
            textParams.put("latitude", RennParam.asString(latitude));
        }
        Map<String, String> bodyParams = new HashMap<String, String>();
        Map<String, File[]> fileParams = new HashMap<String, File[]>();
        RennRequest request = new RennRequest("/v2/location/get", Method.GET, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (Location)mapper.mapCommon(response.getResponse().toString(), Location.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
}
