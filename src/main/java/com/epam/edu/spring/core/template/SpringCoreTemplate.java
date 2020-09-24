package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
		SimpleItemValidator simpleItemValidator =  context.getBean(SimpleItemValidator.class);
		SimpleItemService simpleItemService = context.getBean(SimpleItemService.class);
		ArrayListItemRepository arrayListItemRepository = (ArrayListItemRepository) context.getBean("arrayListItemRepository");
		LinkedListItemRepository linkedListItemRepository = (LinkedListItemRepository) context.getBean("linkedListItemRepository");
		ItemRepository itemRepository = (ItemRepository) context.getBean("itemRepository");
	}

}
