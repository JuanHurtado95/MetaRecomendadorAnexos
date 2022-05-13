package com.ceiba.preferencia.consulta;

import com.ceiba.preferencia.modelo.dto.DtoPreferencia;
import com.ceiba.preferencia.puerto.dao.DaoPreferencia;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPreferencias {

    private final DaoPreferencia daoPreferencia;

    public ManejadorListarPreferencias(DaoPreferencia daoPreferencia) {
        this.daoPreferencia = daoPreferencia;
    }

    public List<DtoPreferencia> ejecutar(){ return this.daoPreferencia.listar(); }
}
