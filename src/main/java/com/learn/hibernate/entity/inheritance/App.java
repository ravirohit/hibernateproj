package com.learn.hibernate.entity.inheritance;

import java.util.HashSet;
import java.util.List;


// mysql db  used in mysql-installer-community-8.0.1.0-dmr.msi
public class App 
{
	static Respository repo = new Respository();
    public static void main( String[] args )
    {
    	/*System.out.println("step 1"); */
    	//saveUpdate(null);     	
    	MessagingEnablerCfg c =getProcessedEnabler("seesion2", null);
    	saveUpdate(c);
    	repo.clean();
    	  
    }
    public static void saveUpdate(MessagingEnablerCfg c){
    	if(c == null){
	    	c = new MessagingEnablerCfg("serviceName5");   
	     	System.out.println("saving connector");
	     	MessagingProfileCfg profile1 = new MessagingProfileCfg("profilename1","addresss1");
	     	MessagingSessionCfg session1 = new MessagingSessionCfg("seesion10","provider1");
	     	MessagingSessionCfg session2 = new MessagingSessionCfg("seesion2","provider12");
	     	c.addProfile(profile1);
	     	c.addSession(session1);
	     	c.addSession(session2);
	     	repo.saveUpdateMessagingSession(c);
	     	System.out.println("saved enabler");
    	}
    	else{
    		System.out.println("updating enabler");
    		repo.mergeUpdateMessagingEnabler(c);
    		System.out.println("updated enabler");
    	}
    }
    public static MessagingEnablerCfg getProcessedEnabler(String sessionName, String profileId){
    	System.out.println("getting enabler");
    	MessagingEnablerCfg messagingEnablerCfg = repo.getMessagingEnablerCfg();
    	System.out.println("got enabler");
    	if(sessionName != null){
    		System.out.println("removing session");
    		messagingEnablerCfg.removeSession(sessionName);
    	}	
    	if(profileId != null){
    		System.out.println("removing profile");
    		messagingEnablerCfg.removeProfile(profileId);
    	}
    		
    	return messagingEnablerCfg;
    	
    }
}


