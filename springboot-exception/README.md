# 工程简介
```java
/**
 * 也可以使用@RestControllerAdvice，它用于直接返回json的，不能返回jsp页面的
 */
@ControllerAdvice(annotations = {Controller.class, RestController.class}) //可以用来返回统一的错误json或者是统一错误jsp页面
public class GlobalExceptionHandler implements ResponseBodyAdvice<Object>, RequestBodyAdvice  {
    /**
     * 方式一：统一返回一个错误的json格式的数据
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = RuntimeException.class)
    public @ResponseBody
    Object errorHandlerByJson(HttpServletRequest request, Exception e) throws Exception {
        //可以拿到异常信息
        e.printStackTrace();

        //可以返回统一数据
        return new ResultObject(Constant.ONE, "Sorry，服务器开小差啦，RuntimeException~", null);
    }

    //@ExceptionHandler(value = IOException.class)
    public @ResponseBody Object errorHandlerByJson2(HttpServletRequest request, Exception e) throws Exception {
        //可以拿到异常信息
        e.printStackTrace();

        //可以返回统一数据
        return new ResultObject(Constant.ONE, "Sorry，IOException~", null);
    }

    /**
     * 当发生异常的时候，跳转到统一的错误页
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    //@ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IOException.class)
    public ModelAndView errorHandlerByView(HttpServletRequest request, Exception e) throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e.getMessage());
        modelAndView.addObject("url", request.getRequestURL());

        System.out.println(bean对象);

        //设置发生异常的时候，跳转到哪个页面
        modelAndView.setViewName("error");
        //可以返回统一数据
        return modelAndView;
    }

    /**
     * 处理404页面找不到错误
     * 配置一个bean
     *
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return ((ConfigurableWebServerFactory factory) -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"); //OK
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
            factory.addErrorPages(error401Page, error404Page, error500Page);
        });
    }


    // 对controller返回结果再加工
    // implements ResponseBodyAdvice<Object>, RequestBodyAdvice 
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        System.out.println("beforeBodyWrite.............................................");
        Object out = null;
        if (body instanceof ResultObject) {
            out = body;
        } else if (body instanceof String) {
            // 因为controller返回类型是String，这里需要将ResultObject转成String
            // ResultObject resultObject = new ResultObject<>(Constant.ZERO, "操作成功", body);
            //out = JSONObject.toJSONString(resultObject);
            out = body;
        } else {
            out = body;
        }
        return out;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return null;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return null;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return null;
    }
}
```
# 延伸阅读

