package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.DefaultArgumentConverter;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@Tag("array")
@Tag("linked")
@SpringJUnitConfig(MainConfiguration.class)
public class SimpleItemServiceTest {

    public static class NullableConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            if ("null".equals(source)) {
                return null;
            }
            return DefaultArgumentConverter.INSTANCE.convert(source, targetType);
        }
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private LinkedListItemRepository linkedListItemRepository;

    @Autowired
    private SimpleItemService simpleItemService;

    @ParameterizedTest(name = "Тест метода SimpleItemService.createItem({0},{1}, {2},Color)")
    @CsvSource({"1, first, 1",
                "2, second, 2",
                "3, third, 3.5"})
    @DisplayName("Тест метода SimpleItemService.createItem")
    public void simpleItemServiceCreateItemTestShouldCreateItem(long id, String name, double price){

        assertTrue(simpleItemService.createItem(new Item(id, name, price, applicationContext.getBean(Color.class))));
    }

    @ParameterizedTest(name = "Тест метода SimpleItemService.createItem({0},{1}, {2},Color)")
    @CsvSource({"-1, first, 1",
            "2, second, -2",
            "3, , 3.5",
            "3, null, 3.5"})
    @DisplayName("Тест метода SimpleItemService.createItem")
    public void simpleItemServiceCreateItemTestShouldNotCreateItem(long id, @ConvertWith(NullableConverter.class) String name, double price){

        assertFalse(simpleItemService.createItem(new Item(id, name, price, applicationContext.getBean(Color.class))));
    }

    @Test
    @DisplayName("Тест метода SimpleItemService.getById")
    public void simpleItemServiceGetByIdTestShouldGetById(){

        simpleItemService.createItem(new Item(1, "1", 1, applicationContext.getBean(Color.class)));
        simpleItemService.createItem(new Item(2, "2", 1, applicationContext.getBean(Color.class)));
        simpleItemService.createItem(new Item(3, "3", 1, applicationContext.getBean(Color.class)));

        assertEquals("second", simpleItemService.getById(2).getName());
    }
}
