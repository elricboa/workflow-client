package fun.elricboa.state;

import com.google.common.collect.Maps;
import fun.elricboa.enums.ProcessStatus;
import fun.elricboa.enums.User;
import lombok.Getter;
import lombok.Setter;
import fun.elricboa.WorkFlowState;
import fun.elricboa.enums.ProcessStatus;
import fun.elricboa.enums.User;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * 基本流程状态
 */
public class SimpleWorkflowState implements WorkFlowState {

    @Setter
    @Getter
    private ProcessStatus status;

    private Map<String, Set<User>> actors = Maps.newConcurrentMap();


    private Date updateTime;

    private Map<String, String> values = Maps.newConcurrentMap();

    @Override
    public void setState(String state, String value) {
        updateTime = new Date();
        values.put(state, value);
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = new Date(updateTime.getTime());
    }
}
