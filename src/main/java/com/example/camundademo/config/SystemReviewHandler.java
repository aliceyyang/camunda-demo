package com.example.camundademo.config;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
@ExternalTaskSubscription(topicName = "SystemReview")
public class SystemReviewHandler implements ExternalTaskHandler {
    private final static Logger LOGGER = Logger.getLogger(CheckProjectExistsHandler.class.getName());

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        // 提取任務變數資訊
//        String projectID = externalTask.getVariable("projectID");
//        Boolean exists = externalTask.getVariable("exists");
        int vulnerabilities = externalTask.getVariable("vulnerabilities");

        // 判斷漏洞嚴重程度
        Boolean pass = vulnerabilities < 4;
        if (pass) {
            LOGGER.info("...安全漏洞數量：" + vulnerabilities + " 系統判定通過");
        } else {
            LOGGER.warning("...安全漏洞數量：" + vulnerabilities + " 系統判定不通過需人工審核");
        }

        // 儲存變數
        VariableMap response = Variables.createVariables().putValue("pass", pass);

        // 完成任務
        externalTaskService.complete(externalTask, response);
    }
}
