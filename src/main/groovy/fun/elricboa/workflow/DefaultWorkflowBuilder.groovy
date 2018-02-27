package fun.elricboa.workflow

import fun.elricboa.enums.ProcessStatus
import fun.elricboa.enums.SysUser
import fun.elricboa.workflow.builder.WorkFlowBuilder

/**
 * 测试的流程
 */
return WorkFlowBuilder.workflow {
    start '录入客户'
    type 6
    node {
        name '录入客户'
        attr 'DisplayName', '客户信息待提交'
        actor creator
        attr 'Platform', '请前往App端录入客户信息'
        attr 'ViewUrl', ''
        action {
            name '提交'
            type SIMPLE
            send '客户审核'
        }

        submit {
            name '提交'
            attr 'Submit-Des','客户信息提交完成'
            require 'AST:CUSTOMER'
        }
    }

    node {
        name '客户审核'
        attr 'DisplayName', '客户信息待审核'
        action '通过', '成功'

        submit {
            name '通过'
            attr 'Submit-Des','客户信息通过审核'
        }
        actor SysUser.AI
    }

    node {
        name '成功'
        attr 'DisplayName', '客户已审核'
        slot {
            status ProcessStatus.SUCCESS
        }
        actor SysUser.FINISH
    }

}