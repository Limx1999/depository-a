package com.baidu.filter;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */

@Component
public class MyFilter  extends ZuulFilter {
      /*
        filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
					pre：路由之前 ,先执行过滤器再执行后台方法
					routing：路由之时, 执行完后台方法在执行过滤器
					post： 路由之后, 执行完后台方法在执行过滤器
					error：发送错误调用，如果请求正常没有错误，则不需要执行业务逻辑判断
    */



    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }


    //是否拦截请求  如果要放过 则要做判断
    //这里可以写逻辑判断，是否要过滤，true,永远过滤。
    // 如果返回值为true，则进入run方法进行业务处理
    // false直接进入后台

    @Override
    public boolean shouldFilter() {
        return true;
    }

    //业务处理   只有上面返回值 为true时 才会进入run方法
    //过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    @Override
    public Object run() throws ZuulException {

        //获取request对象
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //
        System.out.println(request.getContextPath());
        System.out.println(request.getRequestURI());
        System.out.println(request.getMethod());
        System.out.println(request.getAttribute("user"));
        System.out.println(request.getParameter("s" +
                "ecret_key"));
        System.out.println(request.getCookies());

      /*  currentContext.setResponseStatusCode(401);*/
        currentContext.setSendZuulResponse(true);
        HttpServletResponse response = currentContext.getResponse();
        response.setHeader("Content-type", "text/html;charset=UTF-8");

        return null;
    }
}
