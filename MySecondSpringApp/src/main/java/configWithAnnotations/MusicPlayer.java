package configWithAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private String volume;
    private Music music1;
    private Music music2;

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1, @Qualifier("classicalMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String getName() {
        return name;
    }

    public String getVolume() {
        return volume;
    }

    public enum Genre{
        CLASSIC,
        ROCK
    }

    public String playMusic(Genre genre){
        Random random = new Random();
        int number = random.nextInt(3);
        if(genre.equals(Genre.ROCK)) return "Playing: " + music1.getSong()[number];
        if(genre.equals(Genre.CLASSIC)) return "Playing: " + music2.getSong()[number];
        return null;
    }
}
