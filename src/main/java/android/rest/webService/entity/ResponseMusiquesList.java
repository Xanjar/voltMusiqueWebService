package android.rest.webService.entity;

import java.util.List;

public class ResponseMusiquesList {
    List<ResponseMusiques> musiques;

    public ResponseMusiquesList(List<ResponseMusiques> musiques) {
        this.musiques = musiques;
    }

    public List<ResponseMusiques> getMusiques() {
        return musiques;
    }

    public void setMusiques(List<ResponseMusiques> musiques) {
        this.musiques = musiques;
    }
}
