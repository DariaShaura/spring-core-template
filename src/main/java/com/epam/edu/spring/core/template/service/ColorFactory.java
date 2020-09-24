package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.entity.Color;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import java.util.Random;

public class ColorFactory extends AbstractFactoryBean<Color> {
    public ColorFactory(){
        setSingleton(false);
    }

    @Override
    public Class<?> getObjectType(){
        return Color.class;
    }

    @Override
    protected Color createInstance()
        throws Exception{
        return Color.values()[new Random().nextInt(5)];
    }
}
