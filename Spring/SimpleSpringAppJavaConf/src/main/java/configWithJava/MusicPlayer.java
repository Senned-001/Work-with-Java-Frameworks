package configWithJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

//@Component
public class MusicPlayer {
    //@Value("${musicPlayer.name}")
    private String name;
   // @Value("${musicPlayer.volume}")
    private String volume;
    private List<Music> music;

    /*@Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1, @Qualifier("classicalMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }*/
    public MusicPlayer(List<Music> music){
        this.music = music;
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

    public String playMusic(){
        Random random = new Random();
        int number = random.nextInt(3);
        return "Playing: " + this.music.get(number).getSong();
    }
}
