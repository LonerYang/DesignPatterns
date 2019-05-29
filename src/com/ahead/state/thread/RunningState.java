package com.ahead.state.thread;

public class RunningState extends ThreadState_ {
    private Thread_ t;

    public RunningState(Thread_ t) {
        this.t = t;
    }

    @Override
    void move(Action input) {
        if (input.msg.equals("terminated")) {
            t.state = new TerminatedState(t);
        }
    }

    @Override
    void run() {

    }
}
