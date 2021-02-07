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

import com.hcl.ohbs.dao.HotelDAO;
import com.hcl.ohbs.dao.RoomDAO;
import com.hcl.ohbs.entities.Hotel;
import com.hcl.ohbs.services.HotelService;
import com.hcl.ohbs.services.RoomService;
@WebServlet("/AddRoom")
public class AddRoom extends HttpServlet {
		// location to store file uploaded
		private static final String UPLOAD_DIRECTORY = "upload";

		// upload settings
		private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
		private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
		private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Begin /AddRoom: ");
		PrintWriter out = response.getWriter();
		HotelService hotelService = new HotelService();
		RoomService roomService = new RoomService();
		String filePath= null;
		
		// checks if the request actually contains upload file
//				if (!ServletFileUpload.isMultipartContent(request)) {
//					// if not, we stop here
//					PrintWriter writer = response.getWriter();
//					writer.println("Error: Form must has enctype=multipart/form-data.");
//					writer.flush();
//					return;
//				}

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
								System.out.println("image name = " + fileName);
								filePath = uploadPath + File.separator + fileName;
								System.out.println("file path = " + filePath);
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

		String hotelName = request.getParameter("hotelName");
		String roomName = request.getParameter("roomName");
		Double price = Double.parseDouble(request.getParameter("roomPrice"));
		int isAvailable=0;
		if(request.getParameter("roomStatus").equals("1")) {
			isAvailable = 1;
		}else {
			isAvailable = 0;
		}
		String features = request.getParameter("roomdesc");
		int noOfPersons = Integer.parseInt(request.getParameter("roomSlots"));
		out.println("<html><boby>");
		//String[] images = { filePath };			
		HttpSession session = request.getSession();// recieve the id from coming from the session and assign into id variable
 		int ownerId = (int) session.getAttribute("hotelOwnerId");
		String hotelOwnerName = (String) session.getAttribute("hotelOwnerName");
		Hotel hotel = hotelService.getHotelDetailsByName(hotelName);
		if(hotel==null) {
			System.out.println("no hotels found!!!");
			request.getRequestDispatcher("Owner-addRoom.jsp").include(request, response);
		}else {
			if (roomService.addRoomAndImages(roomName, price, features, noOfPersons, isAvailable, hotel, filePath)) {
				out.println("<font>Room added success!!<font>");
				request.getRequestDispatcher("Owner-addRoom.jsp").include(request, response);
			} else {
				out.println("<font color='red'>Error in adding the room<font>");
				request.getRequestDispatcher("Owner-addRoom.jsp").include(request, response);
			}		
			/*List<Hotel> hotelList = hotelService.getHotelsByOwnerId(ownerId);
			for(Hotel h:hotelList) {
				System.out.println("hotel name = " + h.getName());
			}*/
		}	
		//request.setAttribute("hotels", hotelList);
		out.println("</boby><html>");
		System.out.println("End /AddRoom: ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
