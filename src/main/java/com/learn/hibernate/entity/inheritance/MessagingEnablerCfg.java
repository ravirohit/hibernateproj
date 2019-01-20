package com.learn.hibernate.entity.inheritance;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
//@Indexed
//@Table(name = "messagingEnablerCfg")
@Proxy(lazy=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class MessagingEnablerCfg extends MessagingConfigEntity {    
  
	private String serviceName;
	
	
	@OneToMany(cascade = { CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<MessagingProfileCfg> messagingProfiles = new HashSet<>();
	
	@OneToMany(cascade = { CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<MessagingSessionCfg> messagingSessions  = new HashSet<>();
	
	public MessagingEnablerCfg(){
		
	}
	public MessagingEnablerCfg(String service){
		this.serviceName = service;
	}
	

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Set<MessagingSessionCfg> getMessagingSessions() {
		return messagingSessions;
	}

	public void setMessagingSessions(Set<MessagingSessionCfg> messagingSessions) {
		this.messagingSessions = messagingSessions;
	}
	public Set<MessagingProfileCfg> getMessagingProfiles() {
		return messagingProfiles;
	}
	public void setMessagingProfiles(Set<MessagingProfileCfg> messagingProfiles) {
		this.messagingProfiles = messagingProfiles;
	}
    public void addSession(MessagingSessionCfg session){
    	messagingSessions.add(session);
    	
    }
    public void addProfile(MessagingProfileCfg profile){
    	messagingProfiles.add(profile);
    	
    }
	
	
	
}