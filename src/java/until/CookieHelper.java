/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package until;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sonnt
 */
public class CookieHelper {
    public static void sendCookie(HttpServletResponse response,String key, String value)
    {
        Cookie cooky = new Cookie(key, value);
        cooky.setMaxAge(24*3600);
        response.addCookie(cooky);
    }
    
    public static void removeCookie(HttpServletResponse response,String key)
    {
        Cookie cooky = new Cookie(key, "");
        cooky.setMaxAge(-1);
        response.addCookie(cooky);
    }
    
}
