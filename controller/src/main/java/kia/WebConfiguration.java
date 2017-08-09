package kia;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by i.kalinnikov on 08.08.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "kia")
public class WebConfiguration {

}
