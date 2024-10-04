package ar.edu.utn.frc.tup.lc.iv.repositories;

import ar.edu.utn.frc.tup.lc.iv.entities.ProductEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void test() {
        assertNotNull(entityManager);
        assertNotNull(productRepository);
    }


    @Test
    void findByName() {
        // given
        ProductEntity product = new ProductEntity();
        product.setName("test");
        entityManager.persist(product);
        entityManager.flush();

        // when
        ArrayList<ProductEntity> found = productRepository.findByName(product.getName());

        // then
        assertEquals(found.size(), 1);
        assertEquals(found.get(0), product);
    }

    @Test
    void findByName_notFound() {
        // given
        ProductEntity product = new ProductEntity();
        product.setName("test");
        entityManager.persist(product);
        entityManager.flush();

        // when
        ArrayList<ProductEntity> found = productRepository.findByName("notFound");

        // then
        assertEquals(found.size(), 0);
    }

    @Test
    void findByName_multiple() {
        // given
        ProductEntity product = new ProductEntity();
        product.setName("test");
        entityManager.persist(product);
        ProductEntity product2 = new ProductEntity();
        product2.setName("test");
        entityManager.persist(product2);
        entityManager.flush();

        // when
        ArrayList<ProductEntity> found = productRepository.findByName(product.getName());

        // then
        assertEquals(found.size(), 2);
        assertTrue(found.contains(product));
        assertTrue(found.contains(product2));
    }

}