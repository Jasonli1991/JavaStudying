package tw.Jason.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Jason08")
public class Jason08 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String op = request.getParameter("op");
		String result = "";
		try {
			int temp = 0;
			switch (op) {
				case "+":
					temp = Integer.parseInt(x) + Integer.parseInt(y);
					break;
				case "-":
					temp = Integer.parseInt(x) - Integer.parseInt(y);
					break;
				case "x":
					temp = Integer.parseInt(x) * Integer.parseInt(y);
					break;
				case "/":
					temp = Integer.parseInt(x) / Integer.parseInt(y);
					//餘數待處理
					break;
				default:
					break;
			} 
			result += temp;
		}catch (Exception e) {
			x = y = "";
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append("<form>")
			//input後面的反斜線目的是要讓xml內部能順利分析資料
			.append(String.format("<input name='x' value='%s' />\n", x))
//			.append("+\n")
			.append("<select name='op'>")
			.append("<option value='+' selected>+</option>")
			.append("<option value='-'>-</option>")
			.append("<option value='x'>x</option>")
			.append("<option value='/'>/</option>")
			.append("</select>")
			.append(String.format("<input name='y' value='%s' />\n", y))
			.append("<input type='submit' value='=' />\n")
			.append(result)
			.append("</form>");

	}


}
