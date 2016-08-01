package gt.lea.usaid.perfiladorlinguistico.utils.excepcion;

/**
 * Created by programadormd on 07-21-16.
 */
public class ErrorUsuario {

    public static final Exception CHECKEO_FALTANTE = new Exception(NumeroError.ERROR_ATRIBUTO +
    "Todas las preguntas no tienen una respuesta. Debe responder todas para poder continuar.");

    public static class NumeroError{
        public static final String ERROR_NULL = "Error #001";
        public static final String ERROR_ATRIBUTO = "Error #003";
    }

}
