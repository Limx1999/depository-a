package com.baidu.service;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.baidu.model.User;

import java.util.List;
import java.util.Map;

/** <pre>queryL(这里用一句话描述这个方法的作用)   
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */
public interface BdTService {
    List<User> getUList(User user);

    Map getUserMap(User user, Integer page, Integer rows);

    User selectUserById(Integer id);

    void delUser(String ids);

    void addUser(User user);

    void updateU(User user);
}
