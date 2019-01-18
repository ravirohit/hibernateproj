package com.learn.hibernate.entity.inheritance;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
//@Indexed
@Proxy(lazy = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class MessagingSessionCfg extends MessagingConfigEntity{
	
	private String sessionName;
	private String provider;
	
	
	public MessagingSessionCfg(){
		sessionName = null;
		provider = null;
		
	}
	public MessagingSessionCfg(String name,String provider){
		this.sessionName = name;
		this.provider = provider;
	}
	
	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String toString(){
		return "sessionName:"+sessionName+"  provider:"+provider;
	}
	
	
}
