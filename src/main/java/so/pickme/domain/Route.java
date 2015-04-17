package so.pickme.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
@Entity
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true)
	private long id;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name="user", nullable=false)
	private User user;
	
	private long userid;
	private long routegroupid;

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

	/**
	 * @return the routegroupid
	 */
	public long getRoutegroupid() {
		return routegroupid;
	}

	/**
	 * @param routegroupid the routegroupid to set
	 */
	public void setRoutegroupid(long routegroupid) {
		this.routegroupid = routegroupid;
	}

	/**
	 * @return the route_history
	 */
	public Route_history getRoute_history() {
		return route_history;
	}

	/**
	 * @param route_history the route_history to set
	 */
	public void setRoute_history(Route_history route_history) {
		this.route_history = route_history;
	}

	private float startpointLAT;
	private float startpointLONG;
	private float destpointLAT;
	private float destpointLONG;	
	private float viaCLAT;
	private float viaCLONG;
	private float viaDLAT;
	private float viaDLONG;
	private float viaELAT;
	private float viaELONG;
	private float viaFLAT;
	private float viaFLONG;
	
	
	private String routeName;
	
	private String shareType;
	private float viaCname;
	private float viaDname;
	private float viaEname;
	private float viaFname;

	@Temporal(TemporalType.DATE)
	@Column(name = "createdOn", updatable = false)
	protected Date createdOn;

	@Column(name = "last_updated")
	protected Date lastUpdatedOn;
	
	@JsonManagedReference
	@OneToOne(mappedBy="user", cascade={CascadeType.ALL})
	private Route_history route_history;
	
	
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
	 * @return the startpointLAT
	 */
	public float getStartpointLAT() {
		return startpointLAT;
	}

	/**
	 * @param startpointLAT the startpointLAT to set
	 */
	public void setStartpointLAT(float startpointLAT) {
		this.startpointLAT = startpointLAT;
	}

	/**
	 * @return the startpointLONG
	 */
	public float getStartpointLONG() {
		return startpointLONG;
	}

	/**
	 * @param startpointLONG the startpointLONG to set
	 */
	public void setStartpointLONG(float startpointLONG) {
		this.startpointLONG = startpointLONG;
	}

	/**
	 * @return the destpointLAT
	 */
	public float getDestpointLAT() {
		return destpointLAT;
	}

	/**
	 * @param destpointLAT the destpointLAT to set
	 */
	public void setDestpointLAT(float destpointLAT) {
		this.destpointLAT = destpointLAT;
	}

	/**
	 * @return the destpointLONG
	 */
	public float getDestpointLONG() {
		return destpointLONG;
	}

	/**
	 * @param destpointLONG the destpointLONG to set
	 */
	public void setDestpointLONG(float destpointLONG) {
		this.destpointLONG = destpointLONG;
	}

	/**
	 * @return the viaCLAT
	 */
	public float getViaCLAT() {
		return viaCLAT;
	}

	/**
	 * @param viaCLAT the viaCLAT to set
	 */
	public void setViaCLAT(float viaCLAT) {
		this.viaCLAT = viaCLAT;
	}

	/**
	 * @return the viaCLONG
	 */
	public float getViaCLONG() {
		return viaCLONG;
	}

	/**
	 * @param viaCLONG the viaCLONG to set
	 */
	public void setViaCLONG(float viaCLONG) {
		this.viaCLONG = viaCLONG;
	}

	/**
	 * @return the viaDLAT
	 */
	public float getViaDLAT() {
		return viaDLAT;
	}

	/**
	 * @param viaDLAT the viaDLAT to set
	 */
	public void setViaDLAT(float viaDLAT) {
		this.viaDLAT = viaDLAT;
	}

	/**
	 * @return the viaDLONG
	 */
	public float getViaDLONG() {
		return viaDLONG;
	}

	/**
	 * @param viaDLONG the viaDLONG to set
	 */
	public void setViaDLONG(float viaDLONG) {
		this.viaDLONG = viaDLONG;
	}

	/**
	 * @return the viaELAT
	 */
	public float getViaELAT() {
		return viaELAT;
	}

	/**
	 * @param viaELAT the viaELAT to set
	 */
	public void setViaELAT(float viaELAT) {
		this.viaELAT = viaELAT;
	}

	/**
	 * @return the viaELONG
	 */
	public float getViaELONG() {
		return viaELONG;
	}

	/**
	 * @param viaELONG the viaELONG to set
	 */
	public void setViaELONG(float viaELONG) {
		this.viaELONG = viaELONG;
	}

	/**
	 * @return the viaFLAT
	 */
	public float getViaFLAT() {
		return viaFLAT;
	}

	/**
	 * @param viaFLAT the viaFLAT to set
	 */
	public void setViaFLAT(float viaFLAT) {
		this.viaFLAT = viaFLAT;
	}

	/**
	 * @return the viaFLONG
	 */
	public float getViaFLONG() {
		return viaFLONG;
	}

	/**
	 * @param viaFLONG the viaFLONG to set
	 */
	public void setViaFLONG(float viaFLONG) {
		this.viaFLONG = viaFLONG;
	}

	/**
	 * @return the routeName
	 */
	public String getRouteName() {
		return routeName;
	}

	/**
	 * @param routeName the routeName to set
	 */
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}



	/**
	 * @return the shareType
	 */
	public String getShareType() {
		return shareType;
	}

	/**
	 * @param shareType the shareType to set
	 */
	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	/**
	 * @return the viaCname
	 */
	public float getViaCname() {
		return viaCname;
	}

	/**
	 * @param viaCname the viaCname to set
	 */
	public void setViaCname(float viaCname) {
		this.viaCname = viaCname;
	}

	/**
	 * @return the viaDname
	 */
	public float getViaDname() {
		return viaDname;
	}

	/**
	 * @param viaDname the viaDname to set
	 */
	public void setViaDname(float viaDname) {
		this.viaDname = viaDname;
	}

	/**
	 * @return the viaEname
	 */
	public float getViaEname() {
		return viaEname;
	}

	/**
	 * @param viaEname the viaEname to set
	 */
	public void setViaEname(float viaEname) {
		this.viaEname = viaEname;
	}

	/**
	 * @return the viaFname
	 */
	public float getViaFname() {
		return viaFname;
	}

	/**
	 * @param viaFname the viaFname to set
	 */
	public void setViaFname(float viaFname) {
		this.viaFname = viaFname;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the lastUpdatedOn
	 */
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	/**
	 * @param lastUpdatedOn the lastUpdatedOn to set
	 */
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	
	
	
	




}
