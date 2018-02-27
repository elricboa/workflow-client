package fun.elricboa.workflow.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import fun.elricboa.Node;
import lombok.Getter;
import fun.elricboa.Node;
import fun.elricboa.WorkFlowTemplate;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class WorkFlowTemplateImpl implements Serializable, WorkFlowTemplate {

    @Getter
    private Map<String, Node> nodes;

    private List<String> startNodes;

    public WorkFlowTemplateImpl() {
        nodes = Collections.emptyMap();
        startNodes = Collections.emptyList();
    }

    public void setNodes(Map<String, Node> nodes) {
        this.nodes = ImmutableMap.copyOf(nodes);
    }

    public void setStartNodes(Collection<String> startNodes) {
        this.startNodes = ImmutableList.copyOf(startNodes);
    }

    @Override
    public Node getNode(String nodeName) {
        Preconditions.checkNotNull(nodeName, "根据节点名称查找，节点名称不能为空");
        return Preconditions.checkNotNull(nodes.get(nodeName), "根据节点名称查找节点未找到");
    }

    @Override
    public List<Node> getStartNodes() {
        return null;
    }
}
