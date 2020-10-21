package com.example.cs5610f20serverjavajannunzi.controllers;

import com.example.cs5610f20serverjavajannunzi.models.Widget;
import org.springframework.web.bind.annotation.*;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class WidgetController {
    List<Widget> widgets = new ArrayList<Widget>();
    {
        widgets.add(new Widget("123", "Widget 1", "YOU_TUBE"));
        widgets.add(new Widget("234", "Widget 2", "IMAGE"));
        widgets.add(new Widget("345", "Widget 3", "HTML"));
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!!";
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return widgets;
    }
    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(
            @PathVariable("wid") String widgetId) {
        for(Widget w: widgets) {
            if(w.getId().equals(widgetId))
                return w;
        }
        return null;
    }
    @PostMapping("/api/widgets")
    public Widget createWidget(
            @RequestBody Widget widget) {
        widget.setId((new Date()).toString());
        widgets.add(widget);
        return widget;
    }
    @PutMapping("/api/widgets/{wid}")
    public Integer updateWidget(
            @PathVariable("wid") String widgetId,
            @RequestBody Widget newWidget) {
        for(Widget w: widgets) {
            if(w.getId().equals(widgetId)) {
                w.setName(newWidget.getName());
                w.setType(newWidget.getType());
                return 1;
            }
        }
        return 0;
    }
    // TODO: updateWidget, deleteWidget
}
