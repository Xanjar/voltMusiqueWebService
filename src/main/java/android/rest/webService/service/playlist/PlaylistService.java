package android.rest.webService.service.playlist;


import android.rest.webService.dao.playlist.PlaylistRepository;
import android.rest.webService.domain.playlist.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService implements IPlaylistService{

    @Autowired
    private PlaylistRepository repository;

    @Override
    public List<Playlist> findAll() {
        return repository.findAll();
    }
}
