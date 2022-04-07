package com.yjh.mapper;


import com.yjh.pojo.GarageKit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GarageKitManageMapper {

    @Insert("insert into garage_kit values (null,#{gkname},#{reserveDate},#{saleDate},#{role},#{price},#{num},#{manufacturer},#{scale},#{material},#{rule},#{publish},#{profilePhotoPath},#{createTime},#{createBy},#{updateTime},#{updateBy})")
    Integer insertGarageKit(GarageKit garageKit);


    /**
     *
     * @param id 手办的id
     * @return
     */
    @Delete("delete garage_kit where id = #{id}")
    Integer deleteGarageKitById(Long id);

    /**
     *
     * @param garageKit 要修改的属性不为null，若要其属性为空可用"无"代替！
     * @return
     */
    Integer updateGarageKit(GarageKit garageKit);
}
