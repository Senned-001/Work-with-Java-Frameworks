package configWithAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Simple Spring Application with Annotation config
 */

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        //Computer computer = context.getBean("computer", Computer.class);
        //System.out.println(computer.toString());
        context.close();
    }
}
