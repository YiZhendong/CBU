package com.dong.cbu.commom;

import java.util.List;

/**
 * Created by zhendong on 2016/4/25.
 * email:myyizhendong@gmail.com
 *
 */
public class Response {
    protected int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    protected Object body;

    public Response() {}

    public Response(int status){
        this.status = status;
    }
    public Response(int status,Object body){
        this.status = status;
        this.body = body;
    }
    public Response(int status, List<Object> body){
        this.status = status;
        this.body = body;
    }


}
