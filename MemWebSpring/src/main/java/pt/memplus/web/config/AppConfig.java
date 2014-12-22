package pt.memplus.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
 
@Configuration
@ComponentScan(basePackages = "pt.memplus.web.controllers")
public class AppConfig {
	
	@Bean
	public UrlBasedViewResolver viewresolver()
	{
		UrlBasedViewResolver viewresolver = new UrlBasedViewResolver();
		viewresolver.setViewClass(TilesView.class);
		return viewresolver;
	}
	
	@Bean
	public TilesConfigurer tileConfigurer()
	{
		TilesConfigurer tileConfigurer = new TilesConfigurer();
		tileConfigurer.setDefinitions(new String[]{
				"/WEB-INF/tiles/tiles-definitions.xml"
		});
		tileConfigurer.setCheckRefresh(true);
		return tileConfigurer;
	}
	
 
}
