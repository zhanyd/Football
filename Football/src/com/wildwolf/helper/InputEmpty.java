/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wildwolf.helper;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 * 2011-11-19 11:43
 */
public class InputEmpty {
    //InputEmpty.validate(request, "code", "订单编号");
    public static void validate(HttpServletRequest request, String parameter,String displayName) throws BusinessFailure {
        if (request.getParameter(parameter) == null || 
                request.getParameter(parameter).trim().equals(new String())) {
            throw new BusinessFailure(displayName + "不能为空!");
        }
    }
    
}
