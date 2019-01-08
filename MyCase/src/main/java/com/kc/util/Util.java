package com.kc.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.util.StringUtils;

public class Util {
   public  final static int  PageSize=3;
   
   /**返回成功*/
   public  final static int RESPONSE_SUCCESS=200; 
   /**返回失败*/
   public  final static int RESPONSE_FAIL=500;
   /**返回Bean错误*/
   public  final static int RESPONSE_BEAN_FAIL=501;
   /**返回拦截器权限问题*/
   public  final static int RESPONSE_INTERCEPTOR_FAIL=502;
   /**返回抛出异常信息*/
   public  final static int RESPONSE_THOWS_EXCEPTION=555;
   
   public final static String  ADD_SUCCESS="创建成功";
   public final static String  ADD_FAIL="创建失败";
   public final static String  UPDATE_SUCCESS="更新成功";
   public final static String  UPDATE_FAIL="更新失败";
   public final static String  DELETE_SUCCESS="删除成功";
   public final static String  DELETE_FAIL="删除失败";
   
   /**
    * 分割字符串并转换为Long数组
    * @param a1
    * @param symbol
    * @return
    */
   public final static Long[] Conversion_String_ArrayLong(String a1,String symbol) {
	    Long[] a;
	    String[] b=a1.split(symbol);
	   	 a=new Long[b.length];
	    for(int i=0;i<b.length;i++) {
	    	Long num=Long.parseLong(b[i]);	    	    
	    		 a[i]=num;
	    	}       
	   return  a;
   }
   
   /**
    * 对两个集合求差集
    * @param olds
    * @param adds
    * @return
    */
   public final static Collection<Long> remove(List<Long> old,List<Long> add){
	   Collection<Long> olds=new  ArrayList<Long>(old);
	   Collection<Long> adds=new  ArrayList<Long>(add);
	   olds.removeAll(adds);
	   return olds;
     }
   public final static boolean isNull(Object object) {
	   if (null == object) {
           return true;
       }

       try {
           for (Field f : object.getClass().getDeclaredFields()) {
               f.setAccessible(true);

              

               if (f.get(object) != null) {
                   return false;
               }

           }
       } catch (Exception e) {
           e.printStackTrace();
       }

       return true;
     }
}
