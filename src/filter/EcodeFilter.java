package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EcodeFilter implements Filter{
	private String Ecode;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		arg0.setCharacterEncoding(this.Ecode);
		 System.out.println("执行过滤");
		 arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		 this.Ecode=arg0.getInitParameter("Ecode");
		 System.out.println("进入初始化配置");
		 System.out.println("获取到的编码参数："+Ecode);
		
	}
	

}
