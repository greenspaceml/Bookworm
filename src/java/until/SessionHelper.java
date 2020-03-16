/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package until;

import javax.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author sonnt
 */
public class SessionHelper {

    public static void addUserToSession(HttpSession session, User user) {
        session.setAttribute("user", user);
    }

    public static User getUserFromSession(HttpSession session) {
        return (User) session.getAttribute("user");
    }

    public static void tongleUserToSession(HttpSession session, User user) {
        session.removeAttribute("user");
        
        session.setAttribute("user", user);
    }
}
