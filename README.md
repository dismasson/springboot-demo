# 使用actuator优雅停止服务步骤如下
### 1.开启快速停服
    management:
      endpoints:
        web:
          base-path: /my-actuator
          exposure:
            include: "*"
      endpoint:
        shutdown:
          ## 启用快速停服
          enabled: true
### 2.GET方式访问下面链接查看服务状态
    http://localhost:8080/my-actuator/service-registry
### 3.如果状态为`"status": "UP"`，则改成`"status": "DOWN"`,POST方式请求下面链接
    http://localhost:8080/my-actuator/service-registry
### 4.此时服务已经通知注册下线，但是还是会有一些请求正在处理，等待没有流量进入，POST请求下面链接快速进行服务下线
    http://localhost:8080/my-actuator/shutdown