package fun.elricboa;

import java.io.Serializable;

/**
 * 工作流上下文
 * @author shentong.zhou
 */
public interface WorkflowContext extends Serializable {

    String get(String keyType);

}
