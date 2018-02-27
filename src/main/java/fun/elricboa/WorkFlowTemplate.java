package fun.elricboa;

import java.util.List;
import java.util.Map;

/**
 * 工作流模板,不包含任何关于具体流程的任何信息，针对指定流程类型查询各节点信息，流转操作列表等元信息
 */
public interface WorkFlowTemplate {

    Node getNode(String nodeName);

    Map<String, Node> getNodes();

    List<Node> getStartNodes();

}
