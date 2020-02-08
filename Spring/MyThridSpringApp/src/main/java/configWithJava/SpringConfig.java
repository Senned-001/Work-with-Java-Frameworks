package configWithJava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
//@ComponentScan("configWithJava")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Bean
    public ClassicalMusic classicalMusic(){
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }

    @Bean
    public JazzMusic jazzMusic(){
        return new JazzMusic();
    }

    @Bean
    public List<Music> music(){
        List<Music> music = new ArrayList<>();
        music.add(classicalMusic());
        music.add(rockMusic());
        music.add(jazzMusic());
        return music;
    }

    @Bean
    public MusicPlayer musicPlayer(){
        return new MusicPlayer(music());
    }

    @Bean
    public Computer computer(){
        return new Computer(musicPlayer());
    }
}
