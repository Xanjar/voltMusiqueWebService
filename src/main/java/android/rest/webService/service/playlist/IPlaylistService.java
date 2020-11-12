package android.rest.webService.service.playlist;

import android.rest.webService.domain.playlist.Playlist;

import java.util.List;

public interface IPlaylistService {
    List<Playlist> findAll();
}
