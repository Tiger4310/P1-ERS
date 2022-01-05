package com.p1.ersbackend.service;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.MockedStatic;

import com.p1.DAO.UserDAO;
import com.p1.DTO.LoginDTO;
import com.p1.exception.BadParameterException;
import com.p1.exception.DatabaseException;
import com.p1.exception.LoginException;
import com.p1.model.User;
import com.p1.service.LoginService;
import com.p1.utils.SessionUtility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class LoginServiceTest  {

    private static UserDAO mockUserDAO;
    private static SessionFactory mockSessionFactory;

    private LoginService loginService;

    @BeforeClass
    public static void setUp() throws SQLException, DatabaseException, ClassNotFoundException, IOException {
        mockUserDAO = mock(UserDAO.class);
        mockSessionFactory = mock(SessionFactory.class);

        User returnedUser = new User("username","password", "firstName", "lastName", 0, "test@gmail.com", 1);

        when(mockUserDAO.getUserByUsernameAndPassword(eq(new LoginDTO("username", "password"))))
                .thenReturn(returnedUser);
    }

    @Before
    public void beforeTest() {
        loginService = new LoginService(mockUserDAO);
    }

    @Test
    public void test_login_happy() throws BadParameterException, LoginException, SQLException, DatabaseException, FileNotFoundException {
        try (MockedStatic<SessionUtility> mockedSessionUtil = mockStatic(SessionUtility.class)) {

            mockedSessionUtil.when(SessionUtility::getSessionFactory)
                    .thenReturn(mockSessionFactory);

            User actual = loginService.login(new LoginDTO("username", "password"));
            User expected = new User("lastName","username", "password", "firstName", 0, "test@gmail.com", 1);

            assertEquals(expected, actual);

        } catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Test
    public void test_login_blankUsername_blankPassword() throws ClassNotFoundException, IOException {
        try (MockedStatic<SessionUtility> mockedSessionUtil = mockStatic(SessionUtility.class)) {
            mockedSessionUtil.when(SessionUtility::getSessionFactory)
                    .thenReturn(mockSessionFactory);

            try {
                loginService.login(new LoginDTO("", ""));
                fail("BadParameterException was not thrown");
            } catch (BadParameterException | LoginException | SQLException | DatabaseException e) {
                assertEquals(e.getMessage(), "Cannot have a blank name and password");
            }
        }
    }

}