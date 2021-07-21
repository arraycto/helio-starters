package cc.uncarbon.framework.dubbo.filter;

import cc.uncarbon.framework.core.context.UserContext;
import cc.uncarbon.framework.core.context.UserContextHolder;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * 自定义提供者上下文
 * @author Zhu JW
 **/
@Slf4j
@Activate(group = CommonConstants.PROVIDER)
public class ProviderContextFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String userContextJson = RpcContext.getContext().getAttachment("userContext");
        if (StrUtil.isNotEmpty(userContextJson)) {
            UserContext userContext = JSONUtil.parseObj(userContextJson).toBean(UserContext.class);
            UserContextHolder.setUserContext(userContext);
            log.debug("【RPC】获取用户上下文信息===>{}", userContextJson);
        }

        return invoker.invoke(invocation);
    }
}
