package Model;

public class Yetkili {
	
	private int id;
	String username,password,log,name;
	
	
	public Yetkili(int id, String username, String password, String log, String name) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.log = log;
		this.name = name;
	}
	public Yetkili() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
