package com.example.demo.controller;

import com.example.demo.bean.SystemHardwareInfo;
import com.example.demo.bean.User;
import com.example.demo.util.ExcelUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/system")
public class test {


    @RequestMapping("/systemInfo")
    @ResponseBody
    public SystemHardwareInfo systemInfo(Model model) {

        SystemHardwareInfo s = new SystemHardwareInfo();
        s.copyTo();
        System.out.println(s);
        model.addAttribute("server", s);

        return s;
    }

    @RequestMapping("/excl")
    @ResponseBody
    public void excl(HttpServletRequest request, HttpServletResponse response) {
        User user = null;
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            user = new User();
            user.setUsername("xkz");
            user.setAge(i);
            list.add(user);
        }
        String[] title = {"姓名", "年龄"};

        String[][] content = new String[list.size()][title.length];
        int i =0;
        for (Object o : list) {
            content[i][0] = String.valueOf(user.getUsername());
            content[i][1] = String.valueOf(user.getAge());
            i++;
        }
        ExcelUtil.sendExcel(content, response, title);
    }

}
