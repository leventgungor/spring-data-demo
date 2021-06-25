package com.gungor.SpringDataDemo;

import com.gungor.SpringDataDemo.model.Calisan;
import com.gungor.SpringDataDemo.repo.CalisanRepo;
import org.assertj.core.api.Assertions;
import org.hibernate.cache.spi.CacheImplementor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CalisanRepositoryTest {

    @Autowired
    private CalisanRepo calisanRepo;

    @Test
    public void whenSaveYapildiginda_thenDogruSayidaCalisan(){
        calisanRepo.save(new Calisan());
        List<Calisan> calisanlar = (List<Calisan>) calisanRepo.findAll();
        Assertions.assertThat(calisanlar.size()).isEqualTo(1);
    }

    @Test
    public void whenDeleteYapildiginda_thenBosListe(){
        List<Calisan> calisanlar;

        Calisan calisan1 = new Calisan();
        calisan1.setAdi("Levent");
        calisan1.setSoyadi("Gungor");
        calisan1.setAdres("Cayyolu");
        calisan1.setTelefon("2030");
        calisanRepo.save(calisan1);

        Calisan calisan2 = new Calisan();
        calisan2.setAdi("Mustafa");
        calisan2.setSoyadi("Gungor");
        calisan2.setAdres("Sincan");
        calisan2.setTelefon("1223");
        calisanRepo.save(calisan2);

        calisanlar = (List<Calisan>) calisanRepo.findAll();
        calisanlar.forEach(System.out::println);
        Assertions.assertThat(calisanlar.size()).isEqualTo(2);

        calisanRepo.deleteAll();
        calisanlar = (List<Calisan>) calisanRepo.findAll();
        calisanlar.forEach(System.out::println);
        Assertions.assertThat(calisanlar.size()).isEqualTo(0);

    }

}

