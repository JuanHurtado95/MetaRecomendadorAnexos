package com.ceiba.feedback_implicito.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.feedback_implicito.comando.ComandoFeedBack;
import com.ceiba.feedback_implicito.comando.menajedor.ManejadorCrearFeedBack;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
@Api(tags = { "Controlador comando feedback"})
public class ComandoControladorFeedBack {

    private ManejadorCrearFeedBack manejadorCrearFeedBack;

    public ComandoControladorFeedBack(ManejadorCrearFeedBack manejadorCrearFeedBack) {
        this.manejadorCrearFeedBack = manejadorCrearFeedBack;
    }

    @PostMapping
    @ApiOperation("Crear FeedBack")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoFeedBack comandoFeedBack){
        return manejadorCrearFeedBack.ejecutar(comandoFeedBack);
    }
}
