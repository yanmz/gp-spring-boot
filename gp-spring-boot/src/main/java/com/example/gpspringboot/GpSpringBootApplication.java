package com.example.gpspringboot;

import com.example.gpspringboot.boot.MyFilter2;
import com.example.gpspringboot.boot.MyServlet2;
import com.example.gpspringboot.boot.MyServletRequestListener2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.example.gpspringboot.servlet"})
public class GpSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpSpringBootApplication.class, args);
	}

	@Bean
	public  static ServletRegistrationBean servletRegistrationBean (){
		ServletRegistrationBean  servletRegistrationBean = new ServletRegistrationBean();

		servletRegistrationBean.setServlet(new MyServlet2());
		servletRegistrationBean.addUrlMappings("/springboot/myServlet");
		servletRegistrationBean.setName("my-Servlet2");
		return servletRegistrationBean;
	}


	@Bean
	public static FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

		filterRegistrationBean.setFilter(new MyFilter2());
		filterRegistrationBean.addServletNames("my-Servlet2");
		filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST,DispatcherType.FORWARD);

		return filterRegistrationBean;
	}

	public static ServletListenerRegistrationBean servletListenerRegistrationBean(){
		ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
		servletListenerRegistrationBean.setListener(new MyServletRequestListener2());
		return servletListenerRegistrationBean;
	}
}
