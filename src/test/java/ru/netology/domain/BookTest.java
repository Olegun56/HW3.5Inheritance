package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void shouldHaveAllFieldsAndMethods() {
        Book book = new Book();
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Book();
        if (product instanceof Book) {
            Book book = (Book) product;

        }
    }
    @Test
    public void shouldUseEquals() {
        Book book1 = new Book(1, "Гарри Поттер", 100, "Роулинг");
        Book book2 = new Book(1, "Гарри Поттер", 100, "Роулинг");
        assertEquals(book1,book2);
    }
    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Book();

        product.toString();
    }

}