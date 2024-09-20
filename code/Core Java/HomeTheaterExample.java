// Home Theater System Example

// Component classes

class Speaker {
    private String brand;
    private int powerWatt;

    public Speaker(String brand, int powerWatt) {
        this.brand = brand;
        this.powerWatt = powerWatt;
    }

    public void playSound() {
        System.out.println("Speaker from " + brand + " playing sound at " + powerWatt + " watts");
    }

    public void adjustVolume(int level) {
        System.out.println("Speaker volume adjusted to " + level);
    }
}

class Projector {
    private String model;
    private int resolution;

    public Projector(String model, int resolution) {
        this.model = model;
        this.resolution = resolution;
    }

    public void projectImage() {
        System.out.println("Projector " + model + " projecting image at " + resolution + "p resolution");
    }

    public void adjustBrightness(int level) {
        System.out.println("Projector brightness adjusted to " + level);
    }
}

class DVDPlayer {
    private String model;

    public DVDPlayer(String model) {
        this.model = model;
    }

    public void playDVD() {
        System.out.println("DVD Player " + model + " is playing a DVD");
    }

    public void stopDVD() {
        System.out.println("DVD Player " + model + " has stopped playing");
    }
}

class RemoteControl {
    private String type;

    public RemoteControl(String type) {
        this.type = type;
    }

    public void turnOn() {
        System.out.println("Remote Control of type " + type + " turned on");
    }

    public void turnOff() {
        System.out.println("Remote Control of type " + type + " turned off");
    }

    public void adjustSettings(String component, int level) {
        System.out.println("Adjusting " + component + " to level " + level + " using remote control");
    }
}

// Main class using composition
class HomeTheaterSystem {
    private Speaker speaker;
    private Projector projector;
    private DVDPlayer dvdPlayer;
    private RemoteControl remoteControl;

    public HomeTheaterSystem(Speaker speaker, Projector projector, DVDPlayer dvdPlayer, RemoteControl remoteControl) {
        this.speaker = speaker;
        this.projector = projector;
        this.dvdPlayer = dvdPlayer;
        this.remoteControl = remoteControl;
    }

    public void startMovieNight() {
        System.out.println("Starting movie night...");
        remoteControl.turnOn();
        speaker.playSound();
        projector.projectImage();
        dvdPlayer.playDVD();
        System.out.println("Movie night started!");
    }

    public void adjustSettings() {
        System.out.println("\nAdjusting system settings...");
        remoteControl.adjustSettings("speaker", 10);
        remoteControl.adjustSettings("projector", 7);
    }

    public void endMovieNight() {
        System.out.println("Ending movie night...");
        dvdPlayer.stopDVD();
        remoteControl.turnOff();
        System.out.println("Movie night has ended.");
    }

    // Getter methods for components
    public Speaker getSpeaker() { return speaker; }
    public Projector getProjector() { return projector; }
    public DVDPlayer getDvdPlayer() { return dvdPlayer; }
    public RemoteControl getRemoteControl() { return remoteControl; }
}

// Example usage
public class HomeTheaterExample {
    public static void main(String[] args) {
        Speaker speaker = new Speaker("Bose", 150);
        Projector projector = new Projector("Epson", 1080);
        DVDPlayer dvdPlayer = new DVDPlayer("Sony DVP-SR510H");
        RemoteControl remoteControl = new RemoteControl("Universal");

        HomeTheaterSystem homeTheater = new HomeTheaterSystem(speaker, projector, dvdPlayer, remoteControl);

        homeTheater.startMovieNight();
        System.out.println("\nAdjusting settings...");
        homeTheater.adjustSettings();
        System.out.println();
        homeTheater.endMovieNight();
    }
}
