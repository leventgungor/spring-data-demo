package com.gungor.SpringDataDemo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity(name = "calisan")
public class Calisan {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private String adi;

    @NonNull
    private String soyadi;

    private String telefon;

    private String adres;
}
