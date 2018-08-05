package com.epam.autoparktest;



import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.epam.autoparking.Credentials;
/**
 *
 * @author Pavan_Mugathi
 *
 */
public class CredentialsTest {
    /**
     * test case to test the credentials.
     */
    @Test
    public void test1() {
        Credentials login = new Credentials();
        String name = login.getUserName();
        String pwd = login.getPassword();
        assertEquals("admin", name);
        assertEquals("admin", pwd);
    }


}
