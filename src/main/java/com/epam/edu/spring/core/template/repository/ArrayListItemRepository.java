package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Override
    public Item getById(long id) {

        return holder.stream()
                .filter(item -> item.getId() == (id + initialSequence))
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean createItem(Item item) {
        item.setId(item.getId() + initialSequence);
        return holder.add(item);
    }

    void setInitialSequence(int val) {
        initialSequence = val;
    }

    void setHolder() {
        holder = new ArrayList<>();
    }

    public ArrayListItemRepository(int initialSequence) {
        setHolder();
        setInitialSequence(initialSequence);
    }
}
