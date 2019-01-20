package com.learn.hibernate.entity.inheritance;

import java.util.HashSet;
import java.util.List;

/**
 * Hello world!
 *
 */
// mysql db  used in mysql-installer-community-8.0.1.0-dmr.msi
//error: Caused by: java.sql.SQLException: Field 'messagingProfiles_id' doesn't have a default value
public class App 
{
	static Respository repo = new Respository();
    public static void main( String[] args )
    {
    	System.out.println("step 1");
    	saveUpdate();   // saving connector
    	repo.clean();
    	  
    }
    public static void saveUpdate(){
    	 MessagingEnablerCfg c = new MessagingEnablerCfg("serviceName5");   
    	
     	System.out.println("saving connector");
     	MessagingProfileCfg profile1 = new MessagingProfileCfg("profilename1","addresss1");
     	MessagingSessionCfg session1 = new MessagingSessionCfg("seesion10","provider1");
     	c.addProfile(profile1);
     	c.addSession(session1);
     	System.out.println("saved connector");
     	repo.saveUpdateMessagingSession(c);
 	    
    	
    }
}


