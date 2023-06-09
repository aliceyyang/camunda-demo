package com.example.camundademo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class LoggerDelegate implements JavaDelegate {
    private static final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("\n\n ... LoggerDelegate invoked by " +
                "processDefinitionId = " + execution.getCurrentActivityId() +
                ",activityName = " + execution.getCurrentActivityName() +
                ",processInstanceId = " + execution.getProcessInstanceId() +
                ",businessKey = " + execution.getProcessBusinessKey() +
                ",executionId = " + execution.getId() + " \n\n");
    }
}
