package xin.shengtong;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 节点
 */
public interface Node {

    /**
     * 结点名称
     */
    String getName();

    /**
     * 结点的关于流转的业务单元
     * @param submitName
     */
    Submit getSubmit(String submitName);

    /**
     * 结点的关于流转的业务单元
     */
    Collection<String> getSubmitNames();

    /**
     * 结点的关于撤回的业务单元
     * @param submitName
     */
    Submit getDrawback(String submitName);

    /**
     * 结点的关于流转的业务单元
     */
    Collection<String> getDrawbackNames();

    /**
     * 结点的关于流转，转出部分的基本单元
     * @param actionName
     */
    Action getAction(String actionName);

    /**
     * 节点的扩展属性
     */
    Map<String, String> getAttributes();
}
