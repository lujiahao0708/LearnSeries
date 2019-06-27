package com.lujiahao.netty.websocketdemo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDate;

/**
 * TextWebSocketFrame : 处理消息的handler,在netty中用于处理文本的对象,frames是消息的载体
 * @author lujiahao
 * @date 2019-05-06 13:54
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    // 用于记录和管理所有客户端的channel,可以吧相应的channel保存到一整个组中
    private static ChannelGroup channelClient = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext context, TextWebSocketFrame textWebSocketFrame) throws Exception {
        // 获取从客户端发送过来的字符串
        String content = textWebSocketFrame.text();
        System.out.println("客户端传来的数据:" + content);

        // 发送消息方式一
        channelClient.forEach((Channel channel) -> channel.writeAndFlush(
                new TextWebSocketFrame("[服务器于" + LocalDate.now() + "接受到消息][消息内容:" + content + "]")
        ));

        // 发送消息方式二
        //channelClient.writeAndFlush(new TextWebSocketFrame("[服务器于" + LocalDate.now() + "接受到消息][消息内容:" + content + "]"));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 获取客户端所对应的channel,添加到管理容器中
        channelClient.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 实际上这一行代码是多余的,只要handler移除,client会自动的把对应的channel移除
        channelClient.remove(ctx.channel());
        // 每一个channel都会有一个长id和短id
        // 一开始channel就有了，系统会自动分配一串很长的字符串作为唯一的ID，如果使用asLongText()获取的ID是唯一的，
        // asShortText()会把当前ID进行精简，精简过后可能会有重复
        System.out.println("channel的长ID:" + ctx.channel().id().asLongText());
        System.out.println("channel的短ID:" + ctx.channel().id().asShortText());
    }
}
