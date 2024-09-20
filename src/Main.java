import java.io.*;
import java.net.URL;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String myDir = System.getProperty("user.dir");
        String home = System.getProperty("user.home");
        System.out.println("Your Directory : " + myDir);
        System.out.print("Name Directory : ");
        String nameDir = in.nextLine();

        File file = new File(nameDir);
        if (file.mkdir()){
            System.out.println("Success created Directory " + myDir);
        } else if (file.exists()){
            System.out.println("Directory Exists");
        }
        try {
            File dirCss, dirJs;
            dirCss = new File(nameDir+"/css");
            dirJs = new File(nameDir+"/js");
            if (dirCss.mkdir() && dirJs.mkdir()){
                System.out.println("Success Create Directory CSS and JS");
            }
            File originalHtml = new File(home+"/.template-hideng-gen/index.html");
            File originalCss = new File(home+"/.template-hideng-gen/css/style.css");
            File originalJs = new File(home+"/.template-hideng-gen/js/index.js");
            Path copiedHtml = Paths.get(nameDir+"/index.html");
            Path originalPathHtml = originalHtml.toPath();
            Path copiedCss = Paths.get(dirCss.getPath()+"/style.css");
            Path copiedJs = Paths.get(dirJs.getPath()+"/index.js");
            Path originalPathCss = originalCss.toPath();
            Path originalPathJs = originalJs.toPath();
            Files.copy(originalPathHtml, copiedHtml, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(originalPathCss, copiedCss, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(originalPathJs, copiedJs, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}