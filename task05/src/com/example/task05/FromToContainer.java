package com.example.task05;

public class FromToContainer<T> {

    protected final String from;
    protected final String to;
    protected final T content;

    public FromToContainer(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() { return this.from; }
    public String getTo() { return this.to; }
    public T getContent() { return this.content; }


}