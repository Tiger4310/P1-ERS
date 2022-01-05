package com.p1.ersbackend.service;

import org.hibernate.SessionFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.p1.DAO.ReimbursementDAO;
import com.p1.exception.DatabaseException;
import com.p1.model.Reimbursement;
import com.p1.model.User;
import com.p1.service.ReimbursementService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

class ReimbursementServiceTest {


    // Fake repository dependency(mocked with Mockito)
    private static ReimbursementDAO mockReimbursementDAO;
    // The system under test, our reimbursementService instance;
    private ReimbursementService reimbursementService;

    @BeforeClass
    public static void setupAll() throws DatabaseException {
        mockReimbursementDAO = mock(ReimbursementDAO.class);
        mock(SessionFactory.class);

        new User();
        List<Reimbursement> reimList = new ArrayList<>();

        Reimbursement testReim1 = new Reimbursement(8000, 569.00, "room fees",
                1002, 2);
        Reimbursement testReim2 = new Reimbursement(8001, 350.00, "misc.",
                1002, 4);

        reimList.add(testReim1);
        reimList.add(testReim2);

//        when(mockReimbursementDAO.getAllReimbursements(eq(new User(user)))
//                .thenReturn(reimList));


        System.out.println("Should Print Before All Tests");
    }

    @Before
    public void beforeTest() {
        reimbursementService = new ReimbursementService((mockReimbursementDAO));
    }


    @Test
    public void getAllReimbursements() throws SQLException, DatabaseException {

//        try (MockedStatic<SessionUtility> mockedSessionUtil = mockStatic(SessionUtility.class) {
//            mockedSessionUtil.when(SessionUtility::getSessionFactory).thenReturn(mockSessionFactory);
//
//            Assertions.assertFalse(reimbursementService.getAllReimbursements().isEmpty());
//            Assertions.assertEquals(1, reimbursementService.getAllReimbursements().size());
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//

    }

    @Test
    void getReimbursementByUserId() {
    }

    @Test
    public void itShouldAddReimbursement() throws SQLException, DatabaseException {

        try {

            Reimbursement reimbursement = new Reimbursement();
            reimbursement = new Reimbursement(6269, 569.00, "room fees", 1002, 2);

            reimbursementService.addReimbursement(reimbursement);
            assertFalse(ReimbursementDAO.getAllReimbursements().isEmpty());
            assertEquals(1, ReimbursementDAO.getAllReimbursements().size());
            assertTrue(reimbursementService.getAllReimbursements().stream()
                    .anyMatch(reim -> Objects.equals(reim.getId(), 6269) &&
                            Objects.equals(reim.getAmount(), 569.00) &&
                            Objects.equals(reim.getDescription(), ("room fees")) &&
                            Objects.equals(reim.getAuthor(), 1002) &&
                            Objects.equals(reim.getTypeId(), 2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void itShouldFilterReimbursementsByStatusId() {

    }

    @Test
    void approveReimbursementById() {
    }
}