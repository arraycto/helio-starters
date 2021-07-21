package cc.uncarbon.framework.satoken.interceptor;

import cc.uncarbon.framework.core.context.UserContext;
import cc.uncarbon.framework.core.context.UserContextHolder;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

/**
 * 从请求头解析并赋值到上下文
 * @author Uncarbon
 */
@Slf4j
public class DefaultSaTokenParseInterceptor implements AsyncHandlerInterceptor {
    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof ResourceHttpRequestHandler) {
            // 直接放行静态资源
            return true;
        }

        // 从请求头解析用户上下文
        if (StpUtil.isLogin()) {
            UserContext currentUser = (UserContext) StpUtil.getSession().get("userContext");
            log.debug("从请求头解析用户上下文:{}", currentUser);
            UserContextHolder.setUserContext(currentUser);
        } else {
            UserContextHolder.setUserContext(null);
        }

        return true;
    }
}
