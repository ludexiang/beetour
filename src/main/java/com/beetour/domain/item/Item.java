package com.beetour.domain.item;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "item")
public class Item {
	@Id
	private String id;
	private String itemgpId; // 所属分类
	private Entity entity; // 项目
	private Picture pic;

	// Abstract
	private String destination; // 地点
	private String synopsis; // 概要

	// details
	private String entityContext; // 本次活动内容
	private String requirement;
	private String harvest;
	private ItemTime time;

	// Cost
	private Price price;
	private String costInfo; // 费用说明
	private String include;
	private String notInclude;

	// Other
	private Integer top; // 是否置顶，默认不置顶
	private String lineFeatures; // 线路特色
	private String bookingNotes; // 预订须知
	private String getAccommodation; // 住宿说明
	private Date created; // ISODate()

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemgpId() {
		return itemgpId;
	}

	public void setItemgpId(String itemgpId) {
		this.itemgpId = itemgpId;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Picture getPic() {
		return pic;
	}

	public void setPic(Picture pic) {
		this.pic = pic;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getEntityContext() {
		return entityContext;
	}

	public void setEntityContext(String entityContext) {
		this.entityContext = entityContext;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getHarvest() {
		return harvest;
	}

	public void setHarvest(String harvest) {
		this.harvest = harvest;
	}

	public ItemTime getTime() {
		return time;
	}

	public void setTime(ItemTime time) {
		this.time = time;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getCostInfo() {
		return costInfo;
	}

	public void setCostInfo(String costInfo) {
		this.costInfo = costInfo;
	}

	public String getInclude() {
		return include;
	}

	public void setInclude(String include) {
		this.include = include;
	}

	public String getNotInclude() {
		return notInclude;
	}

	public void setNotInclude(String notInclude) {
		this.notInclude = notInclude;
	}

	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}

	public String getLineFeatures() {
		return lineFeatures;
	}

	public void setLineFeatures(String lineFeatures) {
		this.lineFeatures = lineFeatures;
	}

	public String getBookingNotes() {
		return bookingNotes;
	}

	public void setBookingNotes(String bookingNotes) {
		this.bookingNotes = bookingNotes;
	}

	public String getGetAccommodation() {
		return getAccommodation;
	}

	public void setGetAccommodation(String getAccommodation) {
		this.getAccommodation = getAccommodation;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemgpId=" + itemgpId + ", entity=" + entity + ", pic=" + pic + ", destination="
				+ destination + ", synopsis=" + synopsis + ", entityContext=" + entityContext + ", requirement="
				+ requirement + ", harvest=" + harvest + ", time=" + time + ", price=" + price + ", costInfo="
				+ costInfo + ", include=" + include + ", notInclude=" + notInclude + ", top=" + top + ", lineFeatures="
				+ lineFeatures + ", bookingNotes=" + bookingNotes + ", getAccommodation=" + getAccommodation
				+ ", created=" + created + "]";
	}

}
