package cc.uncarbon.framework.dubbo.filter;

import cc.uncarbon.framework.core.context.UserContext;
import cc.uncarbon.framework.core.context.UserContextHolder;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义消费者上下文
 * @author Zhu JW
 **/
@Slf4j
@Activate(group = CommonConstants.CONSUMER)
public class ConsumerContextFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Map<String, String> context = new HashMap<>(16);

        UserContext userContext = UserContextHolder.getUserContext();
        String userContextJson = JSONUtil.toJsonStr(userContext);
        context.put("userContext", userContextJson);
        log.debug("【RPC】设置用户上下文信息===>{}", userContextJson);

        // 放进Dubbo消费者附件中
        RpcContext.getContext().setAttachments(context);

        return invoker.invoke(invocation);
    }
}
