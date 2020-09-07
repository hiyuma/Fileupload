package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig(location = "C:/Users/user/Desktop/temp") //一時保存先
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// uploads フォルダ内のファイルリストを取得する
		File uploadDirectory = new File(request.getServletContext().getRealPath("/uploads"));
		File[] fileList = uploadDirectory.listFiles();
		request.setAttribute("fileList", fileList);

		// デバッグ用にファイルリストをコンソールに表示する
		for(File file : fileList) {
			System.out.println(file.getPath());
		}
		request.getRequestDispatcher("WEB-INF/view/upload.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File uploadsDirectory = new File(request.getServletContext().getRealPath("/uploads"));
		// アップロードされたファイルを保存する
		Part part = request.getPart("upfile");
		String filename = part.getSubmittedFileName();

		if(part.getSize() >0) {
			part.write(uploadsDirectory + "/" + filename);
		}

		// ファイル名をリクエストスコープにセットする
		request.setAttribute("filename", filename);
		request.getRequestDispatcher("/WEB-INF/view/uploadDone.jsp").forward(request, response);

	}

}
