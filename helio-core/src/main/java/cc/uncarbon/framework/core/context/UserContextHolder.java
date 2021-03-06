package cc.uncarbon.framework.core.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.experimental.UtilityClass;

/**
 * 存储当前用户上下文
 * @author Uncarbon
 */

@UtilityClass
public class UserContextHolder {
    private final TransmittableThreadLocal<UserContext> THREAD_LOCAL_USER = new TransmittableThreadLocal<>();
    private final UserContext EMPTY_USER_CONTEXT = new UserContext();

    /**
     * 设置当前用户上下文
     * @param userContext 当前用户上下文
     */
    public void setUserContext(UserContext userContext) {
        if (userContext == null) {
            THREAD_LOCAL_USER.remove();
            return;
        }
        THREAD_LOCAL_USER.set(userContext);
    }

    /**
     * 获取当前用户上下文, 确保不返回空
     * @return 当前用户上下文
     */
    public UserContext getUserContext() {
        UserContext userContext = THREAD_LOCAL_USER.get();
        if (userContext == null) {
            return EMPTY_USER_CONTEXT;
        }
        return userContext;
    }

    /**
     * 捷径-获取用户ID
     */
    public Long getUserId() {
        return getUserContext().getUserId();
    }

    /**
     * 捷径-获取用户手机号
     */
    public String getMobile() {
        return getUserContext().getMobile();
    }

    /**
     * 捷径-获取所属租户
     */
    public TenantContext getRelationalTenant() {
        return getUserContext().getRelationalTenant();
    }
}
