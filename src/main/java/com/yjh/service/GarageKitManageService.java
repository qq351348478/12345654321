package com.yjh.service;

import com.yjh.domain.ResponseResult;
import com.yjh.pojo.GarageKit;

public interface GarageKitManageService {
    ResponseResult addGarageKit(GarageKit garageKit);

    ResponseResult changeGarageKit(GarageKit garageKit,Long id);

    /**
     *
     * @param id æåçid
     * @return
     */
    ResponseResult deleteGarageKit(Long id);
}
