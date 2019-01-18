package com.learn.hibernate.entity.inheritance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.jboss.logging.Field;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
//@Indexed
@Proxy(lazy=false)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class MessagingConfigEntity{

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
	
	//@Field(analyze=Analyze.NO)
	private String name;
	
	private String displayName;
	
	public MessagingConfigEntity() {
		
	}
	
	public MessagingConfigEntity(String name, String displayName) {
		super();
		this.name = name;
		this.displayName = displayName;
	}

	//@Override
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void merge(MessagingConfigEntity configEntity) {
		if(null != configEntity.getDisplayName()) {
			setDisplayName(configEntity.getDisplayName());
		}
	}
	
}

