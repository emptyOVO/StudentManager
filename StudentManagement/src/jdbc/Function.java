package jdbc;

import utils.JdbcUtils;

import java.sql.*;

public class Function {

    public static String Insert(String information1){//增加学生信息同时添加至班级信息表方法
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String result = "";
        try {

            conn = JdbcUtils.getConnection();//获取数据库连接
            conn.setAutoCommit(false);//关闭数据库自动提交，并自动开启事务
            String[] arr = information1.split("\\s+");
            String classid = arr[0].substring(4, 6);
            String intertime = arr[0].substring(0,4);
            String studentintertime = null;
            String classname = null;
            if (classid.equals("01")) {classname = "一班";}
            if (classid.equals("02")) {classname = "二班";}
            if(intertime.equals("2019")){studentintertime = "2019-09-01";}
            if(intertime.equals("2020")){studentintertime = "2020-09-01";}
            if(intertime.equals("2021")){studentintertime = "2021-09-01";}
            if(intertime.equals("2022")){studentintertime = "2022-09-01";}
            String sql = "INSERT INTO `students` (`id`,`name`,`sex`,`grade`) VALUES (?,?,?,?)";
            st = conn.prepareStatement(sql);//预编译
            st.setString(1, arr[0]);
            st.setString(2, arr[1]);
            st.setString(3, arr[2]);
            st.setString(4, arr[3]);
            st.executeUpdate();
            String sql2 = "INSERT INTO `classes` (`classid`,`classname`,`studentid`,`studentname`,`studentsex`,`studentintertime`) VALUES (?,?,?,?,?,?)";
            st = conn.prepareStatement(sql2);//预编译
            st.setString(1, classid);
            st.setString(2, classname);
            st.setString(3, arr[0]);
            st.setString(4, arr[1]);
            st.setString(5, arr[2]);
            st.setString(6,studentintertime);
            st.executeUpdate();
            conn.commit();//业务完毕，提交事务
            System.out.println("插入学生信息成功！");
        } catch (SQLException e) {
            try {
                conn.rollback();//如果失败则回滚事务
            }catch (SQLException e1){
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st, rs);
        }
        return result;
    }

    public static String Delete(String information2){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String result = "";
        try {
            conn = JdbcUtils.getConnection();//获取数据库连接
            conn.setAutoCommit(false);
            st = conn.createStatement();//获得SQL执行对象
            String sql = "DELETE FROM `students` where id = "+information2;
            String sql2 = "DELETE FROM `classes` where studentid = "+information2;
            st.executeUpdate(sql);
            st.executeUpdate(sql2);
            conn.commit();//业务完毕，提交事务
            System.out.println("删除学生信息成功！");
        } catch (SQLException e) {
            try {
                conn.rollback();//如果失败则回滚事务
            }catch (SQLException e1){
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st, rs);
        }
        return result;
    }


    public static String Update(String information3,String information4){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String result = "";
        try {
            conn = JdbcUtils.getConnection();//获取数据库连接
            conn.setAutoCommit(false);
            String[] arr = information4.split("\\s+");
            String sql = "UPDATE `students` SET `name` = ?,`sex` = ?, `grade` = ? WHERE `id` = "+information3;
            String sql2 = "UPDATE `classes` SET `studentname` = ?,`studentsex` = ? WHERE `studentid` = "+information3;
            st = conn.prepareStatement(sql);//预编译
            st.setString(1, arr[0]);
            st.setString(2, arr[1]);
            st.setString(3, arr[2]);
            st.executeUpdate();
            st = conn.prepareStatement(sql2);//预编译
            st.setString(1, arr[0]);
            st.setString(2, arr[1]);
            st.executeUpdate();
            conn.commit();//业务完毕，提交事务
            System.out.println("修改学生信息成功！");
        } catch (SQLException e) {
            try {
                conn.rollback();//如果失败则回滚事务
            }catch (SQLException e1){
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,rs);
        }
        return result;
    }



    public static void Select(int start, int count){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            System.out.println("您查询的是第" + start + "页，共" + count + "条数据");
            st = conn.createStatement();

            //SQL
            String sql ="select * from `students` limit " + ((start-1) * count) + "," + count;
            rs = st.executeQuery(sql);//查询完毕会返回一个结果集
            while (rs.next()){
                System.out.println(rs.getString("id")+"  "
                        +rs.getString("name")+"  "
                        +rs.getString("sex")+"  "
                        +rs.getString("grade"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
    public static void Select2(int start,int count){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            System.out.println("您查询的是第" + start + "页，共" + count + "条数据");
            st = conn.createStatement();

            //SQL
            String sql = "SELECT * FROM `classes`limit " + ((start-1) * count) + "," + count;
            rs = st.executeQuery(sql);//查询完毕会返回一个结果集
            while (rs.next()){
                System.out.println("   "+rs.getString("classid")
                        +"     "+rs.getString("classname")+"    "
                        +rs.getString("studentid")+"    "
                        +rs.getString("studentname")+"          "
                        +rs.getString("studentsex")+"     "
                        +rs.getString("studentintertime"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }



}



