package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import model.Asiakas;
import model.dao.Dao;



@WebServlet("/Asiakkaat")
public class Asiakkaat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public Asiakkaat() {
        super();
        System.out.println("Asiakkaat.Asiakkaat()");
    }

    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Asiakkaat.doGet()");
		Dao dao = new Dao();
		ArrayList<Asiakas> myynti = dao.listaaKaikki();
		System.out.println(myynti);
		String strJSON = new JSONObject().put("asiakas", myynti).toString();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(strJSON);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Asiakkaat.doPost()");
		doGet(request, response);
	}

	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Asiakkaat.doPut()");
	}

	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Asiakkaat.doDelete()");
	}

}
