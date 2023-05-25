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
@ExternalTaskSubscription(topicName = "CheckProjectExists")
public class CheckProjectExistsHandler implements ExternalTaskHandler {
    private final static Logger LOGGER = Logger.getLogger(CheckProjectExistsHandler.class.getName());

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        // 提取任務變數資訊
        String projectID = externalTask.getVariable("projectID");

        // 隨機生成 boolean 檢測專案是否存在
        Boolean exists = new Random().nextBoolean();
        LOGGER.info("...projectID:" + projectID + " 是否存在：" + (exists ? '是' : '否'));

        // 儲存變數
        VariableMap response = Variables.createVariables().putValue("exists", exists);

        // 完成任務
        externalTaskService.complete(externalTask, response);

    }
}
