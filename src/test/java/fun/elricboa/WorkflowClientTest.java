package fun.elricboa;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import fun.elricboa.entity.Relation;
import fun.elricboa.entity.UserType;
import fun.elricboa.enums.ProcessStatus;
import fun.elricboa.enums.User;
import fun.elricboa.state.SimpleWorkflowState;
import fun.elricboa.workflow.DefaultWorkflowBuilder;
import fun.elricboa.workflow.impl.SimpleWorkflowContext;

import java.util.Collection;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

/**
 *
 */
public class WorkflowClientTest {
    private static WorkflowClientTest ourInstance = new WorkflowClientTest();
    private static Date now = new Date();
    private static User user = new User(UserType.SYSTEM_USER, 0);
    private static UserKnowledgeBase userKnowledge = new UserKnowledgeBase() {

        @Override
        public Set<User> getUser(Collection<User> users, Relation relation) {
            return Sets.newConcurrentHashSet(Collections2.transform(users, new Function<User, User>() {
                @Override
                public User apply(User user) {
                    return new User(user.getUserType(), user.getUserId());
                }
            }));
        }
    };

    public static WorkflowClientTest getInstance() {
        return ourInstance;
    }

    private WorkflowClientTest() {
    }

    public static void main(String[] args) {
        //创建要测试的Groovy文件形式的流程模板实例
        WorkFlowTemplate workFlowTemplate = (WorkFlowTemplate) new DefaultWorkflowBuilder().run();
        //构建简单流程起始状态信息
        SimpleWorkflowState simpleWorkflowState = new SimpleWorkflowState();
        simpleWorkflowState.setStatus(ProcessStatus.NOT_START);
        simpleWorkflowState.setUpdateTime(now);
        final Scanner scanner = new Scanner(System.in);
        //构建简单流程上下文信息
        SimpleWorkflowContext simpleWorkflowContext = new SimpleWorkflowContext() {
            public String get(String keyType){
                System.out.println(keyType);
                return scanner.nextLine().trim();
            }
        };
        simpleWorkflowContext.setAddTime(now);
        simpleWorkflowContext.setUser(user);
        simpleWorkflowContext.setUserKnowledgeBase(userKnowledge);
    }

}
