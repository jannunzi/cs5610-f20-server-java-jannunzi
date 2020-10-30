package com.example.cs5610f20serverjavajannunzi.services;

import com.example.cs5610f20serverjavajannunzi.models.Widget;
import com.example.cs5610f20serverjavajannunzi.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository widgetRepository;

    public List<Widget> findWidgetsForTopic(String tid) {
        return widgetRepository.findWidgetsForTopic(tid);
//        List<Widget> ws = new ArrayList<Widget>();
//        for(Widget w: widgets) {
//            if(w.getTopicId().equals(tid)) {
//                ws.add(w);
//            }
//        }
//        return ws;
    }
    public List<Widget> findAllWidgets() {
        return (List<Widget>) widgetRepository.findAll();
    }
    public Widget findWidgetById(Integer widgetId) {
        return widgetRepository.findById(widgetId).get();
//        for(Widget w: widgets) {
//            if(w.getId().equals(widgetId))
//                return w;
//        }
//        return null;
    }
    public Widget createWidget(Widget widget) {
        return widgetRepository.save(widget);
//        widget.setId(123);
//        widgets.add(widget);
//        return widget;
    }
    public void deleteWidget(Integer wid) {
        widgetRepository.deleteById(wid);
    }
    public Widget updateWidget(
            Integer widgetId,
            Widget newWidget) {
        Optional widgetO = widgetRepository.findById(widgetId);
        if(widgetO.isPresent()) {
            Widget widget = (Widget) widgetO.get();
            widget.setName(newWidget.getName());
            widget.setType(newWidget.getType());
            return widgetRepository.save(widget);
        } else {
            return null;
        }
//        for(Widget w: widgets) {
//            if(w.getId().equals(widgetId)) {
//                w.setName(newWidget.getName());
//                w.setType(newWidget.getType());
//                return 1;
//            }
//        }
//        return 0;
    }
}
