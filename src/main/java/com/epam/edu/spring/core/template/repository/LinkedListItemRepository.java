package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;

import java.util.LinkedList;
import java.util.Random;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */

public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

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
        holder = new LinkedList<>();
    }

    public LinkedListItemRepository(int initialSequence) {
        setHolder();
        setInitialSequence(initialSequence);
    }
}
