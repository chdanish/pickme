 package so.pickme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class User_friends {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true)
	private long id;
	
	private long userid;
	private long friendid;
	private long frndemailid;
	private long frnddisplayid;
	private long friendgroupid;
	private Boolean isblocked;
	
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name="user", nullable=false)
	private User user;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the userid
	 */
	public long getUserid() {
		return userid;
	}


	/**
	 * @param userid the userid to set
	 */
	public void setUserid(long userid) {
		this.userid = userid;
	}


	/**
	 * @return the friendid
	 */
	public long getFriendid() {
		return friendid;
	}


	/**
	 * @param friendid the friendid to set
	 */
	public void setFriendid(long friendid) {
		this.friendid = friendid;
	}


	/**
	 * @return the frndemailid
	 */
	public long getFrndemailid() {
		return frndemailid;
	}


	/**
	 * @param frndemailid the frndemailid to set
	 */
	public void setFrndemailid(long frndemailid) {
		this.frndemailid = frndemailid;
	}


	/**
	 * @return the frnddisplayid
	 */
	public long getFrnddisplayid() {
		return frnddisplayid;
	}


	/**
	 * @param frnddisplayid the frnddisplayid to set
	 */
	public void setFrnddisplayid(long frnddisplayid) {
		this.frnddisplayid = frnddisplayid;
	}


	/**
	 * @return the friendgroupid
	 */
	public long getFriendgroupid() {
		return friendgroupid;
	}


	/**
	 * @param friendgroupid the friendgroupid to set
	 */
	public void setFriendgroupid(long friendgroupid) {
		this.friendgroupid = friendgroupid;
	}


	/**
	 * @return the isblocked
	 */
	public Boolean getIsblocked() {
		return isblocked;
	}


	/**
	 * @param isblocked the isblocked to set
	 */
	public void setIsblocked(Boolean isblocked) {
		this.isblocked = isblocked;
	}


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


	
}
