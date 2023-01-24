package org.html.attributes;

public interface Render {
    String render();
    <T> String render(Class<T> klass, Object instance);
}
