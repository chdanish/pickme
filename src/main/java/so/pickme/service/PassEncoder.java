package so.pickme.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PassEncoder {
	
	private static PasswordEncoder encoder=new BCryptPasswordEncoder(12);
	
	
	public static PasswordEncoder passDecoder() {
		
	    return encoder;
	}
	
	public static String passDecoder1(String password){
		encoder=new BCryptPasswordEncoder(12);
		return encoder.encode(password);
		 
		
	}

}
