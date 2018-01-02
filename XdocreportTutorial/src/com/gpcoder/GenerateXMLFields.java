package com.gpcoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.gpcoder.model.Developer;
import com.gpcoder.model.Project;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

public class GenerateXMLFields {

	public static void main(String[] args) throws XDocReportException,IOException {
	
		// 1) Create FieldsMetadata by setting Velocity as template engine
		FieldsMetadata fieldsMetadata = new FieldsMetadata(TemplateEngineKind.Velocity.name());
			
		// 2) Load fields metadata from Java Class
		fieldsMetadata.load("project", Project.class);
		// Here load is called with true because model is a list of Developer.
		fieldsMetadata.load("developers", Developer.class, true);
		
		// 3) Generate XML fields in the file "project.fields.xml".
		// Extension *.fields.xml is very important to use it with MS Macro XDocReport.dotm
		// FieldsMetadata#saveXML is called with true to indent the XML.
		File xmlFieldsFile = new File("project.fields.xml");
		fieldsMetadata.saveXML(new FileOutputStream(xmlFieldsFile), true);
	}
}