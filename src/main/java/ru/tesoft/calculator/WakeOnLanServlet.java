package ru.tesoft.calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Konstantin on 08.02.2016.
 */
public class WakeOnLanServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    WakeOnLanBean wakeOnLanBean = (WakeOnLanBean) getServletContext().getAttribute("wakeOnLanBean");

    if (wakeOnLanBean == null) {
      wakeOnLanBean = new WakeOnLanBean();
      getServletContext().setAttribute("wakeOnLanBean", wakeOnLanBean);
    }

    if(wakeOnLanBean.isMagicPacket()){
      wakeOnLanBean.setIsMagicPacket(false);
      wakeOnLanBean.getHistory().add(getCurrentDateTime() + " Magic packet was processed at this time.");
      RequestDispatcher view = request.getRequestDispatcher("index.jsp");
      response.setStatus(HttpServletResponse.SC_OK);
      response.getWriter().println("<html><body><p>Magic packet found. Please wake.</p></body></html>");
      return;
    }

    wakeOnLanBean.getHistory().add(getCurrentDateTime());
    RequestDispatcher view = request.getRequestDispatcher("index.jsp");
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    response.getWriter().println("<html><body><p>No magic packet found. Don't wake.</p></body></html>");

  }

  private String getCurrentDateTime(){
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    return simpleDateFormat.format(new Date());
  }

}
