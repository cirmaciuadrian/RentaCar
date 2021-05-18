package com.example.rentacar.repo;

import com.example.rentacar.domain.Masina;
import com.example.rentacar.repos.MasinaRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("h2")
@Slf4j
public class FindMasinaLiberaTest {
    @Autowired
    MasinaRepo masinaRepo;

    @Test
    public void findMasinaLibera() {
        List<Masina> listaMasina = masinaRepo.findAllByEsteInchiriata(false);
        assertFalse(listaMasina.isEmpty());
        log.info("masini libere ...");
        listaMasina.forEach(masina -> log.info(masina.getNumarInmatriculare()));

    }
}
