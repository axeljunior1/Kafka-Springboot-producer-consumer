package kafka.amigoscode;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka/v1")
public class KafkaController {

    private final KafkaTemplate <String, String> kafkaTemplate;

    public KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/posts")
    public void publish(@RequestBody kafkaEntity kafkaEntity){
        kafkaTemplate.send("amigoscode_topic",kafkaEntity.getName());
        System.out.println("Controlleur lancé : Post: Mapping");
    }

    @GetMapping("/get")
    public void sendMes(){
        kafkaTemplate.send("amigoscode_topic", "Mon message");
        System.out.println("Controlleur lancé: Get Mapping");

    }

}
