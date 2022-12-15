package org.example.reflection.test;

import java.util.UUID;

public class TestMain {
    public static void main(String[] args) {
        Building newBuilding = new CustomBuilder()
                .id(UUID.randomUUID())
                .name("New Building")
                .build();
        System.out.println("Do");
    }
}
