package com.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Score;
import com.bean.StudentBean;
import com.dao.Login;
import com.util.JDBCProperties;

public class LoginImp implements Login{
	@Override
	public List<StudentBean> select(StudentBean student) {
		//�������Ӷ���
		Connection con=null;
		//����Ԥ�������
		PreparedStatement ps=null;
		//����sql ���
		String sql="select * from student where stuName=?";
		//���������
		ResultSet rs=null;
		//�õ�����
		con=JDBCProperties.getConnection();
		//�����ۺϵõ�ѧ���ɼ�
		List<StudentBean> list=new ArrayList<StudentBean>();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, student.getStuName());
			//�ύԤ�������õ������
			rs=ps.executeQuery();
			while(rs.next()){
				StudentBean stu=new StudentBean(rs.getString("stuId"), rs.getString("stuName"), rs.getString("stuSex"), rs.getInt("stuAge"), rs.getString("stuEmail"), rs.getString("stuAddress"), null);
				//������ѯѧ���ɼ���sql���
				String sql1="select subjects.subjectName,scores.score"
						+ " from student,scores,subjects"
						+ " where student.stuId=scores.stuId"
						+ " and scores.subjectId=subjects.subjectId"
						+ " and student.stuId=?";
				//�õ�Ԥ�������
				ps=con.prepareStatement(sql1);
				//���ò���
				ps.setString(1, stu.getStuId());
				//ִ��Ԥ�������,�õ������
				ResultSet rs1=ps.executeQuery();
				//��������洢ѧ���ĳɼ�
				List<Score>scores=new ArrayList<Score>();
				while(rs1.next()){
					//ȡ��ѧ��ÿ�ſ�Ŀ�����Ƽ�����
					scores.add(new Score(rs1.getString("subjectName"), rs1.getInt("score")));
				}
				//���������ϴ���ѧ������
				stu.setScores(scores);
				//��ѧ��������뼯����
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			 JDBCProperties.close(con, ps, rs);
		}
		return list;
	}
	/*public static void main(String[] args) {
		List<StudentBean> list=new LoginImp().select(new StudentBean("��ĳ��"));
		for (StudentBean studentBean : list) {
			System.out.println(studentBean.getStuName());
			List<Score> scores=studentBean.getScores();
			//���ÿλͬѧ�ļ��ϵĴ�С
			//System.out.println(scores.size());
			for (Score score : scores) {
				System.out.println("��Ŀ:\t"+score.getSubjectName()+"\t+����:\t"+score.getScore());
			}
		}
	}*/
}
