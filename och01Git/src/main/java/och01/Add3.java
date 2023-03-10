package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// 목표 : 1부터 누적값 전달
		int num = Integer.parseInt(request.getParameter("num"));
		String loc = request.getParameter("loc");
		System.out.println("Add3 num ->" + num);	// 개발자 확인용
		int sum = 0;
		for(int i=1; i<=num; i++) {
			sum+=i;
		}
		System.out.println("Add3 sum->" + sum);		// 개발자 확인용
		
		response.setContentType("text/html;charset=utf-8");	// 한글이 깨지는 것을 방지
		
		// 공식 -> 사용자 Browser에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.printf("<h1>1부터 %d까지 합계</h1>", num);
		// out.printf("<h4>Loc --> %s</h4>", loc);
		out.println(sum);
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
