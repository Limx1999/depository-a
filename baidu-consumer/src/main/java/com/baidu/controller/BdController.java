package com.baidu.controller;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.baidu.BdService;
import com.baidu.model.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;


/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */
@RestController
public class BdController {

    @Resource
    private BdService bdService;

    @RequestMapping("getUList")
    public List<User> getUList(User user,HttpServletResponse response) throws IOException {
        if(user==null){
            user =new User();
            user.setUname("Mr_Li 加油");
        }
         List<User> list=  bdService.getUList(user);
        return list;
    }


    @GetMapping("getUserMap")
    public Map getUserMap(User user,Integer page,Integer rows,HttpServletResponse response) throws IOException {
        Map<String, Object> map =  bdService.getUserMap(user,page,rows);
        if(map==null){
            System.out.println("NIhao");
            //* 设置格式为text/json *//*
            response.setContentType("text/json");
            //* 设置字符集为'UTF-8' *//*
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("网络异常！！！");
            printWriter.flush();
            printWriter.close();
        }
        return map;
    }

    @GetMapping("selectUserById")
    public User selectUserById(Integer id){
        return bdService.selectUserById(id);
    }

    @GetMapping("delUsers")
    public void delUser(String ids){
        bdService.delUser(ids);
    }

    @GetMapping("addUser")
    public void addUser(User user){
        bdService.addUser(user);
    }

    @GetMapping("updateU")
    public void updateU(User user){
        bdService.updateU(user);
    }



}
