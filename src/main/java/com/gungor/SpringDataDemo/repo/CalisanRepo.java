package com.gungor.SpringDataDemo.repo;

import com.gungor.SpringDataDemo.model.Calisan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalisanRepo extends CrudRepository<Calisan, Long> {

    List<Calisan> findCalisanByAdresContaining(String semt);

    List<Calisan> findCalisansBySoyadi(String soyadi);

    @Query("SELECT c FROM calisan c WHERE c.telefon like '% :telefonKodu'")
    Calisan retriveByTelefonKodu(@Param("telefonKodu") String telefonKodu);

}
