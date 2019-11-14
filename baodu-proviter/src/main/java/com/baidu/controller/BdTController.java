package com.baidu.controller;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.baidu.BdService;
import com.baidu.model.User;
import com.baidu.service.BdTService;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */
@RestController
public class BdTController implements BdService {
    @Resource
    private BdTService bdTService;

    @RequestMapping("getUList")
    @Override
    public List<User> getUList(@SpringQueryMap  User user) {
        return bdTService.getUList(user);
    }

    @GetMapping("getUserMap")
    @Override
    public Map getUserMap(@SpringQueryMap User user, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {
       System.out.println(user+"proviter");
        return bdTService.getUserMap(user,page,rows);
    }

    @GetMapping("selectUserById")
    @Override
    public User selectUserById(@RequestParam("id") Integer id) {
        return bdTService.selectUserById(id);
    }


    @GetMapping("delUser")
    @Override
    public void delUser(@RequestParam("ids") String ids) {
        bdTService.delUser(ids);
    }

    @GetMapping("addUser")
    @Override
    public void addUser(@SpringQueryMap User user) {
        bdTService.addUser(user);
    }

    @GetMapping("updateU")
    @Override
    public void updateU(@SpringQueryMap User user) {
        bdTService.updateU(user);
    }


}
