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
        String s = readDeptStringFromFile("/deptList.txt");
        String s2 = readDeptStringFromFile("/projectList.txt");
        System.out.println(s);
        System.out.println(s2);
    }

    public Map<String,Long> getNewProjectMap(){
            Map<String,Long> newProjectMap=new HashMap<String, Long>();
            String s = readDeptStringFromFile("/projectList.txt");
            JSONObject jsonObject= JSON.parseObject(s);
//        JSONObject jsonObject = JSONObject.fromObject(s);
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray children = data.getJSONArray("rows");
            JSONObject o = children.getJSONObject(0);
            for(int i=0;i<children.size();i++){
                newProjectMap.put(children.getJSONObject(i).getString("projectName"),children.getJSONObject(i).getLong("projectId"));
            }
        return newProjectMap;
    }



    public String readDeptStringFromFile(String filePath) {
        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:/qwer.txt"));
            InputStream resourceAsStream = this.getClass().getResourceAsStream(filePath);
            System.out.println(resourceAsStream);
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
        String s = readDeptStringFromFile("/deptList.txt");
        JSONObject jsonObject= JSON.parseObject(s);
//        JSONObject jsonObject = JSONObject.fromObject(s);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray children = data.getJSONArray("children");
        JSONObject o = children.getJSONObject(0);
        JSONArray children1 = o.getJSONArray("children");
        for(int i=0;i<children1.size();i++){
            newDeptMap.put(children1.getJSONObject(i).getString("departmentName"),children1.getJSONObject(i).getLong("departmentId"));
        }
        newDeptMap.put("浙江省政府", (long) 5);
//        Set<Map.Entry<String, Long>> entries = newDeptMap.entrySet();
//        for (Map.Entry<String, Long> entry : entries) {
//            System.out.println(entry.getKey()+entry.getValue());
//        }
//        newDeptMap.put("中国国际贸易促进委员会浙江省委员会", (long) 42);
//        newDeptMap.put("中国民主促进会浙江省委员会", (long) 64);
//        newDeptMap.put("共青团浙江省委员会", (long) 65);
//        newDeptMap.put("国家统计局浙江调查总队", (long) 41);
//        newDeptMap.put("平台管控", (long) 58);
//        newDeptMap.put("政务云管理平台", (long) 47);
//        newDeptMap.put("浙江省交通运输厅", (long) 34);
//        newDeptMap.put("浙江省人力资源和社会保障厅", (long) 20);
//        newDeptMap.put("浙江省人大", (long) 19);
//        newDeptMap.put("浙江省人民政府办公厅", (long) 29);
//        newDeptMap.put("浙江省人民政府口岸办公室", (long) 51);
//        newDeptMap.put("浙江省人民政府外事侨务办公室", (long) 55);
//        newDeptMap.put("浙江省政府", (long) 5);
//        newDeptMap.put("浙江省政府", (long) 5);
//        newDeptMap.put("浙江省政府", (long) 5);
//        newDeptMap.put("浙江省政府", (long) 5);
//        newDeptMap.put("浙江省政府", (long) 5);
//        newDeptMap.put("浙江省政府", (long) 5);
//        newDeptMap.put("浙江省政府", (long) 5);
//        newDeptMap.put("浙江省政府", (long) 5);
//        newDeptMap.put("浙江省政府", (long) 5);
//        newDeptMap.put("浙江省政府", (long) 5);
//        newDeptMap.put("浙江省政府", (long) 5);
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
        int count=0;
        for (AliyunOmsOverviewEntity aliyunOmsOverviewEntity : list) {
            Long deptId = aliyunOmsOverviewEntity.getDepartment();
            if(deptId!=null){
                DepartmentEntity deptById = getDeptById(deptId/100, originSessionFactory);
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
