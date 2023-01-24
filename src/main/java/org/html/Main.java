package org.html;

import org.html.tag.basic.Head;
import org.html.tag.basic.Html;
import org.html.tag.basic.Meta;
import org.html.tag.basic.Title;

public class Main {
    public static void main(String[] args) {
        Html html = new Html();
        html.setLang("ko");

        Head head = new Head();

        Meta meta = new Meta();
        meta.setCharset("UTF-8");
        head.add(meta);

        Title title = new Title();
        title.add("Title");
        head.add(title);

        html.add(head);

        System.out.println(html.render());
    }
}