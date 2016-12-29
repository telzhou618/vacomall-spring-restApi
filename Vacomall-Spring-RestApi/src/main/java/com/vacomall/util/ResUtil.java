package com.vacomall.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * i18n资源解析
 * @author Gaojun.Zhou
 * @date 2016年12月29日 上午11:04:53
 */
public class ResUtil {
	
	/**
	 * 默认语言和地区
	 */
	public final static String defaultLang = "zh_CN";
	/**
	 * 济源基础路径名称
	 */
	public final static String baeseName = "i18n/messages";
	
	/**
	 * 获取资源
	 * @param key 资源KEY
	 * @param arguments 参数
	 */
	public static String get(String key,Object...arguments){
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
		
		String lang = request.getHeader("lang");
		
		if(StringUtils.isEmpty(lang) || !lang.matches("^[a-z]{2}_[A-Z]{2}$")){
			lang = defaultLang;
		}
		String[] langs = StringUtils.split(lang,"_");
        Locale locale = new Locale(langs[0], langs[1]);
        
        ResourceBundle rb = ResourceBundle.getBundle(baeseName,locale);
        
        return MessageFormat.format(rb.getString(key),arguments);
		
	}
	
}
