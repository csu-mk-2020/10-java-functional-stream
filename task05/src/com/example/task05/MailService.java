package com.example.task05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<FromToContainer<T>> {
    private final Map<String, List<T>> mailBox = new MessageMap<>();

    public Map<String, List<T>> getMailBox() {
        return this.mailBox;
    }

    @Override
    public void accept(FromToContainer<T> container) {
        List<T> list = mailBox.computeIfAbsent(container.getTo(), key -> new ArrayList<>());
        list.add(container.getContent());
    }
}