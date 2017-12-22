import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.WindowState;
import java.io.IOException;
import java.io.PrintWriter;

public class PrefPortlet extends GenericPortlet {
    public void processAction(ActionRequest request, ActionResponse response) 
		throws PortletException {
        // process the salutation set by the user in the edit mode.
        String salutation = request.getParameter("SALUTATION");
        try {
            PortletPreferences pref = request.getPreferences();
            pref.setValue("salutation", salutation);
            pref.store();
        } catch (Exception e) {
            throw new PortletException(e.getMessage());
        }
        // return the user back to the view mode and normal state
        response.setPortletMode(PortletMode.VIEW);
        response.setWindowState(WindowState.NORMAL);
    }

    public void doView(RenderRequest request,RenderResponse response) 
		throws PortletException,IOException {
        // displays the salutation stored in the preference.
        PortletPreferences pref = request.getPreferences();
        String salutation = pref.getValue("salutation","");
        response.setContentType(request.getResponseContentType());
        PrintWriter writer = response.getWriter();
        writer.write("Hello " + salutation);
    }

    public void doEdit(RenderRequest request,RenderResponse response)
		throws PortletException,IOException {
        PortletURL actionURL = response.createActionURL();
        response.setContentType(request.getResponseContentType());
        PrintWriter writer = response.getWriter();
        writer.print("<form method=\"post\" action=\"" + actionURL.toString());
        writer.println("\">");
			writer.println("<center><p>Salutation: <input type=\"text\" name=\"salutation\"></p>");
			writer.println("<input type=\"submit\" value=\"Submit\">");
			writer.println("</form>");
    }

    public void doHelp(RenderRequest request, RenderResponse response) 
		throws PortletException {
        response.setContentType(request.getResponseContentType());
        try {
            response.setContentType(request.getResponseContentType());
            PrintWriter writer = response.getWriter();
            writer.write("Pref Portlet Help<p><p>");
        } catch (IOException e) {
            throw new PortletException("PrefPortlet.doHelp exception", e);
        }
    }
}
