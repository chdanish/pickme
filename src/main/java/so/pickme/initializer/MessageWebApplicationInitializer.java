package so.pickme.initializer;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.github.dandelion.core.web.DandelionFilter;
import com.github.dandelion.core.web.DandelionServlet;
import com.github.dandelion.datatables.core.web.filter.DatatablesFilter;

import so.pickme.config.*;

@Order(1)
public class MessageWebApplicationInitializer extends
AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        ServletRegistration.Dynamic servletRegistration = (ServletRegistration.Dynamic) servletContext.getServletRegistration(DEFAULT_SERVLET_NAME);
        servletRegistration.setMultipartConfig(new MultipartConfigElement("/tmp", 1024 * 1024 * 5, 1024 * 1024 * 5 * 5, 1024 * 1024));

        // Register the Dandelion filter
        FilterRegistration.Dynamic dandelionFilter = servletContext.addFilter("dandelionFilter", new DandelionFilter());
        dandelionFilter.addMappingForUrlPatterns(null, false, "/*");

        // Dandelion-Datatables filter, used for basic export
        FilterRegistration.Dynamic datatablesFilter = servletContext.addFilter("datatablesFilter", new DatatablesFilter());
        datatablesFilter.addMappingForUrlPatterns(null, false, "/*");

        // Register the Dandelion servlet
        ServletRegistration.Dynamic dandelionServlet = servletContext.addServlet("dandelionServlet", new DandelionServlet());
        dandelionServlet.setLoadOnStartup(2);
        dandelionServlet.addMapping("/dandelion-assets/*");
    }

	@Override
	protected Class<?>[] getRootConfigClasses() {
	return new Class[] {MultiHttpSecurityConfig.class, ApplicationContext.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {};
	}

	@Override
	protected String[] getServletMappings() {
		 return new String[] { "/" };
	}
	
	
	  protected boolean enableHttpSessionEventPublisher() {
	    return true;
	  }
	  
	  
	
	@Override
	protected Filter[] getServletFilters() {
		return super.getServletFilters();
		
	}
	
	
	
}