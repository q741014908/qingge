package com.qingge.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("resourceProperties")
public class ResourceProperties {
	
	@Value("${FTP_ADDRESS}")
	private String ftpAddress;
	@Value("${FTP_PORT}")
	private String ftpPort;
	@Value("${FTP_USERNAME}")
	private String ftpUsername;
	@Value("${FTP_PASSWORD}")
	private String ftpPassword;
	@Value("${FTP_BASE_PATH}")
	private String ftpBase_path;
	public String getFtpAddress() {
		return ftpAddress;
	}
	public void setFtpAddress(String ftpAddress) {
		this.ftpAddress = ftpAddress;
	}
	public String getFtpPort() {
		return ftpPort;
	}
	public void setFtpPort(String ftpPort) {
		this.ftpPort = ftpPort;
	}
	public String getFtpUsername() {
		return ftpUsername;
	}
	public void setFtpUsername(String ftpUsername) {
		this.ftpUsername = ftpUsername;
	}
	public String getFtpPassword() {
		return ftpPassword;
	}
	public void setFtpPassword(String ftpPassword) {
		this.ftpPassword = ftpPassword;
	}
	public String getFtpBase_path() {
		return ftpBase_path;
	}
	public void setFtpBase_path(String ftpBase_path) {
		this.ftpBase_path = ftpBase_path;
	}
}
