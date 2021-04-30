package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository productRepository = new ProductRepository();
    private Smartphone smartphone = new Smartphone();


    Product first = new Smartphone(1, "Iphone", 2000, "Apple");
    Product second = new Smartphone(2, "MI 11 Ultra", 1000, "Xiaomi");

    @Test
    public void shouldSaveOneItem() {
        productRepository.save(first);

        Product[] expected = new Product[]{first};
        Product[] actual = productRepository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeEmpty() {

        Product[] expected = new Product[]{};
        Product[] actual = productRepository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveTwoItems() {
        productRepository.save(first);
        productRepository.save(second);

        Product[] expected = new Product[]{first, second};
        Product[] actual = productRepository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdSecond() {
        productRepository.save(second);

        int idToRemove = 2;

        productRepository.removeById(idToRemove);

        Product[] expected = new Product[]{};
        Product[] actual = productRepository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdFirst() {
        productRepository.save(first);

        int idToRemove = 1;

        productRepository.removeById(idToRemove);

        Product[] expected = new Product[]{};
        Product[] actual = productRepository.findAll();

        assertArrayEquals(expected, actual);
    }
}