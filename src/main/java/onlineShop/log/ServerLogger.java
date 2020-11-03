package onlineShop.log;
import org.springframework.stereotype.Component;

@Component
public class ServerLogger implements Logger{
    public ServerLogger (){
        System.out.println("ServerLogger constructor was called");
    }
    public void log(String info) {
        System.out.println("Server log = " + info + ", from log instance: " + this);
    }
}
