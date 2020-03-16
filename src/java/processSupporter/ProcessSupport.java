/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processSupporter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hongq
 */
public class ProcessSupport {
    
    public String getCurrentDate(){
        	SimpleDateFormat formatterr = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
        return formatterr.format(date) +"";
    }
    
    public String getCurrentDateForCommentID(){
        	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	Date date = new Date();
        System.out.println(formatter.format(date) +"");
        return formatter.format(date) +"";
    }
}
