package com.lujiahao.netty.demo01_hellonetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author lujiahao
 * @date 2019-05-05 15:42
 */
public class HelloNettyServer {
    public static void main(String[] args) throws Exception {
        // 定义一对线程组
        // 主线程组,用于接受客户端的连接,但是不做任何处理
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 从线程组,主线程组会把任务丢给从线程组,让它执行任务
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // netty服务器创建, ServerBootstrap启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)       // 设置主从线程组
                    .channel(NioServerSocketChannel.class)      // 设置nio的双向通道
                    .childHandler(new HelloNettyInitializer());// 子处理器,用于处理workderGroup的任务

            // 启动server,设置8088位端口号,启动方式为同步
            ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();

            // 监听关闭的channel,设置为同步方式
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 优雅的关闭线程组
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
