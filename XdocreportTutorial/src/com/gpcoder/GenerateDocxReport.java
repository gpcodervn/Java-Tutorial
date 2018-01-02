package com.gpcoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.gpcoder.model.Developer;
import com.gpcoder.model.Project;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

public class GenerateDocxReport {
	public static void main(String[] args) throws IOException, XDocReportException {
		// 1) Load Docx file by filling Velocity template engine and cache it to the registry
		InputStream in = new FileInputStream("template/Project.docx");
		IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

		// 2) Create fields metadata to manage lazy loop (#forech velocity) for table row.
		// Create FieldsMetadata by setting Velocity as template engine
		FieldsMetadata fieldsMetadata = report.createFieldsMetadata();
		// Load fields metadata from Java Class
		fieldsMetadata.load("project", Project.class);
		// Load is called with true because model is a list of Developer.
		fieldsMetadata.load("developers", Developer.class, true);

		// 3) Create context Java model
		IContext context = report.createContext();
		Project project = new Project("XDocReport");
		context.put("project", project);
		// Register developers list
		context.put("developers", getDevelopers());

		// 4) Generate report by merging Java model with the Docx
		OutputStream out = new FileOutputStream(new File("Project_out.docx"));
		report.process(context, out);

	}
	
	private static List<Developer> getDevelopers(){
		List<Developer> developers = new ArrayList<>();
		developers.add(new Developer("Giang", "Phan", "gpcoder@gmail.com"));
		developers.add(new Developer("ZERR", "Angelo", "angelo.zerr@gmail.com"));
		return developers;
	}
}
