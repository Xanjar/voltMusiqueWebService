package android.rest.webService.dao.utilisateur;

import android.rest.webService.domain.utilisateur.Role;
import android.rest.webService.domain.utilisateur.Utilisateur;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UtilisateurRepositoryTest {

    @Autowired
    private UtilisateurRepository repository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private Utilisateur utilisateur= new Utilisateur("toto","nom",
            "prenom","toto@toto.fr",new Date(), "tototo", Role.USER,"39015035");



    @Test
    @Order(1)
    void insertTest() {
        utilisateur.setPassword(bCryptPasswordEncoder.encode("tototo"));
        repository.save(utilisateur);
    }

    @Test
    @Order(2)
    void showTest(){
        List<Utilisateur> list = repository.findAll();
        assertNotEquals(list.size(),0);
        for (Utilisateur u : list) {
            System.out.println(u.getPrenom()+" "+u.getNom());
        }
    }

    @Test
    @Order(3)
    void deleteTest(){
        Utilisateur util = repository.findByEmail("toto@toto.fr").get(0);
        repository.delete(util);
    }


}