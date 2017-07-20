package model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "settings")
@XmlType(propOrder = {"version"})
public class Settings {
	private String version;

	public Settings() {
	}
	
	
	@XmlElement(name="version")
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
}
