package com.lujiahao.nettyhello;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 初始化器,channel注册后会执行里面相应的初始化方法
 * @author lujiahao
 * @date 2019-05-05 15:53
 */
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 通过SocketChannel去获得对应的管道
        ChannelPipeline pipeline = channel.pipeline();

        // 通过管道添加handler
        // HttpServerCodec是netty提供的助手类,可以理解为拦截器
        // 当请求到服务端,需要进行解码;响应到客户端是需要进行编码
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());

        // 添加自定义的助手类,返回文案:Hello Netty! 你好 Netty!
        pipeline.addLast("customerHandler", new CustomerHandler());
    }
}
