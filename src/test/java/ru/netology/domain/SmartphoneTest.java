package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    @Test
    public void shouldHaveAllFieldsAndMethods() {
        Smartphone smartphone = new Smartphone();
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Smartphone();
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;

        }
    }

    @Test
    public void shouldUseEquals() {
        Smartphone smartphone1 = new Smartphone(1, "Nokia", 100, "Nokia");
        Smartphone smartphone2 = new Smartphone(1, "Nokia", 100, "Nokia");
        assertEquals(smartphone1, smartphone2);
    }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Smartphone();

        product.toString();
    }
}