package com.restassured.framework.models;

public class UserResponse {

	private String name;
	private String job;
	private String id;
	private String createdAt;
	private Meta _meta;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Meta get_meta() {
		return _meta;
	}

	public void set_meta(Meta _meta) {
		this._meta = _meta;
	}
}