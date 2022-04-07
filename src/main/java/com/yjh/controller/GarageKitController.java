package com.yjh.controller;


import com.yjh.domain.ResponseResult;
import com.yjh.service.GarageKitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.resources.MsgAppletViewer;

@RestController
public class GarageKitController {
    @Autowired
    private GarageKitService garageKitService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ResponseResult index(){
        return garageKitService.displayAllGarageKit();
    }
    @RequestMapping(value = "/index/garageKit/{id}",method = RequestMethod.GET)
    public ResponseResult detailGarageKit(@PathVariable("id")Long id){
        return garageKitService.displayDetailGarageKit(id);
    }
    @RequestMapping(value = "/index/garageKit/search/{msg}",method = RequestMethod.GET)
    public ResponseResult detailGarageKit(@PathVariable("msg")String msg){
        return garageKitService.SearchGarageKit(msg);
    }
}
