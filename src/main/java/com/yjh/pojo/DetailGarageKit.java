package com.yjh.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailGarageKit {
    private GarageKit garageKit;
    private String text;
    private List<String> imgPath;

}
