package com.beetour.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "share")
public class Share {

	@Id
	private String id;
	private String postId;
	private String adress;
	private String userId;
	private String shareNum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShareNum() {
		return shareNum;
	}

	public void setShareNum(String shareNum) {
		this.shareNum = shareNum;
	}

}
