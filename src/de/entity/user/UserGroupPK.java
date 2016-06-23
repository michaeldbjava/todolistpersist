package de.entity.user;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_group database table.
 * @author michael
 * @version 0.1
 */
@Embeddable
public class UserGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String groupname;

	@Column(insertable=false, updatable=false)
	private String username;

	public UserGroupPK() {
	}
	
	public UserGroupPK(String groupname,String username) {
		this.groupname=groupname;
		this.username=username;
	}
	
	public String getGroupname() {
		return this.groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserGroupPK)) {
			return false;
		}
		UserGroupPK castOther = (UserGroupPK)other;
		return 
			this.groupname.equals(castOther.groupname)
			&& this.username.equals(castOther.username);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.groupname.hashCode();
		hash = hash * prime + this.username.hashCode();
		
		return hash;
	}
}