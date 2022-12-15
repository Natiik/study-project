package org.example.reflection.test;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@NoArgsConstructor
public class CustomBuilder {

    private UUID id;
    private String name;
    private String city;
    private String region;
    private String county;
    private String street;
    private int number;

    public CustomBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public CustomBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CustomBuilder city(String city) {
        this.city = city;
        return this;
    }

    public CustomBuilder region(String region) {
        this.region = region;
        return this;
    }

    public CustomBuilder country(String county) {
        this.county = county;
        return this;
    }

    public CustomBuilder street(String street) {
        this.street = street;
        return this;
    }

    public CustomBuilder number(int number) {
        this.number = number;
        return this;
    }


    public Building build() {
        Building building = new Building();
        Map<String, Object> valuesMap = createValuesMap();
        valuesMap.forEach((key, value) -> insertValue(building, key, value));
        return building;
    }


    private Map<String, Object> createValuesMap() {
        Map<String, Object> result = new HashMap<>();
        Field[] fields = this.getClass().getDeclaredFields();
        Arrays.stream(fields)
                .map(f -> {
                    f.setAccessible(true);
                    return f;
                })
                .forEach(f -> result.put(f.getName(), getValue(f)));
        return result;
    }

    @SneakyThrows
    private Object getValue(Field f) {
        return f.get(this);
    }

    @SneakyThrows
    private void insertValue(Building building, String fieldName, Object value) {
        Field field = building.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(building, value);
    }

}
