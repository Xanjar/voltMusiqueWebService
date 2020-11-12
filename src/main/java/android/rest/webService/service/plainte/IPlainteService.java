package android.rest.webService.service.plainte;

import android.rest.webService.domain.plainte.Plainte;

import java.util.List;

public interface IPlainteService {
    List<Plainte> findAll();
}
