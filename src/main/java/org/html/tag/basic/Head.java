package org.html.tag.basic;

import org.html.elements.Elements;

public class Head extends Elements {
    public Head() {
        super("head");
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
