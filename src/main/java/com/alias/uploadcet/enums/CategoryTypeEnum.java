package com.alias.uploadcet.enums;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-16 22:16
 */
public enum CategoryTypeEnum {
    TYPE_NORMAL("普通菜单",1),TYPE_DISPLAY("展示菜单",2);
    private String typeName;
    private Integer type;
    CategoryTypeEnum(String typeName, Integer type){
        this.typeName = typeName;
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
