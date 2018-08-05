package com.epam.autoparking;
/**
 * Admin LogIn credentials for AutoParking application.
 */
public class Credentials {

    /**
     *     username has been set as admin.
     */

    private static final String USERNAME = "admin";
    /**
     * password as pword and set as admin.
     */
    private static final String PWORD = "admin";
    /**
     * returns the username.
     * @return username
     */
    public String getUserName() {
        return USERNAME;
    }
    /**
     *retruns the password.
     * @return pword
     */
    public String getPassword() {
        return PWORD;
    }
}
