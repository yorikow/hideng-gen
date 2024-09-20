import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;

public class Configuration {
    public static void main(String[] args) {
        String home = System.getProperty("user.home");
        String uri = "https://github.com/yorikow/template-hideng-gen/archive/refs/heads/main.zip";
        try {
            System.out.println(new FileOutputStream(home+"/"+"example.zip").getChannel().transferFrom(Channels.newChannel(new URL(uri).openStream()),0,Long.MAX_VALUE));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
