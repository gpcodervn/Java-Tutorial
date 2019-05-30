package com.gpcoder.ws.document;

import java.net.URL;

import javax.activation.DataHandler;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class DocumentClientUpload {

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

		// Enable MTOM in client
		BindingProvider bp = (BindingProvider) imageServer;
		SOAPBinding binding = (SOAPBinding) bp.getBinding();
		binding.setMTOMEnabled(true);

		// Prepare document for upload
		DataHandler dataHandler = DocumentUtils.getFileAsDataHandler("data/test.docx");

		// Perform upload document
		String status = imageServer.upload(dataHandler);
		System.out.println("upload() : " + status);
	}
}
