package com.aking.wx.config;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConfig;
import com.soecode.wxtools.api.WxService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yk
 */
@Configuration
public class WxApiConfig {

    @Bean
    public WxConfig wxConfig(){
        return WxConfig.getInstance();
    }

    @Bean
    public IService iService() {
        return new WxService();
    }

}
