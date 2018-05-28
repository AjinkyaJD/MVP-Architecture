package com.ajinkyad.mvparchitecture.login;

import org.junit.Test;

import static org.junit.Assert.*;


public class LoginInteractorImplementorTest {

    LoginInteractorImplementor loginInteractorImplementor = new LoginInteractorImplementor();

    @Test
    public void testValidCredentials_PositiveCase() throws Exception {

        assertEquals(true, loginInteractorImplementor.validCredentials("test@test.com", "password"));

    }

    @Test
    public void testValidCredentials_NegativeCase() throws Exception {

        assertEquals(false, loginInteractorImplementor.validCredentials("aji", "pass"));

    }
}
