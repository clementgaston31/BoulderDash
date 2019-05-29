package model.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBProperties extends Properties{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String propertiesFileName = "model.properties";
	private String URL = "";
	private String login = "";
	private String password = "";

	public DBProperties() {

		InputStream inputStream;

		inputStream = this.getClass().getClassLoader().getResourceAsStream(DBProperties.propertiesFileName);

		if (inputStream != null) {
			try {
				this.load(inputStream);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			this.setURL(this.getProperty("url"));
			this.setLogin(this.getProperty("login"));
			this.setPassword(this.getProperty("password"));
		}
	}

	public String getURL() {
		return URL;
	}

	private void setURL(String URL) {
		this.URL = URL;
	}

	public String getLogin() {
		return login;
	}

	private void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}
}
