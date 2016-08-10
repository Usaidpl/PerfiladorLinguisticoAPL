package gt.lea.usaid.perfiladorlinguistico.utils.interfaces.instans;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Created by Bryan on 08-03-16.
 * Indica al que se espera como parámetros una clases creada y no un this, contex
 */
@Documented
@Retention(CLASS)
@Target(PARAMETER)
public @interface UsaidClass {
}
