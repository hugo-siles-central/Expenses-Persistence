package com.expenses.persistence.repository;

import com.expenses.persistence.entities.CondoEntity;
import com.expenses.persistence.ExpensesPersistenceApplication;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ExpensesPersistenceApplication.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
                         TransactionalTestExecutionListener.class,
                         DbUnitTestExecutionListener.class})
@SpringBootTest
@DatabaseSetup(value = "/condo-entries.xml", type = DatabaseOperation.CLEAN_INSERT)
public class CondoRepositoryTest {

    @Autowired
    private CondoRepository condoRepo;

    @Test
    public void findById_CondoIsRetrievedCorrectly() {
        Optional<CondoEntity> condo = condoRepo.findById((long) 1);
        if (condo.isPresent()) {
            CondoEntity retrievedCondo = condo.get();
            assertEquals("Juan Pablo 2do - Fase II", retrievedCondo.getName());
            assertEquals("Av Dorbigny esq Juan Claure", retrievedCondo.getAddress());
            assertEquals("70710554", retrievedCondo.getPhones());

        } else {
            fail("condo not retrieved from the database");
        }

    }

    @Test
    public void save_CondoIsSavedCorrectly() {

        CondoEntity newCondo = createTestCondoEntity();
        CondoEntity savedCondo = condoRepo.save(newCondo);

        assertNotNull(savedCondo.getId());

        Optional<CondoEntity> condo = condoRepo.findById(savedCondo.getId());
        if (condo.isPresent()) {
            CondoEntity retrievedCondo = condo.get();
            assertEquals("test name", retrievedCondo.getName());
            assertEquals("test address", retrievedCondo.getAddress());
            assertEquals("test phones", retrievedCondo.getPhones());

            condoRepo.delete(retrievedCondo);

        } else {
            fail("New condo not found in the db");
        }
    }

    @Test
    public void delete_CondoIsDeletedFromDatabase() {

        CondoEntity newCondo = createTestCondoEntity();
        CondoEntity savedCondo = condoRepo.save(newCondo);

        Optional<CondoEntity> condo = condoRepo.findById(savedCondo.getId());

        if (condo.isPresent()) {
            condoRepo.delete(condo.get());

        } else {
            fail("New condo not found in the db");
        }
    }

    private CondoEntity createTestCondoEntity() {
        CondoEntity newCondo = new CondoEntity();
        newCondo.setAddress("test address");
        newCondo.setName("test name");
        newCondo.setPhones("test phones");
        return newCondo;
    }

}