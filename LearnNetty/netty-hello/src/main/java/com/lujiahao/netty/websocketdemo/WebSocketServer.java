package com.lujiahao.netty.websocketdemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author lujiahao
 * @date 2019-05-06 13:14
 */
public class WebSocketServer {
    public static void main(String[] args) throws Exception {
        // 1.定义线程组
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup subGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(mainGroup, subGroup)
                    .channel(NioServerSocketChannel.class)      // channel类型
                    .childHandler(new WebSocketInitializer());

            // 绑定端口并以同步方式
            ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();

            // 针对channelFuture进行相应的键庭
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 优雅关闭两个group
            mainGroup.shutdownGracefully();
            subGroup.shutdownGracefully();
        }
    }
}
