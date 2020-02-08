package configWithJava;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RockMusic implements Music {
    private String track = "Wind cries Mary";

    @Override
    public String getSong() {
        return track;
    }
}
