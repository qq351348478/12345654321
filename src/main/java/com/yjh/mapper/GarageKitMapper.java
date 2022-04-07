package com.yjh.mapper;

import com.yjh.pojo.GarageKit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface GarageKitMapper {

    @Select("select * from garage_kit")
    List<GarageKit> findAllGarageKit();

    //    @Insert("insert into garage_kit values (null,#{gkname,#{date},#{role},#{price},#{num},#{manufacturer},#{scale},#{material},#{rule},#{publish},#{text},#{profilePhotoPath},#{imgPath},#{createTime},#{createBy})")
//    Integer insertGarageKit(GarageKit garageKit);
    @Select("select * from garage_kit where id = #{id}")
    GarageKit findOneGarageKit(Long id);

    @Select("select * from garage_kit where gk_name like concat('%',#{gkname},'%')")
    List<GarageKit> fingdGarageKitBySearchGkName(String gkname);
    @Select("select * from garage_kit where role like concat('%',#{role},'%')")
    List<GarageKit> fingdGarageKitBySearchGkrole(String role);
    @Select("select * from garage_kit where manufacturer like concat('%',#{manufacturer},'%')")
    List<GarageKit> fingdGarageKitBySearchManufacturer(String manufacturer);

    //   图片路径处理相关
//    @Select("select path from img_path where garage_kit_id = #{id} limit 1")
//    String findOneImgPathByGaragekitId(Integer id);
    @Select("select path from garage_kit_path where garage_kit_id = #{id}")
    List<String> findAllImgPathByGaragekitId(Long id);
    @Select("select path from garage_kit_text where garage_kit_id = #{id}")
    String findGarageKitTextByGaragekitId(Long id);
}
