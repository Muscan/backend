package clinic.backend.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

public class LocationUtils {
    public static URI getLocationUri(UUID id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(id)
                .toUri();
    }
}
