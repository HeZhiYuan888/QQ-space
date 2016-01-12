package base_action;

import java.util.Map;

import org.resource.po.Member;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


	public class QQInterceptor extends AbstractInterceptor {  
		   private static final long serialVersionUID = 1358600090729208361L;  		  
		    //拦截Action处理的拦截方法  
		    public String intercept(ActionInvocation invocation) throws Exception {  
		        // 取得请求相关的ActionContext实例  
		        ActionContext ctx=invocation.getInvocationContext();  
		        Map session=ctx.getSession();  
		        //取出名为user的session属性  
		   //     System.out.println("woshi\\***********************");
		        Member pow=(Member)session.get("vip"); 
		  //      System.out.println("fdsafsdafdsafdsafdsa"+pow);
		        //如果没有登陆，都返回重新登陆  
		        System.out.println("user:"+pow);
		        if (pow != null) {  
		            System.out.println("test");  
		            return invocation.invoke();  
		        }  
		        System.out.println("你还没有登录"); 
		        ctx.put("tip", "你还没有登录");  
		        return Action.LOGIN;    //返回一个叫login的result结果
		       /* 
		        //没有登陆，将服务器提示设置成一个HttpServletRequest属性  
		    ctx.put("tip","您还没有登录，请登陆系统");  
		        return invocation.invoke();    */
		    }		  
		}  

