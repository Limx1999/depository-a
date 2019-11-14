package com.baidu.service;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.baidu.dao.BdTDao;
import com.baidu.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */
@Service
public class BdTServiceImpl implements  BdTService{
    @Resource
    private BdTDao bdTDao;

    @Override
    public List<User> getUList(User user) {
        System.out.println(user);
        return bdTDao.getUList();
    }

    @Override
    public Map getUserMap(User user, Integer page, Integer rows) {
       Map<String, Object> parameMap =  new HashMap<String, Object>();
       Map<String, Object> resultMap =  new HashMap<String, Object>();
       parameMap.put("u",user);
       Integer listTotal = bdTDao.selectTotal(parameMap);
       Integer beginNum = (page-1)*rows;
       Integer endNum = page*rows;
        parameMap.put("beginNum",beginNum);
        parameMap.put("endNum",endNum);
        List<User> list = bdTDao.selectUserList(parameMap);
        resultMap.put("rows",list);
        resultMap.put("total",listTotal);
        return resultMap;
    }

    @Override
    public User selectUserById(Integer id) {
        return bdTDao.selectUserById(id);
    }

    @Override
    public void delUser(String ids) {
        String[] idarr = ids.split(",");
        bdTDao.delUsers(idarr);
    }

    @Override
    public void addUser(User user) {
        bdTDao.addUser(user);
    }

    @Override
    public void updateU(User user) {
        bdTDao.updateU(user);
    }
}
