package model.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <h1>The Class DBProperties.</h1>
 * 
 * @author Clement GASTON
 * @version 0.1
 */
public class DBProperties extends Properties {

	/** Serial number of the class. */
	private static final long serialVersionUID = 1L;

	/** Name of the file with all the login DB information. */
	private static String propertiesFileName = "model.properties";

	/** The URL of the database. */
	private String URL = "";

	/** Login of the database. */
	private String login = "";

	/** Password of the database. */
	private String password = "";

	/**
	 * Loads and reads the propertiesFileName to get and set the URL, login and
	 * password used for the connection to the database.
	 */
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

	/**
	 * Gets the URL of the database.
	 * 
	 * @return URL
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * Sets the URL of the database.
	 * 
	 * @param URL
	 * 			The new URL.
	 */
	private void setURL(String URL) {
		this.URL = URL;
	}

	/**
	 * Gets the login of the database.
	 * 
	 * @return login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login of the database.
	 * 
	 * @param login
	 * 			The new login.
	 */
	private void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the password of the database.
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the database.
	 * 
	 * @param password
	 * 			The new password.
	 */
	private void setPassword(String password) {
		this.password = password;
	}
}
