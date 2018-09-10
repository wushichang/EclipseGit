package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Score;
import com.bean.StudentBean;
import com.dao.imp.LoginImp;

/**
 * Servlet implementation class LServlet
 */
public class LServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//�õ�ѧ����Ϣ
		List<StudentBean> student=new LoginImp().select(new StudentBean(request.getParameter("stuName")));
		//�ж�ѧ����Ϣ�Ƿ�Ϊ��
		if(student.size()>0){
			//����д�����
			PrintWriter out=response.getWriter();
			for (StudentBean studentBean : student) {
				out.println(studentBean.getStuName()+":");
				List<Score> scores=studentBean.getScores();
				for (Score score : scores) {
					out.println(score.getSubjectName()+":\t"+score.getScore());
				}
			}
		}else{
			request.getRequestDispatcher("Register.html").forward(request, response);
		}
	}
}
