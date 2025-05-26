package com.hospital_vm.cl.hospital_vm; 

import org.springframework.boot.SpringApplication; // Importa SpringApplication para iniciar la aplicación
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa la anotación SpringBootApplication para marcar esta clase como la clase principal de la aplicación
import org.springframework.context.annotation.Bean; // Importa la anotación Bean para definir beans de Spring
import org.springframework.web.servlet.config.annotation.CorsRegistry; // Importa CorsRegistry para configurar CORS
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; // Importa WebMvcConfigurer para personalizar la configuración de Spring MVC

@SpringBootApplication // Anotación que indica que esta es una aplicación Spring Boot
public class HospitalVmApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalVmApplication.class, args);
    } // Método principal que inicia la aplicación Spring Boot

    @Bean // Define un bean de configuración para CORS
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") 
                        .allowedOrigins("*") 
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") 
                        .allowedHeaders("*"); 
            } // Configura CORS para permitir solicitudes desde cualquier origen, con todos los métodos HTTP y encabezados
        };
    } // Método que devuelve un WebMvcConfigurer para personalizar la configuración de CORS

} // Clase principal de la aplicación HospitalVm, que configura y arranca la aplicación Spring Boot
// Esta clase es el punto de entrada de la aplicación y contiene la configuración básica para CORS, permitiendo que
// el frontend se comunique con el backend sin problemas de seguridad relacionados con el mismo origen.