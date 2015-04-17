package so.pickme.initializer;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(2)
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer

{
	protected String getDispatcherWebAppicationContextSuffix(){
		System.out.println("entering getDispatcherWebAppicationContextSuffix");
		return "mvc";
	}
	

}
