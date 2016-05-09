package edziekanat.controller.common;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.UserDTO;
import edziekanat.utilities.PasswordUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/password")
public class PasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public PasswordController()
    {
        super();
    }

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String currentpassword = request.getParameter("currentpassword");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("passwordrepeat");
        UserDAO userDAO = new UserDAO();
        UserDTO user = userDAO.getEntity(((LoginBean) request.getSession().getAttribute("loginBean")).getLogin());
        if(currentpassword!=null) {
            String salt = user.getSalt();
            String hash = PasswordUtils.getSHA512PasswordHash(currentpassword, salt);
            if (hash.equals(user.getPassword())) {
                if (password.equals(passwordRepeat)) {
                    if (password.length() >= 5) {
                        salt = PasswordUtils.generateSalt();
                        hash = PasswordUtils.getSHA512PasswordHash(password, salt);
                        user.setPassword(hash);
                        user.setSalt(salt);
                        userDAO.update(user);

                        request.setAttribute("msgshort", "Zmieniono has³o");
                        request.setAttribute("msglong", "Has³o zosta³o zmienione.");
                        request.getRequestDispatcher("common/info.jsp").forward(request, response);

                        userDAO.closeEntityManager();
                    } else {
                        request.setAttribute("errorshort", "B³±d");
                        request.setAttribute("errorlong", "Minimalna d³ugo¶æ has³a to 5 znaków.");
                        request.getRequestDispatcher("common/error.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("errorshort", "B³±d");
                    request.setAttribute("errorlong", "Podano ró¿ne has³a.");
                    request.getRequestDispatcher("common/error.jsp").forward(request, response);
                }

            } else {
                request.setAttribute("errorshort", "B³±d");
                request.setAttribute("errorlong", "Podano niepoprawne has³o.");
                request.getRequestDispatcher("common/error.jsp").forward(request, response);
            }
        }
        if (request.isUserInRole("lecturer"))
        {
            request.getRequestDispatcher("lecturer/changepassword.jsp").forward(request, response);
        }
        else if (request.isUserInRole("admin"))
        {
            request.getRequestDispatcher("administrator/changepassword.jsp").forward(request, response);
        }
        else if (request.isUserInRole("student"))
        {
            request.getRequestDispatcher("student/changepassword.jsp").forward(request, response);
        }

    }

}
