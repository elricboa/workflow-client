package xin.shengtong;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import xin.shengtong.entity.Relation;
import xin.shengtong.entity.UserType;
import xin.shengtong.enums.ProcessStatus;
import xin.shengtong.enums.User;
import xin.shengtong.state.SimpleWorkflowState;
import xin.shengtong.workflow.DefaultWorkflowBuilder;
import xin.shengtong.workflow.impl.SimpleWorkflowContext;

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
        WorkFlowTemplate workFlowTemplate = (WorkFlowTemplate) new DefaultWorkflowBuilder().run();
        SimpleWorkflowState simpleWorkflowState = new SimpleWorkflowState();
        simpleWorkflowState.setStatus(ProcessStatus.NOT_START);
        simpleWorkflowState.setUpdateTime(now);
        final Scanner scanner = new Scanner(System.in);
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
