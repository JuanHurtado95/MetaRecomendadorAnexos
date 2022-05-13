package com.ceiba.configuracion;

import com.ceiba.api_busqueda.puerto.repositorio.IConsultaApi;
import com.ceiba.api_busqueda.puerto.repositorio.IConsumoApi;
import com.ceiba.api_busqueda.servicio.ServicioCrearApiBusqueda;
import com.ceiba.busqueda.puerto.repositorio.RepositorioBusqueda;
import com.ceiba.busqueda.servicio.ServicioCrearBusqueda;
import com.ceiba.feedback_implicito.puerto.RepositorioFeedBack;
import com.ceiba.feedback_implicito.servicio.ServicioCrearFeedBack;
import com.ceiba.preferencia.puerto.repositorio.RepositorioPreferencia;
import com.ceiba.preferencia.servicio.ServicioActualizarPreferencia;
import com.ceiba.preferencia.servicio.ServicioCrearPreferencia;
import com.ceiba.recomendacion.servicio.ServicioConsultarRecomendacion;
import com.ceiba.recomendacion.servicio.ServicioCrearRecomendacion;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import com.ceiba.usuario.servicio.ServicioInfoUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioInfoUsuario servicioInfoUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioInfoUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearPreferencia servicioCrearPreferencia(RepositorioPreferencia repositorioPreferencia){
        return new ServicioCrearPreferencia(repositorioPreferencia);
    }

    @Bean
    public ServicioActualizarPreferencia servicioActualizarPreferencia(RepositorioPreferencia repositorioPreferencia){
        return new ServicioActualizarPreferencia(repositorioPreferencia);
    }

    @Bean
    public ServicioCrearBusqueda servicioCrearBusqueda(RepositorioBusqueda repositorioBusqueda){
        return new ServicioCrearBusqueda(repositorioBusqueda);
    }

    @Bean
    public ServicioCrearApiBusqueda servicioCrearApiBusqueda(IConsumoApi iConsumoApi){
        return new ServicioCrearApiBusqueda(iConsumoApi);
    }

    @Bean
    public ServicioCrearRecomendacion servicioCrearRecomendacion(IConsumoApi iConsumoApi){
        return new ServicioCrearRecomendacion(iConsumoApi);
    }

    @Bean
    public ServicioConsultarRecomendacion consultarRecomendacion(IConsultaApi iConsultaApi){
        return new ServicioConsultarRecomendacion(iConsultaApi);
    }

    @Bean
    public ServicioCrearFeedBack servicioCrearFeedBack(RepositorioFeedBack repositorioFeedBack){
        return new ServicioCrearFeedBack(repositorioFeedBack);
    }
}
