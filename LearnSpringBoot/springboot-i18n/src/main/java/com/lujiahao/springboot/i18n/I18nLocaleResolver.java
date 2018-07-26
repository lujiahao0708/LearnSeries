package com.lujiahao.springboot.i18n;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * 国际化转换器
 * @author lujiahao
 * @date 2018-07-21 下午11:02
 */
public class I18nLocaleResolver implements LocaleResolver {

    private static final String I18N_LANGUAGE = "lang";

    @Override
    public Locale resolveLocale(HttpServletRequest req) {
        String language = req.getParameter(I18N_LANGUAGE);
        Locale locale = Locale.getDefault();
        if(StringUtils.isNotBlank(language)) {
            if ("en".equals(language)) {
                locale = Locale.US;
            } else {
                locale = Locale.CHINA;
            }
            //将国际化语言保存到session
            HttpSession session = req.getSession();
            session.setAttribute(I18N_LANGUAGE, locale);
        }else {
            //如果没有带国际化参数，则判断session有没有保存，有保存，则使用保存的，也就是之前设置的，避免之后的请求不带国际化参数造成语言显示不对
            HttpSession session = req.getSession();
            Locale localeInSession = (Locale) session.getAttribute(I18N_LANGUAGE);
            if(localeInSession != null) {
                locale = localeInSession;
            } else {
                locale = Locale.CHINA;
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest req, HttpServletResponse res, Locale locale) {

    }

}
