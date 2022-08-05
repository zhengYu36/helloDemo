package com.example.demo;


import com.example.demo.util.State;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class BaseController {

    /**
     * 处理验证错误
     * @param result
     * @param state
     * @param bErrors
     * @return
     */
    protected ModelAndView doBindingResult(ModelAndView result, State state , BindingResult bErrors){
        List<ObjectError> ObjectErrorList = bErrors.getAllErrors();
        StringBuffer message = new StringBuffer();
        for(ObjectError objectError : ObjectErrorList){
            message.append(objectError.getDefaultMessage()) ;
            message.append("\n");
        }
        state.setCode("0");
        state.setMsg(message.toString());
        result.addObject("state", state);
        return result;
    }

    /**
     * 处理验证错误
     * @param bErrors
     * @return
     */
    protected String doBindingResult(BindingResult bErrors) {
        List<ObjectError> ObjectErrorList = bErrors.getAllErrors();
        StringBuffer message = new StringBuffer();
        for (ObjectError objectError : ObjectErrorList) {
            message.append(objectError.getDefaultMessage());
            message.append("\n");
        }
        return message.toString();
    }

    /**
     * 下载返回错误文件
     * @param message
     * @return
     */
    protected ResponseEntity<byte[]> errorFile(String message){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("Model", "error");
        return new ResponseEntity<byte[]>(message.getBytes(),
                headers, HttpStatus.CREATED);
    }

    /**
     *
     * @Title: encodeChineseDownloadFileName
     * @Descriptiong:文件名中文的乱码问题
     * @param request
     * @param pFileName
     * @return
     * @throws UnsupportedEncodingException String
     */
    protected String encodeChineseDownloadFileName(HttpServletRequest request, String pFileName) throws UnsupportedEncodingException {
        String filename = null;
        String agent = request.getHeader("USER-AGENT");
        if (null != agent){
            if (-1 != agent.indexOf("Firefox")) {//Firefox
                filename = "=?UTF-8?B?" + (new String(org.apache.commons.codec.binary.Base64.encodeBase64(pFileName.getBytes("UTF-8"))))+ "?=";
            }else if (-1 != agent.indexOf("Chrome")) {//Chrome
                filename = new String(pFileName.getBytes(), "ISO8859-1");
            } else {//IE7+
                filename = java.net.URLEncoder.encode(pFileName, "UTF-8");
                filename = StringUtils.replace(filename, "+", "%20");//替换空格
            }
        } else {
            filename = pFileName;
        }
        return filename;
    }
}
