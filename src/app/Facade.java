package app;

public class Facade {
    PopcornPopper popcornPopper;
    TheaterLights theaterLights;
    Screen screen;
    CdPlayer cdPlayer;
    Projector projector;
    Amplifier amplifier;
    DvdPlayer dvdPlayer;
    Tuner tuner;

    public Facade() {
        popcornPopper = new PopcornPopper("Popcorn Popper");
        theaterLights = new TheaterLights("Theater Ceiling Lights");
        screen = new Screen("Theater Screen");
        amplifier = new Amplifier("Top-O-Line Amplifier");
        dvdPlayer = new DvdPlayer("Top-O-Line DVD Player", this.amplifier);
        projector = new Projector("Top-O-Line Projector", this.dvdPlayer);
        cdPlayer = new CdPlayer("Top-O-Line CD Player", amplifier);
        tuner = new Tuner("Top-O-Line AM/FM Tuner", amplifier);
    }

    public void watchMovieStart(String movie) {
        popcornPopper.on();
        popcornPopper.pop();
        theaterLights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amplifier.on();
        amplifier.setDvd(this.dvdPlayer);
        amplifier.setSurroundSound();
        amplifier.setVolume(5);
        dvdPlayer.play(movie);

    }

    public void stopWatchingMovie() {
        popcornPopper.off();
        theaterLights.on();
        screen.up();
        projector.off();
        amplifier.off();
        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.off();
    }

    public void listenToMusic() {
        theaterLights.on();
        amplifier.on();
        amplifier.setVolume(5);
        amplifier.setCd(cdPlayer);
        amplifier.setStereoSound();
        cdPlayer.on();
        cdPlayer.play("blah blah blah");
    }

    public void stopListeningToMusic() {
        amplifier.off();
        amplifier.setCd(cdPlayer);
        cdPlayer.eject();
        cdPlayer.off();
    }

    public void listenToRadio() {
        tuner.on();
        tuner.setFrequency(45);
        amplifier.on();
        amplifier.setVolume(5);
        amplifier.setTuner(tuner);
    }

    public void stopListeningToRadio() {
        tuner.off();
        amplifier.off();
    }
}
