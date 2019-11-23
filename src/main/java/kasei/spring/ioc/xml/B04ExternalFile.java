package kasei.spring.ioc.xml;

public class B04ExternalFile {

	private String user;
	private String password;
	private String driverClass;
	private String jdbcUrl;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	
	@Override
	public String toString() {
		return "ExternalProperties{user=" + user + ", password=" + password + ", driverClass=" + driverClass
				+ ", jdbcUrl=" + jdbcUrl + "}";
	}
}
