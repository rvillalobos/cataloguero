/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iteso.sweng;
import java.sql.ResultSet;
/**
 *
 * @author CoCoNO
 */
public class Session {
    public boolean logged;
    User user;
    int sessionID;
    public User logIn(String _name,String _password)
    {
        if (logged) {
            return null;
        }
        User userResult=null;
        if(!DBautoQuery.getInstance().connect())
        {
            return null;
        }
        ResultSet qResult=DBautoQuery.getInstance().doQuery(
                                                    "SELECT *"
                                                  +" FROM USERS"
                                                  +" WHERE name LIKE '"+_name+"'"
                                                  +" AND password LIKE '"+_password+"'"
        );
        //qResult.
        try {
            if (qResult.next())
            {
                //System.out.println("Test data:"+rs.getString("name"));
                userResult=new User(qResult.getInt("ID"), qResult.getString("name"), qResult.getInt("level"));
                String insertQry="INSERT INTO `catalogero`.`SESSIONS` (`id`, `userId`, `logDate`) VALUES (NULL, '"+userResult.getID()+"', NOW());";
                
                DBautoQuery.getInstance().doOperation(insertQry);
            
                ResultSet instr =DBautoQuery.getInstance().doQuery("SELECT max(ID) as ID FROM SESSIONS");
                if(instr.next())
                {
                    sessionID=instr.getInt("ID");
                    logged=true;
                }
            
            }
        } catch (Exception e) {
        }
        
        
        
        DBautoQuery.getInstance().close();
        return userResult;
    }
    public User getUser()
    {
        return user;
    }
    public int getSessionID()
    {
        return sessionID;
    }
    public void logOut()
    {
        logged=false;
        user=null;
        sessionID=-1;
    }
}
