package org.html.elements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.html.attributes.Render;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Setter
@Getter
@RequiredArgsConstructor
public abstract class Elements implements Render {
    private final List<Object> list = new ArrayList<>();
    private final String name;

    public abstract String toString();
    public void add(Object render) {
        list.add(render);
    }

    @Override
    public <T> String render(Class<T> klass, Object instance) {
        StringBuilder render = new StringBuilder("<");
        render.append(name);
        getElements((T) instance, klass, render);
        if (list.size() == 0) render.append("/>");
        else {
            render.append('>');
            list.forEach(render::append);
            render.append("</").append(name).append(">");
        }
        return render.toString();
    }

    private <T> void getElements(T instance, Class<T> klass, StringBuilder render) {
        Arrays.stream(klass.getMethods())
                .filter(v -> v.getParameterCount() == 0)
                .filter(v -> v.getDeclaringClass().equals(klass))
                .filter(v -> v.getName().startsWith("get") || v.getName().startsWith("is"))
                .forEach(v -> {
                    try {
                        Object value = v.invoke(instance);
                        if (value == null) return;
                        // 값이 존재하지 않으면 통과하기

                        String name = v.getName().startsWith("get")
                                ? v.getName().substring(3)
                                : v.getName().substring(2);
                        name = name.toLowerCase(Locale.ROOT);
                        if (name.equals("klass")) name = "class";

                        render.append(' ').append(name).append('=');
                        if (value instanceof String) render.append("\"").append(value).append("\"");
                        else render.append(value);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
