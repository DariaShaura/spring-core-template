package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Random;

@Configuration
@PropertySource("classpath:application.properties")
public class RepositoryConfiguration {

    @Value("${initial.sequence:defaultValueCanBeHere}")
    private String initialSequenceStr;

    @Value("#{new java.util.Random()}")
    private Random random;

    private int getInitialSequence(){
        return initialSequenceStr != null ? Integer.parseInt(initialSequenceStr) : 0;
    }

    @Bean(name = "arrayListItemRepository")
    ArrayListItemRepository arrayListItemRepository(){
        return new ArrayListItemRepository(getInitialSequence());
    }

    @Bean(name = "linkedListItemRepository") 
    LinkedListItemRepository linkedListItemRepository(){
        return new LinkedListItemRepository(random.nextInt(100) + 1);
    }


    @Value("${item.repository.implementation:defaultValueCanBeHere}")
    private String repositoryImplementation;

    @Bean(name = "itemRepository")
    ItemRepository itemRepository(){

        if(repositoryImplementation.equals("linked")){
            return linkedListItemRepository();
        }
        else{
            return arrayListItemRepository();
        }
    }
}
