package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private final Product firstProduct = new Product(1, "N1", 1);
    private final Product secondProduct = new Product(2, "N2", 2);
    private final Product thirdProduct = new Product(3, "N3", 3);
    private final Product forthProduct = new Product(4, "N4", 4);

    Manager manager = new Manager();


    @BeforeEach
    void add() {
        manager.add(firstProduct);
        manager.add(secondProduct);
        manager.add(thirdProduct);
        manager.add(forthProduct);

    }

    @Test
    public void shouldFindIdException() {
        //проверяем исключение
        Assertions.assertThrows(NotFoundException.class, ()->{manager.removeById(111);});
    }

    @Test
    public void shouldFindIdAndRemoveId() {
        // проверяем удаление
        int idToRemove = 1;

        manager.removeById(idToRemove);

        Product[] expected = {secondProduct, thirdProduct, forthProduct};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }


}