package org.example.annotation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final AnnotationTestService testService;

    @GetMapping("/get")
    public void doS(){
        testService.doSmth();
    }
}
