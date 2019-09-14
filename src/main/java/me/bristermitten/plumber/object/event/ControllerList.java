package me.bristermitten.plumber.object.event;

import java.util.ArrayList;

public class ControllerList extends ArrayList<EventController<?>> {

    @Override
    public boolean remove(Object o) {
        boolean value = super.remove(o);
        if (o instanceof EventController) {
            ((EventController<?>) o).unRegister();
        }
        return value;
    }
}
