package ru.tesoft.calculator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Konstantin on 08.02.2016.
 */
public class MagicPacketServlet extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    WakeOnLanBean wakeOnLanBean = (WakeOnLanBean) getServletContext().getAttribute("wakeOnLanBean");

    if (wakeOnLanBean == null) {
      wakeOnLanBean = new WakeOnLanBean();
      getServletContext().setAttribute("wakeOnLanBean", wakeOnLanBean);
    }

    String requiredPassword = "createMagicPacketPassword";
    String password = request.getParameter("actionPassword");
    if(!requiredPassword.equals(password)) {
      RequestDispatcher view = request.getRequestDispatcher("index.jsp");
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      response.getWriter().println("<html><body><p>Not Authorized!</p></body></html>");
      return;
    }

    String actionCode = request.getParameter("actionCode");
    if("Create Magic Packet".equals(actionCode)){
      wakeOnLanBean.setIsMagicPacket(true);
    }else if("Delete Magic Packet".equals(actionCode)){
      wakeOnLanBean.setIsMagicPacket(false);
    }

    response.sendRedirect("index.jsp");
  }

}
