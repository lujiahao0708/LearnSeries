package com.lujiahao.netty.demo02_lifecycle;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;


/**
 * @author lujiahao
 * @date 2019-05-21 16:27
 */
public class NettyLifeCycleInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());
        pipeline.addLast("NettyLifeCycleHandler", new NettyLifeCycleHandler());
    }
}
