package com.baidu;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.baidu.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */
@Component
public class BdServiceError implements  BdService{
    public List<User> getUList(User user) {

        return null;
    }

    public Map getUserMap(User user, Integer page, Integer rows) {
        System.out.println("查询出错了");
        return null;
    }

    public User selectUserById(Integer id) {
        return null;
    }

    public void delUser(String ids) {

    }

    public void addUser(User user) {

    }

    public void updateU(User user) {

    }
}
