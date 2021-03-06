/**
 * Autogenerated by renren-api2-generator 2014-04-23 18:03:22
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.renren.api.service;
import java.util.*;
/**
 *
 * 地点新鲜事
 */
public class LocationFeed {
	
	/**
	 * 用户ID
	 */
	private long userId;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 用户头像
	 */
	private String headUrl;
	/**
	 * 地点ID
	 */
	private String placeId;
	/**
	 * 回复数
	 */
	private long replyCount;
	/**
	 * 原始UGC的ID
	 */
	private long ugcId;
	/**
	 * 经度
	 */
	private double longitude;
	/**
	 * 纬度
	 */
	private double latitude;
	/**
	 * 地点名称
	 */
	private String placeName;
	/**
	 * 新鲜事类型
	 */
	private LocationFeedType locationFeedType;
	/**
	 * 新鲜事内容,用户未发送信息则为null
	 */
	private String content;
	/**
	 * 新鲜事照片，用户未添加照片则为null
	 */
	private LocationPhoto locationPhoto;
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getUserId() {
		return this.userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	public String getHeadUrl() {
		return this.headUrl;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getPlaceId() {
		return this.placeId;
	}
	public void setReplyCount(long replyCount) {
		this.replyCount = replyCount;
	}
	public long getReplyCount() {
		return this.replyCount;
	}
	public void setUgcId(long ugcId) {
		this.ugcId = ugcId;
	}
	public long getUgcId() {
		return this.ugcId;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLongitude() {
		return this.longitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLatitude() {
		return this.latitude;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceName() {
		return this.placeName;
	}
	public void setLocationFeedType(LocationFeedType locationFeedType) {
		this.locationFeedType = locationFeedType;
	}
	public LocationFeedType getLocationFeedType() {
		return this.locationFeedType;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return this.content;
	}
	public void setLocationPhoto(LocationPhoto locationPhoto) {
		this.locationPhoto = locationPhoto;
	}
	public LocationPhoto getLocationPhoto() {
		return this.locationPhoto;
	}
}
