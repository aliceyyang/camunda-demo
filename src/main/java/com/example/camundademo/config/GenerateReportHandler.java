package com.example.camundademo.config;

import com.example.camundademo.DecideOnExpasionWorker;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.context.annotation.Configuration;

import java.nio.file.LinkOption;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.logging.Logger;

@Configuration
@ExternalTaskSubscription(topicName = "GenerateReport")
public class GenerateReportHandler implements ExternalTaskHandler {
    private final static Logger LOGGER = Logger.getLogger(DecideOnExpasionWorker.class.getName());
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        // 提取任務變數資訊
        String projectID = externalTask.getVariable("projectID");
        Boolean exists = externalTask.getVariable("exists");
        int vulnerabilities = externalTask.getVariable("vulnerabilities");
        Boolean pass = externalTask.getVariable("pass");
        Boolean review = externalTask.getVariable("review");
        String supplementary = externalTask.getVariable("supplementary");

        // 產生報告
        String project = "專案編號：" + projectID + "\n";
        String info = "安全漏洞數量：" + vulnerabilities + "\n";
        String status;
        if (pass) {
            status = "系統判定：通過" + "\n";
        } else {
            status = "系統判定：不通過，經主管審核後通過" + "\n" + "補充說明：" + supplementary + "\n";
        }

        // 儲存變數
        String reportID = projectID + "_" + UUID.randomUUID().toString();
        LOGGER.info("...結案報告編號：" + reportID + "\n" + projectID + project + info + status);
        VariableMap response = Variables.createVariables().putValue("report", reportID + project + info + status);

        // 完成任務
        externalTaskService.complete(externalTask, response);
    }
}
