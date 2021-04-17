package color.picker;

import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;

public class App {

    public static void main(String[] args) throws LifecycleException{
        Tomcat server = new Tomcat();
        server.getConnector();
        server.setPort(8080);
        Context context = server.addWebapp("", new File("app/src/main/web").getAbsolutePath());
        WebResourceRoot resources = new StandardRoot(context);
        resources.addPostResources(new DirResourceSet(
            resources,
            "/WEB-INF/classes",
            new File("app/build/classes/java/main").getAbsolutePath(),
            "/")
        );
        context.setResources(resources);

        server.addServlet(
            "", 
            "colorServlet", 
            new HttpServlet(){
                @Override
                protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
                    resp.getWriter().println("Hello from colorServlet");
                }
            });
        context.addServletMappingDecoded("", "colorServlet");

        server.addServlet(
            "", 
            "loginServlet", 
            new HttpServlet(){
                @Override
                protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
                    String user, pass;
                    if ((user = req.getParameter("user"))!= null && ((pass = req.getParameter("pass")) != null)){

                        //replace with db comparison
                            if (user.equals("admin") && pass.equals("password")){
                                resp.sendRedirect("/colorPicker.html");
                            }
                            else{
                                resp.sendRedirect("/index.html");
                            }
                    }
            }
        });
        context.addServletMappingDecoded("/login", "loginServlet");
        server.addServlet(
            "", 
            "saveServlet", 
            new HttpServlet(){
                @Override
                protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
                    System.out.println(req.getParameter("red"));
                    System.out.println(req.getParameter("user"));
                    
            }
        });
        context.addServletMappingDecoded("/save", "saveServlet");




        server.start();
        server.getServer().await();
    }
}