package test.changeDb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import test.changeDb.entity.ProjectEntity;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DbChange {
    public List<DepartmentEntity> getAllDepartMent(SessionFactory sessionFactory){
        Session session=null;
        try{
            session = sessionFactory.openSession();
            Query query = session.createQuery("from test.changeDb.DepartmentEntity");
            return query.list();
        }finally {
            session.close();
        }
    }
//    public  DepartmentEntity getDeptByLabel(String lable, SessionFactory sessionFactory){
//        Session session=null;
//        try{
//            session = sessionFactory.openSession();
//            Query query = session.createQuery("from test.changeDb.DepartmentEntity dept where dept.label=:label");
//            query.setParameter("label",lable);
//            return (DepartmentEntity) query.list().get(0);
//        }finally {
//            session.close();
//        }
//    }

    public ProjectEntity getProjectById(Long projectId,SessionFactory sessionFactory){
        Session session=null;
        try{
            session = sessionFactory.openSession();
            Query query = session.createQuery("from test.changeDb.entity.ProjectEntity project where project.id=:id");
            query.setParameter("id",projectId);
            return (ProjectEntity) query.list().get(0);
        }finally {
            session.close();
        }
    }
    public DepartmentEntity getDeptById(Long deptId, SessionFactory sessionFactory ){
        Session session=null;
        try{
            session = sessionFactory.openSession();
            Query query = session.createQuery("from test.changeDb.DepartmentEntity dept where dept.id=:id");
            query.setParameter("id",deptId);
            return (DepartmentEntity) query.list().get(0);
        }finally {
            session.close();
        }
    }



    @Test
    public void testReadFromFile(){
        String s = readDeptStringFromFile("/deptListNew.txt");
        String s2 = readDeptStringFromFile("/projectListNew.txt");
        System.out.println(s);
        System.out.println(s2);
    }

    @Test
    public void testGetNewProjectMap(){
        Map<String, Long> newProjectMap = getNewProjectMap();
        System.out.println(newProjectMap);
    }
    public Map<String,Long> getNewProjectMap(){
            Map<String,Long> newProjectMap=new HashMap<String, Long>();
            String s = readDeptStringFromFile("/projectListNew.txt");
            JSONObject jsonObject= JSON.parseObject(s);
//        JSONObject jsonObject = JSONObject.fromObject(s);
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray children = data.getJSONArray("rows");
            JSONObject o = children.getJSONObject(0);
            for(int i=0;i<children.size();i++){
                newProjectMap.put(children.getJSONObject(i).getString("projectName"),children.getJSONObject(i).getLong("projectId"));
            }
        System.out.println(newProjectMap);
        System.out.println(newProjectMap.size());
        return newProjectMap;
    }



    public String readDeptStringFromFile(String filePath) {
        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:/qwer.txt"));
            InputStream resourceAsStream = this.getClass().getResourceAsStream(filePath);
            BufferedReader bufferedReader =new BufferedReader( new InputStreamReader(resourceAsStream,"gbk"));
            StringBuilder stringBuilder = new StringBuilder();
            String content;
            while((content = bufferedReader.readLine())!=null){
                stringBuilder.append(content);
            }
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testGetNewDeptMap(){
        getNewDeptMap();
    }

    public Map<String,Long> getNewDeptMap(){
        Map<String,Long> newDeptMap=new HashMap<String, Long>();
        String s = readDeptStringFromFile("/deptListNew.txt");
        JSONObject jsonObject= JSON.parseObject(s);
//        JSONObject jsonObject = JSONObject.fromObject(s);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray children = data.getJSONArray("children");
//        System.out.println(children);
        for(int i=0;i<children.size();i++){
            newDeptMap.put(children.getJSONObject(i).getString("departmentName"),children.getJSONObject(i).getLong("departmentId"));
            JSONArray children2 = children.getJSONObject(i).getJSONArray("children");
//            System.out.println("二层"+ children2);
            for(int j=0;j<children2.size();j++){
//                System.out.println("孩子"+children2.getJSONObject(j));
                newDeptMap.put(children2.getJSONObject(j).getString("departmentName"),children2.getJSONObject(j).getLong("departmentId"));
                JSONArray children3 = children2.getJSONObject(j).getJSONArray("children");
//                System.out.println(children3);
                for(int k=0;k<children3.size();k++){
                    newDeptMap.put(children3.getJSONObject(k).getString("departmentName"),children3.getJSONObject(k).getLong("departmentId"));
                }
            }
        }
        System.out.println(newDeptMap);
        System.out.println(newDeptMap.size());
        return newDeptMap;
    }

    @Test
    public void test(){

        Map<String, Long> newDeptMap = getNewDeptMap();
        ClassPathXmlApplicationContext ctxNeedChange=new ClassPathXmlApplicationContext("classpath:hibernateNeedChange.xml");
        LocalSessionFactoryBean bean = ctxNeedChange.getBean(LocalSessionFactoryBean.class);
        SessionFactory originSessionFactory = bean.getObject();
        Session session = originSessionFactory.openSession();
        session.beginTransaction();
        List<AliyunOmsOverviewEntity> list = session.createCriteria(AliyunOmsOverviewEntity.class).list();
        System.out.println("开始修改");
        for (AliyunOmsOverviewEntity aliyunOmsOverviewEntity : list) {
            Long deptId = aliyunOmsOverviewEntity.getDepartment();
            if(deptId!=null){
                DepartmentEntity deptById = getDeptById(deptId, originSessionFactory);
                Long aLong = newDeptMap.get(deptById.getLabel());
                aliyunOmsOverviewEntity.setDepartment(aLong);
//                System.out.println(deptById);
//                System.out.println("已修改："+(++count));
            }
        }
        System.out.println("修改完成");
        session.getTransaction().commit();
        session.close();
        System.out.println("总大小"+list.size());
        System.out.println("sessionFactory");
    }
    public void displayListDept(List<DepartmentEntity> o){
        for (DepartmentEntity departmentEntity : o) {
            System.out.println(departmentEntity);
        }
    }
}
