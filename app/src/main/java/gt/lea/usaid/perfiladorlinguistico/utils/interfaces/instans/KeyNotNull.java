package gt.lea.usaid.perfiladorlinguistico.utils.interfaces.instans;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Created by programadormd on 08-03-16.
 */
import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.ElementType.PARAMETER;

@Documented
@Retention(CLASS)
@Target(PARAMETER)
public @interface KeyNotNull {
}
