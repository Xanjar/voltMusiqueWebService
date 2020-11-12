package android.rest.webService.service.musique;

import android.rest.webService.dao.musique.MusiqueRepository;
import android.rest.webService.domain.musique.Musique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusiqueService implements IMusiqueService{

    @Autowired
    private MusiqueRepository repository;


    @Override
    public List<Musique> findAll() {
        return repository.findAll();
    }
}
