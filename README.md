# 通过Zuul及Oauth2网关控制多个微服务访问权限

注册中心
<br/>
http://localhost:8761/
![](https://raw.githubusercontent.com/calvinGithub/oauth2-picture/master/oauth2_picture/1.jpg)

以下访问都是通过路由转发（注：路由port改为8030,拦截订单先关的接口，为了对比，获取商品的接口不做权限限制）

1.获取access_token值
<br/>
http://localhost:8030/oauth/token?username=user_1&password=123456&grant_type=password&scope=select&client_id=client_2&client_secret=123456
![](https://raw.githubusercontent.com/calvinGithub/oauth2-picture/master/oauth2_picture/2.jpg)

2.携带正确的access_token去直接请求获取订单信息的接口，能正常访问。
<br/>
http://localhost:8030/oauth2-server/server/order/5?access_token=c4e0b7dc-8adb-4074-bc9f-d7e90b907289
![](https://github.com/calvinGithub/oauth2-picture/blob/master/oauth2_picture/3.jpg?raw=true)

3.携带错误的access_token去直接请求获取订单信息的接口，会报无效的token值。
<br/>
http://localhost:8030/oauth2-server/server/order/5?access_token=c4e0b7dc-8adb-4074-bc9f-d7e903454
![](https://github.com/calvinGithub/oauth2-picture/blob/master/oauth2_picture/4.jpg?raw=true)

4.不携带access_token去直接请求获取订单信息的接口，会返回未被授权的异常。
<br/>
http://localhost:8030/oauth2-server/server/order/5
![](https://github.com/calvinGithub/oauth2-picture/blob/master/oauth2_picture/5.jpg?raw=true)

5.未被拦截的路径，则无需access_token。直接请求获取商品信息的接口，可以正常访问。
<br/>
http://localhost:8030/oauth2-server/server/product/5
![](https://github.com/calvinGithub/oauth2-picture/blob/master/oauth2_picture/6.jpg?raw=true)

6.Feign客户端通过路由，携带正确的access_token请求获取订单信息的接口，能正常访问。
<br/>
http://localhost:8030/oauth2-client/client/order/getOrder/6?access_token=c4e0b7dc-8adb-4074-bc9f-d7e90b907289
![](https://github.com/calvinGithub/oauth2-picture/blob/master/oauth2_picture/7.jpg?raw=true)

7.Feign客户端通过路由，携带错误的access_token请求获取订单信息的接口，会报无效的token值。
<br/>
http://localhost:8030/oauth2-client/client/order/getOrder/6?access_token=c4e0b7dc-8adb-4074-bc9f-d7e90b90722
![](https://github.com/calvinGithub/oauth2-picture/blob/master/oauth2_picture/8.jpg?raw=true)

8.Feign客户端通过路由，不携带access_token请求获取订单信息的接口，会返回未被授权的异常。
<br/>
http://localhost:8030/oauth2-client/client/order/getOrder/6
![](https://github.com/calvinGithub/oauth2-picture/blob/master/oauth2_picture/9.jpg?raw=true)

9.未被拦截的路径，则无需access_token。Feign客户端通过路由请求获取商品信息的接口，可以正常访问。
<br/>
http://localhost:8030/oauth2-client/client/product/getProduct/6
![](https://github.com/calvinGithub/oauth2-picture/blob/master/oauth2_picture/10.jpg?raw=true)

10.客户端推送订单给服务端
<br/>
（1）提供的是无效的access_token值
![](https://github.com/calvinGithub/oauth2-picture/blob/master/oauth2_picture/11.jpg?raw=true)
![](https://github.com/calvinGithub/oauth2-picture/blob/master/oauth2_picture/12.jpg?raw=true)

（2）提供的是有效的access_token值
![](https://github.com/calvinGithub/oauth2-picture/blob/master/oauth2_picture/13.jpg?raw=true)
![](https://github.com/calvinGithub/oauth2-picture/blob/master/oauth2_picture/14.jpg?raw=true)
推送过来的订单数据已经存入到数据库订单表中。



