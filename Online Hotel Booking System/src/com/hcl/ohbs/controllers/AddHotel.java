package com.hcl.ohbs.controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hcl.ohbs.entities.HotelOwner;
import com.hcl.ohbs.services.HotelOwnerService;
import com.hcl.ohbs.services.HotelService;

@WebServlet("/AddHotel")
public class AddHotel extends HttpServlet {

	// location to store file uploaded
	private static final String UPLOAD_DIRECTORY = "upload";

	// upload settings
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String filePath= "path2";
		
		// checks if the request actually contains upload file
			/*	if (!ServletFileUpload.isMultipartContent(request)) {
					// if not, we stop here
					PrintWriter writer = response.getWriter();
					writer.println("Error: Form must has enctype=multipart/form-data.");
					writer.flush();
					return;
				}

				// configures upload settings
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// sets memory threshold - beyond which files are stored in disk
				factory.setSizeThreshold(MEMORY_THRESHOLD);
				// sets temporary location to store files
				factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

				ServletFileUpload upload = new ServletFileUpload(factory);

				// sets maximum size of upload file
				upload.setFileSizeMax(MAX_FILE_SIZE);

				// sets maximum size of request (include file + form data)
				upload.setSizeMax(MAX_REQUEST_SIZE);

				// constructs the directory path to store upload file
				// this path is relative to application's directory
				String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

				// creates the directory if it does not exist
				File uploadDir = new File(uploadPath);
				if (!uploadDir.exists()) {
					uploadDir.mkdir();
				}

				try {
					// parses the request's content to extract file data
					@SuppressWarnings("unchecked")
					List<FileItem> formItems = upload.parseRequest(request);

					if (formItems != null && formItems.size() > 0) {
						// iterates over form's fields
						for (FileItem item : formItems) {
							// processes only fields that are not form fields
							if (!item.isFormField()) {
								String fileName = new File(item.getName()).getName();
								filePath = uploadPath + File.separator + fileName;
								File storeFile = new File(filePath);

								// saves the file on disk
								item.write(storeFile);
								request.setAttribute("message", "Upload has been done successfully! ");
								
								// file path with name => filePath;
							}
						}
					}
				} catch (Exception ex) {
					request.setAttribute("message", "There was an error: " + ex.getMessage());
				}
		

		String hotelName = request.getParameter("hotelname");
		String hotelCity = request.getParameter("hotelcity");
		String phone_number = request.getParameter("hotelcontact");
		String address = request.getParameter("hoteladdress");
		String status = request.getParameter("hotelstatus");
		//int max_capacity = Integer.parseInt(request.getParameter("hotelguestcapacity"));
		//int available_capacity = Integer.parseInt(request.getParameter("hotelslots"));
		//String category = request.getParameter("hoteladdress");
		//String features = request.getParameter("hoteladdress");
		//double price = Double.parseDouble(request.getParameter("hotelslots"));
				

		*/

		out.println("<html><boby>");
		HotelService hotelService = new HotelService();
		//String[] images = { filePath };
		// recieve the id from coming from the session and assign into id variable
		//HttpSession session = request.getSession();
		//int ownerId = (int) session.getAttribute("hotelOwnerId");
		//String hotelOwnerName = (String) session.getAttribute("hotelOwnerName");
		int ownerId = 2;
		if (hotelService.addHotelAndImages(hotelName, hotelCity, phone_number, address, status, 1000, 100, ownerId,
				"budget", "feature1,feature2", 2000.00, filePath)) {
			out.println("<font>hotel added success!!<font>");
		} else {
			out.println("<font color='red'>Error in adding the hotel<font>");
		}
		out.println("</boby><html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
