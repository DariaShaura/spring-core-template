package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@Tag("context")
@SpringJUnitConfig(MainConfiguration.class)
public class ApplicationContextTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void isApplicationContextLoaded() {
        System.out.println(applicationContext);
    }
}
