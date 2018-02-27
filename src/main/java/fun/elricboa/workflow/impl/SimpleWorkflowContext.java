package fun.elricboa.workflow.impl;

import fun.elricboa.UserKnowledgeBase;
import fun.elricboa.WorkflowContext;
import fun.elricboa.enums.User;
import lombok.Getter;
import lombok.Setter;
import fun.elricboa.WorkflowContext;
import fun.elricboa.UserKnowledgeBase;
import fun.elricboa.enums.User;

import java.util.Date;

/**
 * 简单流程上下文
 */
public class SimpleWorkflowContext implements WorkflowContext {

    @Getter
    @Setter
    private User user;

    @Getter
    @Setter
    private UserKnowledgeBase userKnowledgeBase;

    private Date addTime;

    @Override
    public String get(String keyType) {
        return null;
    }

    public Date getAddTime() {
        return new Date(addTime.getTime());
    }

    public void setAddTime(Date addTime) {
        this.addTime = new Date(addTime.getTime());
    }
}
