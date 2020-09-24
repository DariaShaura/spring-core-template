package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.configuration.RepositoryConfiguration;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("array")
@SpringJUnitConfig(RepositoryConfiguration.class)
public class ArrayListItemRepositoryTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ArrayListItemRepository arrayListItemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @DisplayName("Тест присваивания itemRepository переменной типа ArrayListItemRepository, если свойство item.repository.implementation=array")
    public void itemRepositoryTestShouldEqualsArrayListItemRepositoryIfIpmlementationIsArray(){

        assertEquals(arrayListItemRepository, itemRepository);
    }

    @Test
    @DisplayName("Тест присваивания itemRepository переменной типа ArrayListItemRepository, если свойство item.repository.implementation=array")
    public void itemRepositoryTestShouldEqualsArrayListItemRepositoryIfImplementationEmpty(){

        assertEquals(arrayListItemRepository, itemRepository);
    }

}
