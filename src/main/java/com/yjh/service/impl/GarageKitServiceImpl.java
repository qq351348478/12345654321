package com.yjh.service.impl;


import com.yjh.domain.ResponseResult;
import com.yjh.mapper.GarageKitMapper;
import com.yjh.pojo.DetailGarageKit;
import com.yjh.pojo.GarageKit;
import com.yjh.service.GarageKitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GarageKitServiceImpl implements GarageKitService {
    @Autowired
    GarageKitMapper garageKitMapper;

    @Override
    public ResponseResult displayAllGarageKit() {
        List<GarageKit> allGarageKit = garageKitMapper.findAllGarageKit();
        return new ResponseResult(200,allGarageKit);
    }

    @Override
    public ResponseResult displayDetailGarageKit(Long id) {
        GarageKit oneGarageKit = garageKitMapper.findOneGarageKit(id);
        List<String> allImgPath = garageKitMapper.findAllImgPathByGaragekitId(id);
        String text = garageKitMapper.findGarageKitTextByGaragekitId(id);
        DetailGarageKit detailGarageKit = new DetailGarageKit(oneGarageKit, text, allImgPath);
        return new ResponseResult(200,detailGarageKit);
    }

    @Override
    public ResponseResult SearchGarageKit(String msg) {
        List<GarageKit> list1 = garageKitMapper.fingdGarageKitBySearchGkrole(msg);
        List<GarageKit> list2 = garageKitMapper.fingdGarageKitBySearchGkName(msg);
        List<GarageKit> list3 = garageKitMapper.fingdGarageKitBySearchManufacturer(msg);
//        System.out.println(list1);
//        System.out.println(list2);
//        System.out.println(list3);
        Set<GarageKit> set = new HashSet<>();
        set.addAll(list1);
        set.addAll(list2);
        set.addAll(list3);
        System.out.println(set);
        return new ResponseResult(200,set);
    }


}
