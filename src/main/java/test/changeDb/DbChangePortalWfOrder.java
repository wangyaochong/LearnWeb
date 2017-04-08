package test.changeDb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import test.changeDb.entity.WfOrder;

import java.util.List;
import java.util.Map;

public class DbChangePortalWfOrder extends DbChange {
    @Test
    public void testChangePortal(){
        Map<String, Long> newDeptMap = getNewDeptMap();
        Map<String, Long> newProjectMap = getNewProjectMap();
        ClassPathXmlApplicationContext ctxNeedChange=new ClassPathXmlApplicationContext("classpath:hibernateNeedChange.xml");
        LocalSessionFactoryBean bean = ctxNeedChange.getBean(LocalSessionFactoryBean.class);
        SessionFactory originSessionFactory = bean.getObject();
        Session session = originSessionFactory.openSession();
        session.beginTransaction();
        List<WfOrder> list = session.createCriteria(WfOrder.class).list();
        for (WfOrder wfOrder : list) {
            String variable = wfOrder.getVariable();
            JSONObject jsonObject = JSON.parseObject(variable);
            jsonObject.put("departmentId",newDeptMap.get(jsonObject.getString("department")));
            jsonObject.put("projectId",newProjectMap.get(jsonObject.getString("projectName")));
            wfOrder.setVariable(jsonObject.toString());
//            System.out.println(jsonObject.toString());
//            wfOrder.setVariable(jsonObject.toString());
        }
        System.out.println("开始修改");
        System.out.println("修改完成");
        session.getTransaction().commit();
        session.close();
        System.out.println("总大小"+list.size());
        System.out.println("sessionFactory");
    }
}
