/* (C)2021 */
package com.example.employee.commons.utils;

import com.example.employee.dto.PdfGeneratorDto;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@UtilityClass
public class PdfUtils {

	public <T extends PdfGeneratorDto> void generatePdf(List<T> dto, String fileName)
		throws FileNotFoundException {

		String destination = "src/main/resources/temp/" + fileName + ".pdf";
		PdfWriter writer = new PdfWriter(destination);
		PdfDocument pdfDoc = new PdfDocument(writer);
		// Creating a Document
		Document document = new Document(pdfDoc);

		// Adding new page
		pdfDoc.addNewPage();
		String para = "Employee List";
		Paragraph paragraph = new Paragraph(para);

		// Add para to pdf
		document.add(paragraph);

		Table t = generateTable(dto);
		document.add(t);

		document.close();
	}

	public void convertHtmlToPdf() throws IOException {
		HtmlConverter.convertToPdf(
			new File("src/main/resources/static/example.html"),
			new File("src/main/resources/temp/" + UUID.randomUUID().toString() + ".pdf"));
	}

	private <T extends PdfGeneratorDto> Table generateTable(List<T> dtos) {
		// Creating a table object
		float[] pointColumnWidths = {150F, 200F};
		Table table = new Table(pointColumnWidths);

		table.addCell("Id");
		table.addCell("Name");

		dtos.forEach(
			dto -> {
				table.addCell(new Cell().add(dto.getId().toString()));
				table.addCell(new Cell().add(dto.getLabel()));
			});
		return table;
	}
}
