package com.yileone.learnjava.easyexcel;

import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author: jinyuan
 * @since: 2019/12/13 17:14
 */
public class EasyExcelTest {

    /*@Test
    public void EasyExcelTest() {
        String filePath = "/home/chenmingjian/Downloads/学生表.xlsx";
        List<Object> objects = ExcelUtil.readLessThan1000Row(filePath);
    }

    *//**
     * 最简单的读
     * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>2. 由于默认异步读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
     * <p>3. 直接读即可
     *//*
    @Test
    public void simpleRead() {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
    }*/
}
