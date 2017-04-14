package test.changeDb;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.List;
import java.util.Map;

public class DbChangeAliyunOmsEntity extends DbChange {
    @Test
    public void testDbChangeAliyunOmsEntity(){
        Map<String, Long> newDeptMap = getNewDeptMap();
        ClassPathXmlApplicationContext ctxNeedChange=new ClassPathXmlApplicationContext("classpath:hibernateNeedChange.xml");
        LocalSessionFactoryBean bean = ctxNeedChange.getBean(LocalSessionFactoryBean.class);
        SessionFactory originSessionFactory = bean.getObject();
        Session session = originSessionFactory.openSession();
        session.beginTransaction();

        List<DepartmentEntity> list1 = session.createCriteria(DepartmentEntity.class).list();
        int count=0;
        for (DepartmentEntity departmentEntity : list1) {
            SQLQuery sqlQuery = session.createSQLQuery("update aliyunomsentity set department=:deptnew where department=:deptold");
            sqlQuery.setParameter("deptold",(departmentEntity.getId()*1000));
            sqlQuery.setParameter("deptnew",newDeptMap.get(departmentEntity.getLabel()));
             count += sqlQuery.executeUpdate();
        }

//        List<AliyunOmsEntity> list = session.createCriteria(AliyunOmsEntity.class).list();
//        System.out.println("开始修改");
//        for (AliyunOmsEntity aliyunOmsOverviewEntity : list) {
//            Long deptId = aliyunOmsOverviewEntity.getDepartment();
//            if(deptId!=null){
//                DepartmentEntity deptById = getDeptById(deptId, originSessionFactory);
//                Long aLong = newDeptMap.get(deptById.getLabel());
//                aliyunOmsOverviewEntity.setDepartment(aLong);
////                System.out.println(deptById);
////                System.out.println("已修改："+(++count));
//            }
//        }
        System.out.println("修改完成");
        session.getTransaction().commit();
        session.close();
        System.out.println("总大小"+count);
        System.out.println("sessionFactory");

    }

}
