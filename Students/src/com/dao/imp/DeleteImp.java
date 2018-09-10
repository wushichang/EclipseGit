package com.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.StudentBean;
import com.dao.Delete;
import com.util.JDBCProperties;

public class DeleteImp implements Delete{
	@Override
	public boolean deleteStudent(StudentBean student) {
		//��������ֵ
		boolean result=false;
		//�������Ӷ���
		Connection con=null;
		//����Ԥ�������
		PreparedStatement ps=null;
		//����sql���
		String sql="select stuId from student where stuName=?";
		//�õ�����
		con=JDBCProperties.getConnection();
		//���������
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, student.getStuName());
			rs=ps.executeQuery();
			//����ѧ����ű���
			String stuId="";
			if(rs.next()) {
				stuId=rs.getString("stuId");
			}
			 //����ɾ��ѧ���ɼ�sql���
			String sql1="delete from scores where stuId=?";
			ps=con.prepareStatement(sql1);
			ps.setString(1, stuId);
			result=ps.executeUpdate()>0;
			//����ɾ��ѧ����Ϣ��sql���
			String sql2="delete from student where stuId=?";
			ps=con.prepareStatement(sql2);
			ps.setString(1, stuId);
			result=ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCProperties.close(con, ps, rs);
		}
		
		return result;
	}
	/*public static void main(String[] args) {
		new DeleteImp().deleteStudent(new StudentBean("��ĳ��"));
	}*/
}