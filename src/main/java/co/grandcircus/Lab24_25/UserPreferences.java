package co.grandcircus.Lab24_25;

import java.io.Serializable;

public class UserPreferences implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String location;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public UserPreferences() {
	}
}
