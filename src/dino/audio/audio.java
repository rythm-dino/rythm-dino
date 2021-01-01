package dino.audio;
import java.io.*;
<<<<<<< HEAD
import javax.media.*;
=======
import javazoom.jl.player.*;
import javazoom.jl.decoder.*;
import javazoom.jl.converter.*;
>>>>>>> 7dd1954 (audio finished)
class audioException extends Exception{
    audioException(String errMesage){
        super(errMesage);
    }
}
<<<<<<< HEAD
public class audio {

    private String address;
    private Player player;
    public audio(String a){
        this.address = a;
    }
    public void start() throws IOException,NoPlayerException{
        File file=new File(address);
        player = Manager.createPlayer(file.toURL());
        player.start();
    }
    public void pause() throws NoPlayerException{
        player.stop();
    }
    public void unpause() throws NoPlayerException{
        player.start();
=======
class AudioMultiThread implements Runnable{
    private String addr;
    AudioMultiThread(String address){
        this.addr=address;
    }
    @Override
    public void run() throws RuntimeException{

        try {
            File file = new File(addr);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream stream = new BufferedInputStream(fis);
            Player player = new Player(stream);
            player.play();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class audio{
    private String addr;
    private Thread t;
    audio(String addr){
        this.addr=addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public void play(){
        Runnable r = new AudioMultiThread(addr);
        t = new Thread(r);
    }
    public void pause() throws InterruptedException{
        t.wait();
    }
    public void unpause() throws Exception{
        t.notify();
    }
    public void end(){
        t.interrupt();
>>>>>>> 7dd1954 (audio finished)
    }
}