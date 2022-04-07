package com.yjh.service.impl;

import com.yjh.domain.ResponseResult;
import com.yjh.mapper.GarageKitManageMapper;
import com.yjh.pojo.GarageKit;
import com.yjh.service.GarageKitManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


@Service
public class GarageKitManageServiceImpl implements GarageKitManageService {
    @Autowired
    private GarageKitManageMapper garageKitManageMapper;

    @Override
    @PreAuthorize("hasAnyAuthority('sys:all')")
    public ResponseResult addGarageKit(GarageKit garageKit) {
        Integer integer = garageKitManageMapper.insertGarageKit(garageKit);
        if(integer==0){
            return new ResponseResult(500,"添加手办失败！！");
        }
        return new ResponseResult(200,"添加手办成功！");
    }

    @PreAuthorize("hasAnyAuthority('sys:all')")
    @Override
    public ResponseResult changeGarageKit(GarageKit garageKit,Long id) {
        garageKit.setId(id);
        Integer integer = garageKitManageMapper.updateGarageKit(garageKit);
        if(integer==0){
            return new ResponseResult(500,"更新手办失败！！");
        }
        return new ResponseResult(200,"更新手办成功！");
    }
    @PreAuthorize("hasAnyAuthority('sys:all')")
    @Override
    public ResponseResult deleteGarageKit(Long id) {
        Integer integer = garageKitManageMapper.deleteGarageKitById(id);
        if(integer==0){
            return new ResponseResult(500,"删除手办失败！！");
        }
        return new ResponseResult(200,"删除手办成功！");
    }
}


