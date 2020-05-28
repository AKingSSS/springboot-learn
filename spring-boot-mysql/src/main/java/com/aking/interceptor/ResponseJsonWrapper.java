package com.aking.interceptor;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName ResponseJsonWrapper
 * @Description
 * @Author yk
 * @Date 2020/5/28 17:24
 * @Version 1.0
 **/
public class ResponseJsonWrapper {
    public static void writeResponse(HttpServletResponse response, JSONObject json) throws Exception {
        if (null != response && null != json) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;

            try {
                out = response.getWriter();
                out.append(json.toString());
            } catch (IOException var7) {
                var7.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        }
    }

    public static JSONObject newErrorReturnJson(int code, String msg) {
        JSONObject resJson = new JSONObject();
        resJson.put("code", code);
        resJson.put("msg", msg);
        return resJson;
    }

}
