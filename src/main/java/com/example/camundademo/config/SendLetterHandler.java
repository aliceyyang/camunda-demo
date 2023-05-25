package com.example.camundademo.config;

import com.example.camundademo.DecideOnExpasionWorker;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
@ExternalTaskSubscription(topicName = "SendLetter")
public class SendLetterHandler implements ExternalTaskHandler {
    private final static Logger LOGGER = Logger.getLogger(DecideOnExpasionWorker.class.getName());

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        // baseUrl have already been set in application.properties
        // add business logic
        String bookTitle = externalTask.getVariable("book");
        LOGGER.info("...book info:" + bookTitle);
        // create a variable
        String austriaResponse = "Sorry Jean can't help.";
        // return the variable after the task is completed
        VariableMap response = Variables.createVariables().putValue("austriaResponse", austriaResponse);
        externalTaskService.complete(externalTask, response);
    }
}
