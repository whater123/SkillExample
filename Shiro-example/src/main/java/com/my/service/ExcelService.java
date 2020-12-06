package com.my.service;

import com.my.dao.UserMapper;
import com.my.pojo.User;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author w
 */
@Service
public class ExcelService {
    @Autowired
    UserMapper userMapper;

    public XSSFWorkbook show() {
        List<User> list = userMapper.selectList(null);//查出数据库数据
        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Goods");//创建一张表
        Row titleRow = sheet.createRow(0);//创建第一行，起始为0
        titleRow.createCell(0).setCellValue("序号");//第一列
        titleRow.createCell(1).setCellValue("用户名");
        titleRow.createCell(2).setCellValue("密码");
        titleRow.createCell(3).setCellValue("权限");
        int cell = 1;
        for (User goods : list) {
            Row row = sheet.createRow(cell);//从第二行开始保存数据
            row.createCell(0).setCellValue(goods.getId());
            row.createCell(1).setCellValue(goods.getUserName());//将数据库的数据遍历出来
            row.createCell(2).setCellValue(goods.getPassword());
            row.createCell(3).setCellValue(goods.getRole());
            cell++;
        }
        return wb;
    }
}
