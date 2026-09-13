Паттерн для удобного логирования тела запроса. Позволяет логировать тела запросов в выбранных контроллерах.
Чтобы тело логировалось, достаточно использовать аннотацию `LogRequestBody`.

```java
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface LogRequestBody {
}

@Slf4j
@ControllerAdvice(annotations = LogRequestBody.class)
public class LogRequestBodyAdvice implements RequestBodyAdvice {
    @Override
    public boolean supports(MethodParameter method, Type targetType, Class<? extends HttpMessageConverter<?>> clazz) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter method, Type targetType,
                                           Class<? extends HttpMessageConverter<?>> clazz) throws IOException {
        BufferingHttpInputMessage message = new BufferingHttpInputMessage(inputMessage);
        log.info("Request body: {}", StreamUtils.copyToString(message.getBody(), StandardCharsets.UTF_8));
        return message;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter method, Type targetType,
                                Class<? extends HttpMessageConverter<?>> clazz) {
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter method, Type targetType,
                                  Class<? extends HttpMessageConverter<?>> clazz) {
        log.info("request body is EMPTY");
        return body;
    }
}
```

Использование:
```java
@RestController
@RequestMapping("/api/v1/coreapi")
@RequiredArgsConstructor
@LogRequestBody
public class CoreApiController {
    //fields and methods...
}
```