package com.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Score;
import com.bean.StudentBean;
import com.dao.Register;
import com.util.JDBCProperties;

public class RegisterImp implements Register{
	
	public boolean register(StudentBean student) {
		//��������ֵ
		boolean result=false;
		//�������Ӷ���
		Connection con=null;
		//����Ԥ�������
		PreparedStatement ps=null;
		//��������ѧ����Ϣsql���
		String sql="insert into student(stuId,stuName,stuSex,stuAge,stuEmail,stuAddress)values(?,?,?,?,?,?)";
		//�õ����Ӷ���
		con=JDBCProperties.getConnection();
		//���������
		ResultSet rs=null;
		try {
			//�õ�Ԥ�������
			ps=con.prepareStatement(sql);
			//���ò���
			ps.setString(1, student.getStuId());
			ps.setString(2,student.getStuName());
			ps.setString(3, student.getStuSex());
			ps.setInt(4, student.getStuAge());
			ps.setString(5, student.getStuEmail());
			ps.setString(6, student.getStuAddress());
			result=ps.executeUpdate()>0;
			//��������ѧ���ɼ���Ϣsql���
			String sql1="insert into scores(stuId,score,subjectId)values(?,?,?)";
			//������ѯ��Ŀ���sql���
			String sql2="select subjectId from subjects where subjectName=?";
			//������Ŀ���
			int subjectId=0;
			//�õ�ѧԱ�ɼ�
			List<Score>scores=student.getScores();
			for (int i = 0; i < scores.size(); i++) {
				//�ύ��ѯ��Ŀ��sql���
				ps=con.prepareStatement(sql2);
				//���ò���
				ps.setString(1, scores.get(i).getSubjectName());
				//���ݿ�Ŀ���õ���Ŀ���
				rs=ps.executeQuery();
				if(rs.next()){
					//�õ���Ŀ���
					subjectId=rs.getInt("subjectId");
				}
				ps=con.prepareStatement(sql1);
				ps.setString(1, student.getStuId());
				ps.setInt(2, scores.get(i).getScore());
				ps.setInt(3, subjectId);
				result=ps.executeUpdate()>0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCProperties.close(con, ps, rs);
		}
		return result;
	}
	/*public static void main(String[] args) {
		List<Score>scores=new ArrayList<Score>();
		scores.add(new Score("html",60));
		scores.add(new Score("java����",70));
		scores.add(new Score("javaOOP",80));
		scores.add(new Score("sqlServer",90));
		if(new RegisterImp().register(new StudentBean("43092119","��ĳ��", "��", 18, "myEmail", "myAddress", scores))){
			System.out.println("ok");
		}
	}*/
}
