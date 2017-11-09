package xin.shengtong;

import java.util.List;
import java.util.Map;

/**
 * 工作流模板
 */
public interface WorkFlowTemplate {

    Node getNode(String nodeName);

    Map<String, Node> getNodes();

    List<Node> getStartNodes();

}
