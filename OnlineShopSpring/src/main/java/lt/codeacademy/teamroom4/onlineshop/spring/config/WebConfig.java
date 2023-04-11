package lt.codeacademy.teamroom4.onlineshop.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

 //Here mapping for crud operations is configured
//	
@Configuration public class WebConfig implements WebMvcConfigurer {
	  
@Override 
public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")  // Update the mapping to "/**" to allow all paths
		.allowedOrigins("http://localhost:8081")
		.allowedMethods("GET", "POST", "PUT", "DELETE") .allowCredentials(false)
		.maxAge(3600)
		.allowedHeaders("*") // Add this line to allow all headers
		.exposedHeaders("*"); // Add this line to expose all headers} 

}
}
