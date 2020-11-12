package android.rest.webService.service.album;

import android.rest.webService.dao.album.AlbumRepository;
import android.rest.webService.domain.album.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService implements IAlbumService{

    @Autowired
    private AlbumRepository repository;

    @Override
    public List<Album> findALl() {
        return repository.findAll();
    }
}
