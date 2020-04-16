package com.alias.uploadcet.enums;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-16 22:16
 */
public enum CategoryLevelEnum {
    LEVEL1("一级菜单",1),LEVEL2("二级菜单",2);
    private String levelName;
    private Integer level;
    CategoryLevelEnum(String levelName,Integer level){
        this.levelName = levelName;
        this.level = level;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
