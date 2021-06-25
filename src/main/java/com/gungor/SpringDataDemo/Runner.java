package com.gungor.SpringDataDemo;

import com.gungor.SpringDataDemo.model.Calisan;
import com.gungor.SpringDataDemo.repo.CalisanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    public CalisanRepo calisanRepo;

    @Override
    public void run(String... args) throws Exception {
        Calisan calisan1 = new Calisan();
        calisan1.setAdi("Levent");
        calisan1.setSoyadi("Gungor");
        calisan1.setAdres("XXCayyolu 2876. Sok. NO:2");
        calisan1.setTelefon("+905305674534");
        calisanRepo.save(calisan1);

        ikinciCalisanEkle();

        calisanRepo.findAll().forEach(cls -> System.out.println(cls));

        List<Calisan> cls1 = calisanRepo.findCalisanByAdresContaining("Cayyolu");
        cls1.stream().map(Calisan::getAdres).forEach(System.out::println);


        Optional<String> firstOp = cls1.parallelStream().map(calisan -> calisan.get).filter(telefon -> telefon == "+905408901223").findFirst();

        firstOp.ifPresent( first -> System.out.println(first));

        firstOp.

        if(firstOp.isPresent()){
            System.out.println(firstOp.get());
        }

        System.out.println("Cayyolunda oturan calisan" + cls1.get(0));
        System.out.println("Cayyolunda oturan calisan" + cls1.get(1));

        Calisan cls2 = calisanRepo.retriveByTelefonKodu("530");
        System.out.println("530 telefon kodlu calisan" + cls2);

        List<Calisan> clss = calisanRepo.findCalisansBySoyadi("Gungor");
        System.out.println("Soyadi Gungor olan calisanlar: ");
        clss.forEach(System.out::println);

    }

    private void ikinciCalisanEkle() {
        Calisan calisan2 = new Calisan();
        calisan2.setAdi("Elif");
        calisan2.setSoyadi("Gungor");
        calisan2.setAdres("Cankaya");
        calisan2.setTelefon("+905408901223");
        calisanRepo.save(calisan2);
    }
}
