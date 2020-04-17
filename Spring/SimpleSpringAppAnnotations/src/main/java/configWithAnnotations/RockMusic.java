package configWithAnnotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RockMusic implements Music {
    private String[] tracks = {"Wind cries Mary", "Don't Cry", "Somebody told me"};

    @Override
    public String[] getSong() {
        return tracks;
    }
}
