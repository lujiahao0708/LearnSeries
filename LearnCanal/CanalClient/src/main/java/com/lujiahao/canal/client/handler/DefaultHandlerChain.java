package com.lujiahao.canal.client.handler;

import com.google.common.collect.Lists;
import com.lujiahao.canal.client.domain.bo.CanalEntryBO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 默认责任链
 * @author lujiahao
 * @date 2018/10/20
 */
@Component
public class DefaultHandlerChain implements HandlerChain {

    private List<Handler> handlers = Lists.newArrayList();

    @Override
    public void handle(CanalEntryBO canalEntryBO) {
        List<Handler> handlers = this.handlers;
        if (handlers.isEmpty()) {
            return;
        }

        for (Handler handler : handlers) {
            try {
                if (handler.beforeHandle(canalEntryBO)) {
                    handler.handle(canalEntryBO);
                }
            } finally {
                handler.afterComplete(canalEntryBO);
            }
        }
    }

    @Override
    public void addHandler(Handler handler) {
        handlers.add(handler);
    }
}
