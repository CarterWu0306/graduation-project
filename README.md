#后端项目配置清单:

    数据库mysql:部署在本地
        localhost:3306/food     
        用户名:root    
        密码:1998
    ##缓存Redis:部署在本地虚拟机
        ip:192.168.159.132
        端口:6379
        密码:1998
    消息队列RabbitMq:部署在本地CentOS虚拟机
        ip:192.168.159.129
        amqp端口:5672
        管理界面端口:15672
        用户名:wkt
        密码:wkt
    文件服务器vsftpd:部署在阿里云CentOS,通过域名访问
        地址:http://images.wukate.com/
    分布式事务框架Tx-Manager:本地项目
        项目端口:7970
        客户端TxClient请求配置:
            tx-lcn Ip:127.0.0.1
            tx-lcn 端口:8070
    注册中心eureka:部署在本地虚拟机,通过修改hosts文件域名映射
        eureka1:    
            ip:192.168.159.130 
            域名:eureka1:8761
            端口:8761
        eureka2:    
            ip:192.168.159.131 
            域名:eureka2:8761
            端口:8761
    微服务网关Zuul:本地项目
        项目端口:9800
    服务集成Feign:本地项目
        项目端口:9000
    用户微服务User:本地项目
        项目端口:9001
    商品微服务Goods:本地项目
        项目端口:9002
    订单微服务Order:本地项目
        项目端口:9003
    评价微服务Evaluation:本地项目
        项目端口:9004
    秒杀微服务:FlashSale:本地项目
        项目端口:9005
        
#前端项目配置清单:

    后台管理端vue-manage:本地项目
        项目端口:9528
    前台用户端food-user:本地项目
        项目端口:9567