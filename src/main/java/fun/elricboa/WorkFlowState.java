package fun.elricboa;

import fun.elricboa.enums.ProcessStatus;
import fun.elricboa.enums.ProcessStatus;

/**
 * 工作流状态
 */
public interface WorkFlowState {

    void setStatus(ProcessStatus status);

    void setState(String state, String value);

}
