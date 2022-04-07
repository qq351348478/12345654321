package com.yjh.controller;


import com.yjh.domain.ResponseResult;
import com.yjh.pojo.GarageKit;
import com.yjh.service.GarageKitManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manage/garageKit")
public class GarageKitManageController {
    @Autowired
    private GarageKitManageService garageKitManageService;

    @PreAuthorize("hasAnyAuthority('sys:all')")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseResult delete( @PathVariable("id") Long id){
        return garageKitManageService.deleteGarageKit(id);
    }
    @PreAuthorize("hasAnyAuthority('sys:all')")
    @RequestMapping(value = "/change/{id}",method = RequestMethod.PUT)
    public ResponseResult change( @RequestBody GarageKit garageKit,@PathVariable("id")Long id){
        return garageKitManageService.changeGarageKit(garageKit,id);
    }
    @PreAuthorize("hasAnyAuthority('sys:all')")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseResult add( @RequestBody GarageKit garageKit){
        return garageKitManageService.addGarageKit(garageKit);
    }

}
