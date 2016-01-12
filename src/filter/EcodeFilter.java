package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.resource.po.Member;


public class EcodeFilter implements Filter{
	private String Ecode;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse  response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(this.Ecode);
		 String path=((HttpServletRequest)request).getServletPath();  
		 System.out.println("path:"+path);
		 
		 String contextPath=((HttpServletRequest)request).getContextPath(); 
	
		 System.out.println("执行过滤");
		 System.out.println("进入拦截器前");
		HttpSession session= ((HttpServletRequest) request).getSession();
		//((HttpServletRequest) request).getSession().ToString()=="" == null
		// arg2.doFilter(request,  response);		
		/* if (session["vip"].ToString()=="")
		 {
			 System.out.println("进入拦截器");
			
		// ((HttpServletResponse)response).sendRedirect(contextPath+"/success.jsp");
			 ServletContext sc = request.getServletContext(); 
			  RequestDispatcher rd = sc.getRequestDispatcher(contextPath+"/index.jsp"); //定向的页面 
			  rd.forward(request, response); 
			
		 }
		 else{  
			 System.out.println("你进入else了");
          //   chain.doFilter(request, response);  
         }  */
	//	 chain.doFilter(request, response);  
		
		 HttpServletRequest requestHttp = (HttpServletRequest) request;  
	        String requestURI = requestHttp.getRequestURI().toLowerCase();  
	        // 判断是否是首次登陆  
	        boolean isLogin = requestURI.indexOf("login") >= 0;  
	        Member tsysuser = (Member) requestHttp.getSession().getAttribute("vip");  
	        if (!isLogin && tsysuser == null) {  
	            request.setAttribute("message", "登陆超时，请重新登陆！!!");  
	            RequestDispatcher requestDispatcher = request.getRequestDispatcher(contextPath+"/error.jsp"); 
	            System.out.println("你看到我，说明你首次登陆或者超时");
	            requestDispatcher.forward(request, response);  
	        }else{  
	            chain.doFilter(request, response);  
	        }  
	}
    
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		 this.Ecode=arg0.getInitParameter("Ecode");
		 System.out.println("进入初始化配置");
		 System.out.println("获取到的编码参数："+Ecode);
		
	}
	

}
