package com.gpcoder.ws.document;

import javax.activation.DataHandler;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService(endpointInterface = "com.gpcoder.ws.document.DocumentService")
public class DocumentServiceImpl implements DocumentService {

	public static final String UPLOADED_FOLDER = "data/upload/";

	@Override
	public DataHandler download(String name) {
		return DocumentUtils.getFileAsDataHandler("data/" + name);
	}

	@Override
	public String upload(DataHandler dataHandler) {
		if (dataHandler != null) {
			String fileName = UPLOADED_FOLDER + "upload-" + System.currentTimeMillis() + ".docx";
			DocumentUtils.storeDataToFile(dataHandler, fileName);
			return "Uploaded Successful with name " + fileName;
		}
		throw new WebServiceException("Upload Failed!");
	}
}
