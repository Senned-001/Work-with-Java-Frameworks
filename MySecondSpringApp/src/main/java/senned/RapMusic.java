package senned;

public class RapMusic implements Music {
    private RapMusic(){}

    public static RapMusic getRapMusic(){
        System.out.println("Working factory method...");
        return new RapMusic();
    }

    @Override
    public String getSong() {
        return "Crazy in Love";
    }
}
