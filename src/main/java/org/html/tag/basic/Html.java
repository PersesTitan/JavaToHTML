package org.html.tag.basic;

import lombok.Getter;
import lombok.Setter;
import org.html.elements.Elements;

@Getter
@Setter
public class Html extends Elements {
    private String lang;

    public Html() {
        super("html");
    }

    @Override
    public String render() {
        return super.render(this.getClass(), this);
    }

    @Override
    public String toString() {
        return this.render();
    }
}
