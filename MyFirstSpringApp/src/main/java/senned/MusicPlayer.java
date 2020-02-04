package senned;

import java.util.List;

public class MusicPlayer {
    private Music music;
    private String name;
    private int volume;
    private List<Music> kindsOfMusic;
    //IoC
    public MusicPlayer(Music music) {
        this.music = music;
    }

    public MusicPlayer() {
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setKindsOfMusic(List<Music> kindsOfMusic) {
        this.kindsOfMusic = kindsOfMusic;
    }

    public void playMusic(){
        for(Music m:this.kindsOfMusic) {
            System.out.println("Playing: " + m.getSong());
        }
    }
}
