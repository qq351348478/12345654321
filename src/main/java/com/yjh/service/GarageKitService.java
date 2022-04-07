package com.yjh.service;

import com.yjh.domain.ResponseResult;

public interface GarageKitService {

    ResponseResult displayAllGarageKit();

    ResponseResult displayDetailGarageKit(Long id);

    ResponseResult SearchGarageKit(String msg);

}
