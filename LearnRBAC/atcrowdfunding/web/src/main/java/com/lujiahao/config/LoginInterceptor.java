package com.lujiahao.config;

import com.lujiahao.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 在控制器执行之前完成业务逻辑操作
     * 方法的返回值决定逻辑是否继续执行， true，表示继续执行， false, 表示不再继续执行。
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // 判断当前用户是否已经登陆
        HttpSession session = request.getSession();
        User loginUser = (User)session.getAttribute("loginUser");

        if ( loginUser == null ) {
            String path = session.getServletContext().getContextPath();
            response.sendRedirect(path + "/login");
            return false;
        } else {
            return true;
        }
    }

    /**
     * 在控制器执行完毕之后执行的逻辑操作
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    /**
     * 在完成视图渲染之后，执行此方法。
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
