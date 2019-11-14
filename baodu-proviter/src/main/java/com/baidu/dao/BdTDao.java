package com.baidu.dao;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.baidu.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */
@Mapper
public interface BdTDao {
     List<User> getUList();

     Integer selectTotal(Map<String, Object> parameMap);

     List<User> selectUserList(Map<String, Object> parameMap);

    User selectUserById(Integer id);

    void delUsers(String[] idarr);

    void addUser(User user);

    void updateU(User user);
}
