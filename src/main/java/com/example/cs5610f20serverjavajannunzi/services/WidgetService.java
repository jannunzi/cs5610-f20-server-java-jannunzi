package com.example.cs5610f20serverjavajannunzi.services;

import com.example.cs5610f20serverjavajannunzi.models.Widget;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WidgetService {
    List<Widget> widgets = new ArrayList<Widget>();
    {
        widgets.add(new Widget("123", "Widget 123", "HEADING", "topic123"));
        widgets.add(new Widget("234", "Widget 234", "PARAGRAPH", "topic123"));
        widgets.add(new Widget("345", "Widget 345", "HEADING", "topic234"));
    }

    public List<Widget> findWidgetsForTopic(String tid) {
        List<Widget> ws = new ArrayList<Widget>();
        for(Widget w: widgets) {
            if(w.getTopicId().equals(tid)) {
                ws.add(w);
            }
        }
        return ws;
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
