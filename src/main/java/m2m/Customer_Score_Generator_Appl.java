package main.java.m2m;
//protoc -I=. --java_out=C:\Users\User\Desktop\Disk\customer-score-generator\src\main\java model.proto
//https://github.com/disc99/protocol-buffers-spring-cloud-stream/blob/master/README.md
//https://github.com/spring-projects/spring-kafka/issues/727
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Customer_Score_Generator_Appl {

    private static final long TIMEOUT = 60000000;

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(Customer_Score_Generator_Appl.class, args);
        Thread.sleep(TIMEOUT);
        ctx.close();

    }
}
