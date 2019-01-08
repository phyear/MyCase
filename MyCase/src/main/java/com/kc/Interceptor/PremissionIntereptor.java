package com.kc.Interceptor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kc.model.Url;
import com.kc.model.Users;

public class PremissionIntereptor implements HandlerInterceptor {

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		  HttpSession session=request.getSession();
		  Users users=(Users) session.getAttribute("users");
		  //获取用户权限和所有需要验证的权限
		  List<Url> myList=users.getUrls();
		  List<Url> list=(List<Url>) session.getAttribute("allPower");
		
		  //得到当前的请求路径
		  String url=request.getRequestURI();
		  boolean exits=false;//当前路径是否是需要验证的权限，默认为fasle
		  /**
		   * 1.遍历所有权限，如果存在就为true
		   */
	       if(list!=null && myList !=null) {
	    	   for (Url urls : list) {
				     if(url.equals(urls.getUrl())) exits=true;
			       }
	         }
	       /**
	        * 1.判断是否存在
	        *    为false就放行
	        *    为true就验证权限
	        */
	       if(exits) {
	    	    /**
	    	     *验证用户的权限
	    	     */
	    	    boolean flag=false;
	    	    for (Url urls : myList) {
					if(urls.getUrl().equals(url))  flag=true;
				  }
	    	     /**
	    	      * 没有就返回登录页面
	    	      */
	    	     if(!flag) {
	    	    	 if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ 
	 	                //如果是ajax请求响应头会有，x-requested-with  
	    	    		 response.sendRedirect("/exception?msg=权限不够");	 	                 
	 	                //response.setHeader("sessionstatus", "timeout");//在响应头设置session状态  
	 	               }
	    	    	 else {
	    	    		 response.sendRedirect("/");
	    	    		
	    	    	   }
	    	    	 return flag;
	    	       }
	    	     else {
	    	    	 return flag;
	    	     }
	              }
	       else {
	    	      /**
	    	       * 有就放行
	    	       * */	    	  	    	  
		          return true;
		      }
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
