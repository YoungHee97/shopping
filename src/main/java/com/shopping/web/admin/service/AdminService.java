package com.shopping.web.admin.service;

import com.shopping.web.member.form.MemberForm;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    public SXSSFWorkbook makeExhibitorExcelWorkbook(List<MemberForm> list) {
        SXSSFWorkbook workbook = new SXSSFWorkbook();

        // 시트 생성
        SXSSFSheet sheet = workbook.createSheet("회원 목록");

        //시트 열 너비 설정
        sheet.setColumnWidth(0, 5000);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 5000);
        sheet.setColumnWidth(3, 5000);

        // 헤더 행 생
        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("아이디");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("닉네임");

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("이메일");

        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("비밀번호");

        Row bodyRow = null;
        Cell bodyCell = null;
        for(int i=0; i<list.size(); i++) {
            MemberForm member = list.get(i);

            // 행 생성
            bodyRow = sheet.createRow(i+1);

            bodyCell = bodyRow.createCell(0);
            bodyCell.setCellValue(member.getMember_id());

            bodyCell = bodyRow.createCell(1);
            bodyCell.setCellValue(member.getMember_nick());

            bodyCell = bodyRow.createCell(2);
            bodyCell.setCellValue(member.getMember_email());

            bodyCell = bodyRow.createCell(3);
            bodyCell.setCellValue(member.getMember_password());
        }

        return workbook;
    }

    public SXSSFWorkbook excelFileDownloadProcess(List<MemberForm> list) {
        return this.makeExhibitorExcelWorkbook(list);
    }

    public List<MemberForm> uploadExcelFile(MultipartFile excelFile) {
        List<MemberForm> list = new ArrayList<MemberForm>();
        try {
            OPCPackage opcPackage = OPCPackage.open(excelFile.getInputStream());
            XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);

            // 첫번째 시트 불러오기
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
                MemberForm member = new MemberForm();
                XSSFRow row = sheet.getRow(i);

                // 행이 존재하기 않으면 종료
                if (null == row) {
                    break;
                }

                XSSFCell cell = row.getCell(0);
                if (null == cell || cell.getStringCellValue().equals("")) break;
                else member.setMember_nick(cell.getStringCellValue());
                cell = row.getCell(1);
                if (null == cell || cell.getStringCellValue().equals("")) break;
                else member.setMember_email(cell.getStringCellValue());
                cell = row.getCell(2);
                if (null == cell || cell.getStringCellValue().equals("")) break;
                else member.setMember_password(cell.getStringCellValue());

                list.add(member);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
