package kafka.amigoscode;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaListener {


    @KafkaListener(topics = "amigoscode_topic", id = "groupId")
    void listener(String data){
        System.out.println("Listener is Reading: \n" + data );
    }
}
