package com.learn.hibernate.mainapp;

import java.util.HashSet;
import java.util.List;

import com.learn.hibernate.entity.inheritance.MessagingConfigEntity;
import com.learn.hibernate.entity.inheritance.MessagingEnablerCfg;
import com.learn.hibernate.entity.inheritance.MessagingProfileCfg;
import com.learn.hibernate.entity.inheritance.MessagingSessionCfg;

/**
 * Hello world!
 *
 */
// mysql db  used in mysql-installer-community-8.0.1.0-dmr.msi
//error: Caused by: java.sql.SQLException: Field 'messagingProfiles_id' doesn't have a default value
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("step 1");
    	
    	Respository repo = new Respository();
    	 MessagingEnablerCfg c = new MessagingEnablerCfg("serviceName5");   
    	// repo.saveUpdateMessagingSession(c);   // Create connector
    	 
    	 
    	System.out.println("saved connector");
    	MessagingProfileCfg profile1 = new MessagingProfileCfg("profilename1","addresss1");
    	 MessagingSessionCfg session1 = new MessagingSessionCfg("seesion10","provider1");
	    //c.getMessagingSessions().add(session1);
	    //c.getMessagingSessions().add(session2);
    	/*List<MessagingEnablerCfg> messagingEnablerCfg = repo.getMessagingEnablerCfg();
    	System.out.println("----");
    	MessagingEnablerCfg enabler = messagingEnablerCfg.get(0);
    	System.out.println("loading connector from DB"+enabler.getId());*/
    	c.addSession(session1);
    	c.addProfile(profile1);
    	repo.saveUpdateMessagingSession(c);
    	 
	   
	     
	    
    	
    	repo.clean();
    	  
    }
}


