package com.lujiahao.netty.websocketdemo;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author lujiahao
 * @date 2019-05-06 13:22
 */
public class WebSocketInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 从channel中获取对应的pipeline
        ChannelPipeline pipeline = channel.pipeline();

        //添加相应的助手类与处理器
        /**
         * WebSokect基于Http，所以要有相应的Http编解码器，HttpServerCodec()
         */
        pipeline.addLast(new HttpServerCodec());

        // 在http中有一些数据流的传输,此助手类是为了支持大数据流处理
        pipeline.addLast(new ChunkedWriteHandler());

        // HttpObjectAggregator:聚合器  聚合了FullHTTPRequest FullHTTPResponse
        pipeline.addLast(new HttpObjectAggregator(2048 * 64));

        // ============以上为http协议

        // ============以上为websocket协议
        // /ws：一开始建立连接的时候会使用到，可自定义
        //WebSocketServerProtocolHandler：给客户端指定访问的路由（/ws），是服务器端处理的协议，
        // 当前的处理器处理一些繁重的复杂的东西，运行在一个WebSocket服务端
        //另外也会管理一些握手的动作：handshaking(close，ping，pong) ping + pong = 心跳，
        // 对于WebSocket来讲，是以frames进行传输的，不同的数据类型对应的frames也不同
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        // 添加自定义handler 读取客户端消息并进行处理
        pipeline.addLast(new ChatHandler());
    }
}
