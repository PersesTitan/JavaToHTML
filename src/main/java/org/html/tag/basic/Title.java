package org.html.tag.basic;

import org.html.elements.Elements;

public class Title extends Elements {
    public Title() {
        super("title");
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
