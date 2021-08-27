package com.swan.web.controller;

//import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.maven.model.Model;
//import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
//import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.swan.model.repo.StudentRepository;


/**
 * Controller that is only called to check if the project is up
 */
@RequestMapping("/available")
@RestController
public class AvailableController {

	@Autowired
	StudentRepository studentRepository;


	private final String RESPONSE_STRING = "I'm up. ";
	private final String SYNC_ERROR = "1";

	// ping interface just to see if the connector is deployed and working
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public String available(final HttpServletRequest request, final HttpServletResponse response) {
		try {

			return RESPONSE_STRING + "<br/>   usrepo= " + studentRepository.findAll().size() + "   ";

		} catch (final Exception e) {
			Logger.getLogger(AvailableController.class.getName()).log(Level.SEVERE, e.getLocalizedMessage());
			response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
			return "";
		}
	}

	@RequestMapping(value = "/version", method = RequestMethod.GET)
	@ResponseBody
	public String version(final HttpServletRequest request, final HttpServletResponse response)
			/*throws IOException, XmlPullParserException*/ {

	/*	final MavenXpp3Reader reader = new MavenXpp3Reader();
		final Model model = reader.read(new FileReader("pom.xml"));*/
		return "Version: ";// + model.getProperties().getProperty("com.medisanaspace.library.version");
	}

	@RequestMapping(value = "sync_error", method = RequestMethod.GET)
	@ResponseBody
	public String getSyncError(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		// convert java object to JSON format
		final String json = "{\"syncError\":" + SYNC_ERROR + "}";
		return json;
	}

}
