package org.example.reflection.test;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class Building {
    private UUID id;
    private String name;
    private String city;
    private String region;
    private String county;
    private String street;
    private int number;

    public Building() {
        this.id = UUID.randomUUID();
        this.city = null;
        this.name = null;
        this.county = null;
        this.region = null;
        this.street = null;
        this.number = 0;
    }

    public Building(UUID id){
        this.id = id;
        this.city = null;
        this.name = null;
        this.county = null;
        this.region = null;
        this.street = null;
        this.number = 0;
    }
}
