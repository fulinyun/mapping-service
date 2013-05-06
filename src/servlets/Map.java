package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Map
 */
@WebServlet("/Map")
@MultipartConfig(fileSizeThreshold=1024*1024*10,
				maxFileSize=1024*1024*15,
				maxRequestSize=1024*1024*70)
public class Map extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Map() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = new PrintWriter(response.getOutputStream());
		for (Part part : request.getParts()) {
			pw.println("part name: " + part.getName());
			pw.println("part content type: " + part.getContentType());
			pw.println("part size: " + part.getSize());
			pw.println("headers:");
			for (String name : part.getHeaderNames()) {
				pw.print("  " + name + " : ");
				for (String s : part.getHeaders(name)) pw.print(s + ",");
				pw.println();
			}
			pw.println("content:");			
			BufferedReader br = new BufferedReader(new InputStreamReader(part.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) pw.println(line);
			br.close();
			pw.println();
		}
		pw.close();
	}

}
