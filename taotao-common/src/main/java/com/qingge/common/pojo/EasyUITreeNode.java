package com.qingge.common.pojo;
/**
 * EasyUI树形空间节点
 * <p>Title: EasyUITreeNode</p>
 * <p>Description: </p>
 * @author	走走停停
 * @date	2017年3月12日下午12:26:15
 * @version 1.0
 */
public class EasyUITreeNode {
	
	private Long id;
	
	private String text;
	
	private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "EasyUITreeNode [id=" + id + ", text=" + text + ", state="
				+ state + "]";
	}
	
	
}
