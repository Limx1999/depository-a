package com.baidu;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.baidu.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */


@FeignClient(value = "baidu-proviter",fallback = BdServiceError.class)
public interface BdService {


    @RequestMapping("getUList")
    List<User> getUList(@SpringQueryMap User user);

    @GetMapping("getUserMap")
    Map getUserMap( @SpringQueryMap User user, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows);

    @GetMapping("selectUserById")
    User selectUserById(@RequestParam("id") Integer id);

    @GetMapping("delUser")
    void delUser(@RequestParam("ids") String ids);

    @GetMapping("addUser")
    void addUser(@SpringQueryMap User user);

    @GetMapping("updateU")
    void updateU(@SpringQueryMap User user);
}
