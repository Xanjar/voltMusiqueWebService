package android.rest.webService.service.plainte;

import android.rest.webService.dao.plainte.PlainteRepository;
import android.rest.webService.domain.plainte.Plainte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlainteService implements  IPlainteService{

    @Autowired
    private PlainteRepository repository;

    @Override
    public List<Plainte> findAll() {
        return repository.findAll();
    }
}
