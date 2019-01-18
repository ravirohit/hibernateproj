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
@Proxy(lazy=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class MessagingProfileCfg extends MessagingConfigEntity {

	private String profileId;
	private String sourceAddress;
	
	public MessagingProfileCfg(){
		profileId = null;
		sourceAddress = null;
		
	}
	public MessagingProfileCfg(String profileId, String sourceAddress){
		this.profileId = profileId;
		this.sourceAddress = sourceAddress;
	}
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public String getSourceAddress() {
		return sourceAddress;
	}
	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}
	
	
	
}
