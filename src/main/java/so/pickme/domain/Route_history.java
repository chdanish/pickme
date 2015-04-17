package so.pickme.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;
@Entity
public class Route_history {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true)
	private long id;
	@Temporal(TemporalType.DATE)
	@Column(name = "sharingdate", updatable = false)
	protected Date sharingdate;
	protected String sharewithfriends;
	
	
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
	 * @return the sharingdate
	 */
	public Date getSharingdate() {
		return sharingdate;
	}



	/**
	 * @param sharingdate the sharingdate to set
	 */
	public void setSharingdate(Date sharingdate) {
		this.sharingdate = sharingdate;
	}



	/**
	 * @return the sharewithfriends
	 */
	public String getSharewithfriends() {
		return sharewithfriends;
	}



	/**
	 * @param sharewithfriends the sharewithfriends to set
	 */
	public void setSharewithfriends(String sharewithfriends) {
		this.sharewithfriends = sharewithfriends;
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



	private long userid;
	
	

	@JsonBackReference
	@OneToOne
	private User user;

}
