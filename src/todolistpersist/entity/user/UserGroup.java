package todolistpersist.entity.user;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_group database table.
 * 
 */
@Entity
@Table(name="user_group")
@NamedQuery(name="UserGroup.findAll", query="SELECT u FROM UserGroup u")
public class UserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserGroupPK id;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="username")
	private User user;

	public UserGroup() {
	}
	
	
	
	public UserGroup(String groupname,User user){
		id = new UserGroupPK();
		id.setGroupname(groupname);
		id.setUsername(user.getUsername());
		this.user=user;
		
	}


	public UserGroupPK getId() {
		return this.id;
	}

	public void setId(UserGroupPK id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "UserGroup [groupname=" + id.getGroupname() + ", user=" + id.getUsername() + "]";
	}

	
}