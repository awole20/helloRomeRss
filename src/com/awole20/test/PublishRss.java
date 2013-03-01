package com.awole20.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.syndication.io.FeedException;

/**
 * Servlet implementation class PublishRss
 */
@WebServlet("/PublishRss")
public class PublishRss extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RomeTest testRss;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishRss() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prefix = this.getServletContext().getRealPath("/");
		try {
			testRss = new RomeTest(prefix + "rss");
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FeedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		testRss.addEntry("1","test1");
		testRss.addEntry("2","test2");
		testRss.addEntry("3","test3");
		try {
			testRss.publish();
		} catch (FeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("writing to " + prefix + "rss");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
