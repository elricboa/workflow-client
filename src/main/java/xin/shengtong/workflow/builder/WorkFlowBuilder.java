package xin.shengtong.workflow.builder;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import groovy.lang.Closure;
import xin.shengtong.Node;
import xin.shengtong.WorkFlowTemplate;
import xin.shengtong.workflow.impl.WorkFlowTemplateImpl;

import java.util.Map;
import java.util.Set;

/**
 * 工作流构建
 */
public class WorkFlowBuilder {

    private Set<String> startNodes = Sets.newConcurrentHashSet();

    private Map<String, Node> nodes = Maps.newConcurrentMap();

    public static WorkFlowTemplate workflow(Closure closure) {
        return new WorkFlowBuilder().builder(closure);
    }

    private WorkFlowTemplate builder(Closure closure) {
        closure.setDelegate(this);
        closure.setResolveStrategy(Closure.DELEGATE_ONLY);
        closure.run();
        WorkFlowTemplateImpl workFlowTemplate = new WorkFlowTemplateImpl();
        workFlowTemplate.setNodes(nodes);
        workFlowTemplate.setStartNodes(startNodes);
        return workFlowTemplate;
    }
}
