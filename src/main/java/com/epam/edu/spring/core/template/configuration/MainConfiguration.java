package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.service.ItemService;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.epam.edu.spring.core.template")
@Import({InitializerConfiguration.class, RepositoryConfiguration.class})
public class MainConfiguration {

    @Bean
    ItemValidator itemValidator(){
        return new SimpleItemValidator();
    }

    @Autowired
    ItemRepository itemRepository;

    @Bean
    SimpleItemService simpleItemService(){
        SimpleItemService simpleItemService = new SimpleItemService(itemValidator());

        simpleItemService.setItemRepository(itemRepository);

        return simpleItemService;
    }
}
