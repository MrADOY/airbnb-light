package com.airbnb.aws.airbnbutils;

import com.airbnb.aws.airbnbutils.model.Facturation;
import com.airbnb.aws.airbnbutils.repository.FacturationRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    private FacturationRepository facturationRepository;

    public static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "montants")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        facturationRepository.save(gestionMessage((String) cr.value()));
    }

    private Facturation gestionMessage(String message){
        String[] values = message.split(";");
        return new Facturation(values[0], Long.valueOf(values[1]));
    }
}
