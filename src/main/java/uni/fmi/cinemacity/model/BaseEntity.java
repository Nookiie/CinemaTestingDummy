package uni.fmi.cinemacity.model;

/**
 * 
 */
public abstract class BaseEntity {

	/**
	 * Default constructor
	 */
	public BaseEntity() {

	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}