package DesignPatterns.CommandPattern;

public class Main { //
    public static void main(String[] args) {

        TVRemote tvRemote = new TVRemote(12, "BTV");

        VolumeUpCommand volumeUpCommand = new VolumeUpCommand(tvRemote);
        volumeUpCommand.execute();


        VolumeDownCommand volumeDownCommand = new VolumeDownCommand(tvRemote);
        volumeDownCommand.execute();
        volumeDownCommand.execute();
    }
}
