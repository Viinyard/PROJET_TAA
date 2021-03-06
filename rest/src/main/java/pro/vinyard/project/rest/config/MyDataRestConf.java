package pro.vinyard.project.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import pro.vinyard.project.rest.data.*;

/**
 * @author VinYarD
 * created : 01/05/2018, 15:39
 */

@Configuration
public class MyDataRestConf extends RepositoryRestConfigurerAdapter {

    /*
        Classe de configuration des repository rest.
     */

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        /*
            Ordonne a spring rest d'afficher l'ID des ressources Sensor et Measure.
         */
        config.exposeIdsFor(CPAddress.class);
        config.exposeIdsFor(CPAttachment.class);
        config.exposeIdsFor(CPCar.class);
        config.exposeIdsFor(CPDeplacement.class);
        config.exposeIdsFor(CPEmployee.class);
        config.exposeIdsFor(CPEnterprise.class);
        config.exposeIdsFor(CPLocation.class);
        config.exposeIdsFor(CPPhoneNumber.class);
        
    }

    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // you USUALLY want this
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
