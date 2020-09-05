
package com.shopping.web.admin.controller;

import com.shopping.web.admin.service.AdminService;
import com.shopping.web.member.form.MemberForm;
import com.shopping.web.member.form.MemberForm;
import com.shopping.web.member.service.MemberService;
import com.shopping.web.member.service.MemberService;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    MemberService memberService;

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/getMemberList")
    @ResponseBody
    public List<MemberForm> getMemberList(HttpServletRequest request, HttpServletResponse response, MemberForm memberForm) throws Exception {
        List<MemberForm> list = memberService.getMemberList(memberForm);
        return list;
    }

    @RequestMapping(value="/memberList", method = RequestMethod.GET)
    public String getMemberListPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/admin/memberList";
    }

    @RequestMapping(value = "/downloadExcelFile", method = RequestMethod.POST)
    public String downloadExcelFile(Model model) throws Exception {
        MemberForm memberForm = new MemberForm();
        List<MemberForm> list = memberService.getMemberList(memberForm);

        SXSSFWorkbook workbook = adminService.excelFileDownloadProcess(list);

        model.addAttribute("locale", Locale.KOREA);
        model.addAttribute("workbook", workbook);
        model.addAttribute("workbookName", "회원 목록");

        return "excelDownloadView";
    }

    @RequestMapping(value = "/uploadExcelFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadExcelFile(MultipartHttpServletRequest request) throws Exception {
        MultipartFile file = null;
        Iterator<String> iterator = request.getFileNames();
        if(iterator.hasNext()) {
            file = request.getFile(iterator.next());
        }
        List<MemberForm> list = adminService.uploadExcelFile(file);

        memberService.insertMemberAsList(list);

        return "/admin/memberList";
    }


}

