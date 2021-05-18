package com.example.rentacar;

import com.example.rentacar.domain.Angajat;
import com.example.rentacar.domain.Masina;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("h2")
@Rollback(false)
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void findAngajat() {

        Angajat angajat = entityManager.find(Angajat.class, 2);

        assertEquals(angajat.getNume(), "Marian");
    }
    @Test
    public void updateAngajat() {

        Angajat angajat = entityManager.find(Angajat.class, 2);
        angajat.setVarsta(23);

        entityManager.persist(angajat);
        entityManager.flush();
    }

    @Test
    public void findFirmaMasina() {

        Masina masina = entityManager.find(Masina.class, 2);
        assertEquals(masina.getFirma().getNumeFirma(), "Mercedes");
    }
}
