### 1 查看异常
    http://localhost:8080/demo/error 全局系统异常  
    http://localhost:8080/demo/myerror 自定义系统异常
### 2 相关代码

    /**
     * 全局异常处理器
     */
    @RestControllerAdvice
    public class GobalExceptionHandler {
        
        /**
         * 处理全局异常
         *
         * @param e
         * @return
         */
        @ExceptionHandler
        public Map errHandler(Exception e) {
            Map result = new HashMap(4, 1);
            result.put("errCode", "0000");
            result.put("errMsg", e.getMessage());
            return result;
        }
    
        /**
         * 处理自定义异常
         *
         * @param e
         * @return
         */
        @ExceptionHandler
        public Map errHandler(MyException e) {
            Map result = new HashMap(4, 1);
            result.put("errCode", e.getErrCode());
            result.put("errMsg", e.getErrMsg());
            return result;
        }
    }
    
    /**
     * 模拟全局异常跟自定义异常
     */
    @RestController
    @RequestMapping("/demo")
    public class DemoController {
    
        @GetMapping("/myerror")
        public String myError() {
            try {
                int result = 1 / 0;
            } catch (Exception e) {
                throw new MyException("0000", "系统运行时出现异常");
            }
            return "myerror hello world!";
        }
    
        @GetMapping("/error")
        public String error() {
            int result = 1 / 0;
            return "error hello world!";
        }
    }