package dd2480.group4.execute;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Execute {
    Path path;
    int exitValue;
    String stdout;
    String stderr;

    public Execute(Path path){
        this.path = path;
    }


    public void runExecuteInstructions() throws IOException, InterruptedException {
        Path executePath = path.resolve("execute.sh");
        ProcessBuilder pb = new ProcessBuilder();
        System.out.println("Searching for file: " + executePath.toString());
        if(Files.exists(executePath)){
            System.out.println("Found file: " + executePath.toString());
            pb.command("bash", "-c" , executePath.toString());
            Process process = pb.start();
            process.waitFor(5, TimeUnit.SECONDS);
            stdout  =  IOUtils.toString(process.getInputStream(), StandardCharsets.UTF_8);
            stderr  =  IOUtils.toString(process.getErrorStream(), StandardCharsets.UTF_8);
            exitValue = process.exitValue();
        }else{
            System.out.println("Failed to find file: " + executePath.toString());
            exitValue =  -1;
        }
    }

    }
