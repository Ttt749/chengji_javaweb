package main.snnu.enums;

/**
 * Created by WT on 2017/11/30.
 */
public enum  StatusEnum {

    LOGIN_SUCCESS("登录成功"),
    LOGIN_FAIL("登录失败"),
    CHECK_SUCCESS("查询成功"),
    CHECK_ERROR("查询失败"),
    INSERT_SUCCESS("添加成功"),
    INSERT_ERROR("添加失败"),
    DETELE_SUCCESS("删除成功"),
    DETELE_ERROR("删除失败"),
    UPDATE_SUCCESS("更新成功"),
    UPDATE_ERROR("更新失败"),
    EXPORT_SUCCESS("导出成功"),
    EXPORT_ERROR("导出失败"),
    IMPORT_SUCCESS("导入成功"),
    IMPORT_ERROR("导入失败"),
    BACKUP_ERROR("备份失败"),
    BACKUP_SUCCESS("备份成功");

    private String stateInfo;


    StatusEnum(String stateInfo){
        this.stateInfo = stateInfo;
    }

    public String getStateInfo() {
        return stateInfo;
    }

}
