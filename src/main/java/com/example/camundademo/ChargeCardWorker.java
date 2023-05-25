package com.example.camundademo;

import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.topic.TopicSubscription;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

public class ChargeCardWorker {
    private final static Logger LOGGER = Logger.getLogger(ChargeCardWorker.class.getName());
    ExternalTaskClient client  = ExternalTaskClient.create()
            .baseUrl("http://localhost:8080/engine-rest")
            .asyncResponseTimeout(10000) // 超過時間
            .build();
    TopicSubscription subscript = client.subscribe("charge-card")
            .lockDuration(1000)
            .handler((externalTask, ExternalTaskService)->{
                String item = externalTask.getVariable("item");
                Integer amount = externalTask.getVariable("amount");

                LOGGER.info("Charging credit card with an amount of '" + amount + "'$ for the item '" + item + "'...");

                try {
                    Desktop.getDesktop().browse(new URI("https://docs.camunda.org/get-started/quick-start/complete"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                ExternalTaskService.complete(externalTask);
            }).open();

}
