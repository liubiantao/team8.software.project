package courses;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tommy
 */
public class AddCourseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            // create new Course oject
            Course course = new Course();
            // populate course object with data from  POST
            course.setCourse_code(request.getParameter("course_code"));
            course.setTitle(request.getParameter("title"));
            course.setS_date(request.getParameter("s_date"));
            course.setF_date(request.getParameter("f_date"));
            course.setMax_places(request.getParameter("max_places"));
            course.setAvail_places(request.getParameter("avail_places"));
            course.setTotal_fee(request.getParameter("total_fee"));
            course.setDeposit(request.getParameter("deposit")); 
            course.setDescription(request.getParameter("description")); 
            String nextJSP;
            // check if course data is valid   
            if(course.isValid()) {
                // add course to the database
                course.addCourse();
                nextJSP = "courseadded.jsp";
                
            }
            else {
                // bring user back to add course page
                request.setAttribute("course", course);
                nextJSP = "addcourse.jsp";
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(nextJSP);
            dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
