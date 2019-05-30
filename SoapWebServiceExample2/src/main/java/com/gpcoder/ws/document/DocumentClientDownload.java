package com.gpcoder.ws.document;

import java.net.URL;

import javax.activation.DataHandler;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class DocumentClientDownload {

	public static final String DOWNLOADED_FOLDER = "data/download/";

	public static void main(String[] args) throws Exception {

		// Create URL of .wsdl file
		URL url = new URL(DocumentPublisher.WS_URL + "?wsdl");

		// Create a QName using targetNamespace and name
		QName qname = new QName("http://document.ws.gpcoder.com/", "DocumentServiceImplService");

		// Creates a Service instance with the specified WSDL document location and
		// service qualified name
		Service service = Service.create(url, qname);

		// We need to pass interface and model beans to client
		DocumentService imageServer = service.getPort(DocumentService.class);

		// Perform download document
		DataHandler dataHandler = imageServer.download("test.docx");

		// Save the result to file
		String fileName = DOWNLOADED_FOLDER + "dowload-" + System.currentTimeMillis() + ".docx";
		DocumentUtils.storeDataToFile(dataHandler, fileName);
		System.out.println("download() : Downloaded Successful with name " + fileName);
	}
}
