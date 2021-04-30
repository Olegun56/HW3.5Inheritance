package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository productRepository = new ProductRepository();
    private ProductManager productManager = new ProductManager(productRepository);

    Product first = new Book(1, "Буря столетия", 500, "Стивен Кинг");
    Product second = new Book(2, "Властелин колец", 550, "Джон Толкин");
    Product third = new Book(3, "Сияние", 600, "Стивен Кинг");
    Product fourth = new Smartphone(4, "Xiaomi", 1000, "Xiaomi");
    Product fifth = new Smartphone(5, "Iphone", 1500, "Apple");

    public void setUp() {
        productManager.save(first);
        productManager.save(second);
        productManager.save(third);
        productManager.save(fourth);
        productManager.save(fifth);
    }

    @Test
    public void addProduct() {
        productManager.save(third);
        assertArrayEquals(new Product[]{third}, productRepository.findAll());
    }


    @Test
    public void searchByAuthor() {
        setUp();
        Product[] expected = new Product[]{first, third};
        Product[] actual = productManager.searchBy("Стивен Кинг");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByName() {
        setUp();
        Product[] expected = new Product[]{third};
        Product[] actual = productManager.searchBy("Сияние");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneItem() {
        productManager.save(first);

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
        productManager.save(first);
        productManager.save(second);

        Product[] expected = new Product[]{first, second};
        Product[] actual = productRepository.findAll();
        assertArrayEquals(expected, actual);
    }


}