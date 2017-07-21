package model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "settings")
@XmlType(propOrder = {"version", "dbDriver", "dbUrl", "dbUsername", "dbPassword"})
public class Settings {
	private String version;
	private String dbDriver;
	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	
	@XmlElement(name="version")
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	@XmlElement(name="db_driver")
	public String getDbDriver() {
		return dbDriver;
	}
	public void setDbDriver(String jdbcDriver) {
		this.dbDriver = jdbcDriver;
	}

	@XmlElement(name="db_url")
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	@XmlElement(name="db_username")
	public String getDbUsername() {
		return dbUsername;
	}
	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	@XmlElement(name="db_password")
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	
}
