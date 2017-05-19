package org.light4j.springMvc4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {// ①

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(MyMvcConfig.class);
		ctx.setServletContext(servletContext); // ②

		Dynamic servlet = servletContext.addServlet("dispatcher",
				new DispatcherServlet(ctx)); // 3
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		servlet.setAsyncSupported(true);// ①
	}
}