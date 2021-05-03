package android.rest.webService.service.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface IFileStorageService {
    public void init();

    public void save(MultipartFile file,String nom);

    public Resource load(String filename);

    public void delete(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();
}
