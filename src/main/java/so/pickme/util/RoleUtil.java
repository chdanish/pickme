package so.pickme.util;

import java.util.ArrayList;
import java.util.List;

public class RoleUtil {

	public static final int ROLE_ADMIN = 1;
	public static final int ROLE_USER = 2;
	public static final int ROLE_VEHICLE_USER = 3;
	public static final int ROLE_NON_VEHICLE_USER = 4;
	public static final int ROLE_TAXI_OWNER_USER = 5;
	public static final int ROLE_TRANSPORT_SERVICES_USER = 6;
	
	public static final List<Integer> roles() {
		List<Integer> roles = new ArrayList<Integer>();
		roles.add(ROLE_USER);
		roles.add(ROLE_ADMIN);
		roles.add(ROLE_VEHICLE_USER);
		roles.add(ROLE_NON_VEHICLE_USER);
		roles.add(ROLE_TAXI_OWNER_USER);
		roles.add(ROLE_TRANSPORT_SERVICES_USER);
		return roles;
	}
}
