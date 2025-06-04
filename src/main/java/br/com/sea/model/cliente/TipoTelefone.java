package br.com.sea.model.cliente;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Tipo de telefone do cliente")
public enum TipoTelefone {
    RESIDENCIAL,
    COMERCIAL,
    CELULAR
}
