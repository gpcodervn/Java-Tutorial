package com.gpcoder.xdocreport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

public class GenerateDocxReport {
	public static void main(String[] args) throws IOException, XDocReportException {
		// 1) Load Docx file by filling Velocity template engine and cache it to the registry
		InputStream in = GenerateDocxReport.class.getResourceAsStream("project.docx");
		IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

		// 2) Create fields metadata to manage lazy loop (#forech velocity) for table row.
		// 1) Create FieldsMetadata by setting Velocity as template engine
		FieldsMetadata fieldsMetadata = report.createFieldsMetadata();
		// 2) Load fields metadata from Java Class
		fieldsMetadata.load("project", Project.class);
		// Here load is called with true because model is a list of Developer.
		fieldsMetadata.load("developers", Developer.class, true);

		// 3) Create context Java model
		IContext context = report.createContext();
		Project project = new Project("XDocReport");
		context.put("project", project);
		// Register developers list
		List<Developer> developers = new ArrayList<Developer>();
		developers.add(new Developer("Giang", "Phan", "gpcoder@gmail.com"));
		developers.add(new Developer("ZERR", "Angelo", "angelo.zerr@gmail.com"));
		context.put("developers", developers);

		// 4) Generate report by merging Java model with the Docx
		OutputStream out = new FileOutputStream(new File("project_out.docx"));
		report.process(context, out);

	}
}
