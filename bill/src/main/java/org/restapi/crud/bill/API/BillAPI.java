package org.restapi.crud.bill.API;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.restapi.crud.bill.model.Bill;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BillAPI")
public class BillAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Bill docObject = new Bill();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String output = docObject.insertbills(request.getParameter("docId"), 
												request.getParameter("docName"),
												request.getParameter("docUnit"),
												request.getParameter("docAmount"));
												
												
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		String output = docObject.UpdateBills(paras.get("hidItemIDSave").toString(),											
												paras.get("docUnit").toString(),
												paras.get("docAmount").toString());
												 												
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		String output = docObject.deletebill(paras.get("docId").toString());
		response.getWriter().write(output);
		
	}
    
 // Convert request parameters to a Map
 		private static Map getParasMap(HttpServletRequest request) {
 			Map<String, String> map = new HashMap<String, String>();
 			try {
 				Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
 				String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
 				scanner.close();
 				String[] params = queryString.split("&");
 				for (String param : params) {

 					String[] p = param.split("=");
 					map.put(p[0], p[1]);
 				}
 			} catch (Exception e) {
 			}
 			return map;
 		}

}
