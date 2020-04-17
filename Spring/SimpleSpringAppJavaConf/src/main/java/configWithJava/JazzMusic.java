package configWithJava;

public class JazzMusic implements Music {
    private String track = "Let it Snow";

    @Override
    public String getSong() {
        return track;
    }
}
