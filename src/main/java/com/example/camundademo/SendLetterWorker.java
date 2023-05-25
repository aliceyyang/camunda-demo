package com.example.camundademo;

import org.camunda.bpm.client.spring.annotation.EnableExternalTaskClient;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;

@ExternalTaskSubscription(topicName = "DecideOnExpansion")
@EnableExternalTaskClient(baseUrl = "http://localhost:8080/engine-rest"/*, workerId = "expansion-worker"*/)
public class SendLetterWorker {
}
