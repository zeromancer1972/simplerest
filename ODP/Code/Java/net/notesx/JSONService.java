/**
 * 
 */
package net.notesx;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.commons.util.io.json.JsonJavaObject;
import com.ibm.domino.services.ServiceException;
import com.ibm.domino.services.rest.RestServiceEngine;
import com.ibm.xsp.extlib.component.rest.CustomService;
import com.ibm.xsp.extlib.component.rest.CustomServiceBean;

/**
 * @author Oliver
 * 
 */
public class JSONService extends CustomServiceBean {

	@Override
	public void renderService(CustomService service, RestServiceEngine engine) throws ServiceException {
		HttpServletRequest request = engine.getHttpRequest();
		HttpServletResponse response = engine.getHttpResponse();
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			JsonJavaObject jo = new JsonJavaObject();
			jo.put("foo", "bar");
			jo.put("argument", request.getParameter("id"));
			writer.write(jo.toString());
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
