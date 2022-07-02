package com.springrest.Forth.VO;

import com.springrest.Forth.entity.User;

public class ResponseTemplateVO {
    private User u;

    public ResponseTemplateVO() {
    }

    public ResponseTemplateVO(User u) {
        this.u = u;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
}
