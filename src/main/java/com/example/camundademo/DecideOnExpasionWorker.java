package com.example.camundademo;

import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.spring.annotation.EnableExternalTaskClient;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.topic.TopicSubscription;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.model.dmn.instance.Variable;
import org.camunda.bpm.model.xml.instance.ModelElementInstance;

import java.awt.*;
import java.net.URI;
import java.util.logging.Logger;

@ExternalTaskSubscription(topicName = "DecideOnExpansion")
@EnableExternalTaskClient(baseUrl = "http://localhost:8080/engine-rest", workerId = "expansion-worker")
// you can also add more detail configuration in application.properties
public class DecideOnExpasionWorker {
    private final static Logger LOGGER = Logger.getLogger(DecideOnExpasionWorker.class.getName());
    // boost the client
    ExternalTaskClient client = ExternalTaskClient.create()
            .baseUrl("http://localhost:8080/engine-rest")
            .asyncResponseTimeout(10000)
            .build();

    ModelElementInstance processVariable;

    // subscribe to the topic
    TopicSubscription subscription = client
            .subscribe("DecideOnExpansion")
            // business logic here
            .handler((externalTask, ExternalTaskService) -> {
                Boolean north = Math.random() >= 0.5f;
                // get a process variable
//                Variables.createVariables().putValue("north", north);
//                processVariable.setAttributeValue("north", String.valueOf(north), north);
                String dir = externalTask.getVariable("north");
                LOGGER.info("Deciding on expansion: " + (north ? "north" : "south"));
                try{
                    Desktop.getDesktop().browse(new URI("https://docs.camunda.org/get-started/quick-start/complete"));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }).open();
}
