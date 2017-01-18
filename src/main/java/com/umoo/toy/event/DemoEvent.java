package com.umoo.toy.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Administrator on 2017/1/18.
 */
public class DemoEvent extends ApplicationEvent {
    private static final long serialVersionUID = 4637603246749273995L;
    private String msg;
    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
