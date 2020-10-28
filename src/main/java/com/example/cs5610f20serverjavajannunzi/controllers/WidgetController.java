package com.example.cs5610f20serverjavajannunzi.controllers;

import com.example.cs5610f20serverjavajannunzi.models.Widget;
import com.example.cs5610f20serverjavajannunzi.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    WidgetService service = new WidgetService();

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!!";
    }

    @GetMapping("/api/topics/{topicId}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("topicId") String topicId) {
        return service.findWidgetsForTopic(topicId);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }
    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(
            @PathVariable("wid") String widgetId) {
        return service.findWidgetById(widgetId);
    }
    @PostMapping("/api/widgets")
    public Widget createWidget(
            @RequestBody Widget widget) {
        return service.createWidget(widget);
    }
    @PutMapping("/api/widgets/{wid}")
    public Integer updateWidget(
            @PathVariable("wid") String widgetId,
            @RequestBody Widget newWidget) {
        return service.updateWidget(widgetId, newWidget);
    }
    // TODO: updateWidget, deleteWidget
}
