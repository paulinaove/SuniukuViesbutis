package interceptors;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by paulinaoveraite on 2017-05-10.
 */

@loggingInterceptor
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
@Slf4j
public class loggingInterceptorImplement {

    @AroundInvoke
    public Object doLogging(InvocationContext ctx) throws Exception{

        log.info("Something changed in the database");
        Object result = ctx.proceed();
        return result;
    }
}
