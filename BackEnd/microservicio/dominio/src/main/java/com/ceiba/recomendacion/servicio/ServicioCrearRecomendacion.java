package com.ceiba.recomendacion.servicio;

import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import com.ceiba.api_busqueda.modelo.dto.ResultMCO;
import com.ceiba.api_busqueda.puerto.repositorio.IConsumoApi;
import com.ceiba.recomendacion.modelo.entidad.Recomendacion;

import java.util.ArrayList;
import java.util.List;

public class ServicioCrearRecomendacion {

    private final IConsumoApi iConsumoApi;
    private List<String> recomendaciones;
    private RespApiBusqueda apiMCO;
    private RespApiBusqueda apiMEC;
    private RespApiBusqueda apiResponse;
    private final int PRECIO_DOLAR = 4000;
    private final int LIMITE_DE_BUSQUEDA = 3;

    public ServicioCrearRecomendacion(IConsumoApi iConsumoApi) {
        this.iConsumoApi = iConsumoApi;
    }

    public RespApiBusqueda ejecutar(Recomendacion recomendacion){

        recomendaciones = recomendacion.getPalabras();

        for(String palabra : recomendaciones){
            apiMCO = this.iConsumoApi.crearBusquedaMCO(palabra, LIMITE_DE_BUSQUEDA);
            apiMEC = this.iConsumoApi.crearBusquedaMEC(palabra, LIMITE_DE_BUSQUEDA);

            if(recomendaciones.get(0) == palabra){
                apiResponse = new RespApiBusqueda(apiMCO.getSite_id(), apiMCO.getQuery(), unirRespApi(apiMCO.getResults(), apiMEC.getResults()));
            } else {
                apiMCO.setResults(unirRespApi(apiMCO.getResults(), apiMEC.getResults()));
                apiResponse.getResults().addAll(apiMCO.getResults());
            }
        }

        return apiResponse;
    }

    private List<ResultMCO> unirRespApi(List<ResultMCO> apiMCO, List<ResultMCO> apiMEC){

        List<ResultMCO> resp = new ArrayList<>();

        if(apiMCO == null){
            return apiMEC;
        }
        if(apiMEC == null){
            return apiMCO;
        }
        for(int i=0;i<apiMCO.size();i++){
            if(apiMCO.get(i).getCurrency_id().equals("USD")){
                apiMCO.get(i).setPrice(apiMCO.get(i).getPrice()*PRECIO_DOLAR);
            }
            if(apiMEC.get(i).getCurrency_id().equals("USD")){
                apiMEC.get(i).setPrice(apiMEC.get(i).getPrice()*PRECIO_DOLAR);
            }
            resp.add(apiMCO.get(i));
            resp.add(apiMEC.get(i));
        }

        return resp;
    }
}
