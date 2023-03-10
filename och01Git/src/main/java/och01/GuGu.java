package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuGu
 */
//@WebServlet("/GuGu")		// url을 인지하는 주소역할  -> WEB-INF -> lib ->web.xml에서 설정하면 생략가능
public class GuGu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuGu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// java로 보내는 값 한글로 보내줄 때 사용 (현재는 한글로 보내지 않아서 사용안해도됨)
		request.setCharacterEncoding("utf-8");		
		
		// Parameter로 num을 가져오고 구구단 출력
		int num = Integer.parseInt(request.getParameter("num"));
									// request하는 속성의 name을 parameter로 받음
		
		System.out.println("GuGu num ->" + num);
		
		response.setContentType("text/html;charset=utf-8");
		// 돌아오는 값 한글로 보여주기 (서버에서 뷰로 값을 response할때 한글이 깨지는 것을 방지)
		
		// 공식 -> 사용자 Browser에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.printf("<h1>구구단 %d단</h1>", num);
		for(int i=1; i<10; i++) {
			out.printf("%d * %d = %d<br> ", num, i, num*i);
		}
		out.println("</body></html>");
		out.close();	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
