package com.example.camundademo.config;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.logging.Logger;

@Configuration
@ExternalTaskSubscription(topicName = "ProjectInfo")
public class ProjectInfoHandler implements ExternalTaskHandler {
    private final static Logger LOGGER = Logger.getLogger(CheckProjectExistsHandler.class.getName());
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        // 提取任務變數資訊
//        String projectID = externalTask.getVariable("projectID");
//        Boolean exists = externalTask.getVariable("exists");

        // 隨機生成安全漏洞數量一至十
        int vulnerabilities = Math.abs(new Random().nextInt()) % 10 + 1;
        LOGGER.info("...安全漏洞數量：" + vulnerabilities);

        // 儲存變數
        VariableMap response = Variables.createVariables().putValue("vulnerabilities", vulnerabilities);

        // 完成任務
        externalTaskService.complete(externalTask, response);
    }
}
