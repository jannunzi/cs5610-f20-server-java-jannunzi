package com.example.cs5610f20serverjavajannunzi.services;

import com.example.cs5610f20serverjavajannunzi.models.Widget;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WidgetService {
    List<Widget> widgets = new ArrayList<Widget>();
    {
        widgets.add(new Widget("123", "Widget 123", "HEADING"));
        widgets.add(new Widget("234", "Widget 234", "PARAGRAPH"));
        widgets.add(new Widget("345", "Widget 345", "HEADING"));
    }

    public List<Widget> findAllWidgets() {
        return widgets;
    }
    public Widget findWidgetById(String widgetId) {
        for(Widget w: widgets) {
            if(w.getId().equals(widgetId))
                return w;
        }
        return null;
    }
    public Widget createWidget(Widget widget) {
        widget.setId((new Date()).toString());
        widgets.add(widget);
        return widget;
    }
    public Integer updateWidget(
            String widgetId,
            Widget newWidget) {
        for(Widget w: widgets) {
            if(w.getId().equals(widgetId)) {
                w.setName(newWidget.getName());
                w.setType(newWidget.getType());
                return 1;
            }
        }
        return 0;
    }
}
