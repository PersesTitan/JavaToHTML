package org.html.tag.basic;

import org.html.elements.Elements;

public class Body extends Elements {
    public Body() {
        super("body");
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
