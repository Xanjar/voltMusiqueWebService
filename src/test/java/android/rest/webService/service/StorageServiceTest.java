package android.rest.webService.service;

import android.rest.webService.service.storage.FileStorageService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StorageServiceTest {
    @Autowired
    private FileStorageService storageService;

    @Test
    @Order(1)
    void saveTest() {
        MockMultipartFile file = new MockMultipartFile("data", "filename.txt", "text/plain", "some xml".getBytes());
        storageService.save(file,"test");
    }
    @Test
    @Order(2)
    void loadTest() {
        assertNotNull(storageService.load("test.txt"));
    }

    @Test
    @Order(3)
    void deleteTest() {
        storageService.delete("test.txt");
    }

    @Test
    @Order(4)
    public void loadTestAfterDelete() {
        assertThrows(RuntimeException.class, ()->{ storageService.load("test.txt"); });
    }

}
