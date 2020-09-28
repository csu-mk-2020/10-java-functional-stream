package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<FromTo<T>> {

    private final Map<String, List<T>> mailBox = new MessageMap<>();

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(FromTo<T> tFromTo) {
        List<T> list = mailBox.computeIfAbsent(tFromTo.getTo(), key -> new ArrayList<>());
        list.add(tFromTo.getContent());
    }
}
