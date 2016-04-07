package com.beetour.domain.item;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 项目分类
 * 
 * @author xanderlu
 *
 */
@Document(collection = "itemgp")
public class Itemgp {

	@Id
	private String id; // id
	private String catetoryId; // 关联mysql，忽略
	private String catetoryName; // 项目分类名称
	private Picture pic; // 项目分类图片
	private String introduction; // 项目介绍
	private Integer isDelete; // 默认0 不删除，1删除,
	private Integer isShow; // 0不展示 1展示,
	private Date created; // 创建时间

	private List<String> itemIds;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCatetoryId() {
		return catetoryId;
	}

	public void setCatetoryId(String catetoryId) {
		this.catetoryId = catetoryId;
	}

	public String getCatetoryName() {
		return catetoryName;
	}

	public void setCatetoryName(String catetoryName) {
		this.catetoryName = catetoryName;
	}

	public Picture getPic() {
		return pic;
	}

	public void setPic(Picture pic) {
		this.pic = pic;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public List<String> getItemIds() {
		return itemIds;
	}

	public void setItemIds(List<String> itemIds) {
		this.itemIds = itemIds;
	}

	@Override
	public String toString() {
		return "Itemgp [id=" + id + ", catetoryId=" + catetoryId + ", catetoryName=" + catetoryName + ", pic=" + pic
				+ ", introduction=" + introduction + ", isDelete=" + isDelete + ", isShow=" + isShow + ", created="
				+ created + ", itemIds=" + itemIds + "]";
	}

	
}
