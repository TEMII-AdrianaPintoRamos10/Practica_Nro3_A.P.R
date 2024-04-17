/*
 */
package com.emergentes.controlador;
import com.emergentes.modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ramos
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession ses = request.getSession();

        if (ses.getAttribute("listaP") == null) {
            ArrayList<Persona> listaux = new ArrayList<Persona>();
            ses.setAttribute("listaP", listaux);
        }

        ArrayList<Persona> lista = (ArrayList<Persona>) ses.getAttribute("listaP");

        String op = request.getParameter("op");
        String opcion = (op != null) ? request.getParameter("op") : "view";

        Persona obj1 = new Persona();

        int id, pos;

        switch (opcion) {
            case "nuevo": //Insertar nuevo 
                request.setAttribute("nuevapersona", obj1);
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                break;

            case "editar": 
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request, id);
                obj1 = lista.get(pos);
                request.setAttribute("nuevapersona", obj1);
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                break;

            case "eliminar"://Eliminar 
                pos = buscarIndice(request, Integer.parseInt(request.getParameter("id")));
                lista.remove(pos);
                ses.setAttribute("listaP", lista);
                response.sendRedirect("index.jsp");
                break;

            case "view":
                response.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    HttpSession ses = request.getSession();
    ArrayList<Persona> lista = (ArrayList<Persona>) ses.getAttribute("listaP");

    
    Persona obj1 = new Persona();

    
    obj1.setId(Integer.parseInt(request.getParameter("id")));
    obj1.setNombre(request.getParameter("nombre"));
    obj1.setApellidos(request.getParameter("apellidos"));
    obj1.setTurno(request.getParameter("turno"));

    
        
        try {
            String fechaString = request.getParameter("fecha");
            if (fechaString != null && !fechaString.isEmpty()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                Date fecha = dateFormat.parse(fechaString);
                obj1.setFecha(fecha);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        
    
    String[] seminariosSeleccionados = request.getParameterValues("seminarios");
    if (seminariosSeleccionados != null && seminariosSeleccionados.length > 0) {
        obj1.setSeminarios(seminariosSeleccionados);
    } else {
        
        obj1.setSeminarios(new String[]{"No hay seminarios seleccionados"});
    }

    
    int idt = obj1.getId();
    if (idt == 0) {
        
        int ultID = ultimoId(request);
        obj1.setId(ultID);
        lista.add(obj1);
    } else {
        
        lista.set(buscarIndice(request, idt), obj1);
    }

    
    ses.setAttribute("listaP", lista);

    
    response.sendRedirect("index.jsp");

    }

    private int ultimoId(HttpServletRequest request) {

        HttpSession ses = request.getSession();
        ArrayList<Persona> lista = (ArrayList<Persona>) ses.getAttribute("listaP");

        int idaux = 0;
        for (Persona item : lista) {
            idaux = item.getId();
        }
        return idaux + 1;
    }

    private int buscarIndice(HttpServletRequest request, int id) {

        HttpSession ses = request.getSession();
        ArrayList<Persona> lista = (ArrayList<Persona>) ses.getAttribute("listaP");

        int i = 0;
        if (lista.size() > 0) {
            while (i < lista.size()) {
                if (lista.get(i).getId() == id) {
                    break;
                } else {
                    i++;
                }
            }
        }
        return i;
    }

}
