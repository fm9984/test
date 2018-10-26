package com.test.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class EchoServerOutHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        String out = ((ByteBuf) msg).toString(CharsetUtil.UTF_8) + " out";
        super.write(ctx, Unpooled.copiedBuffer(out, CharsetUtil.UTF_8), promise);
    }
}
