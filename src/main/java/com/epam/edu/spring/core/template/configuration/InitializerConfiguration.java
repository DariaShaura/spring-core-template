package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Random;

@Configuration
public class InitializerConfiguration{

    @Value("#{new java.util.Random()}")
    public Random random;

    @Bean(name = "color")
    @Scope("prototype")
    public Color color()
        throws  Exception{
        return Color.values()[random.nextInt(5)];
    }
}
