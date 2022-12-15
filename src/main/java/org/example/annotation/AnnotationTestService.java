package org.example.annotation;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class AnnotationTestService{

    @SneakyThrows
    @Track
    public void doSmth() {
        Thread.sleep(5000L);
    }
}
