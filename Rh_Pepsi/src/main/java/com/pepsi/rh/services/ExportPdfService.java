package com.pepsi.rh.services;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;


import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.pepsi.rh.entities.Absences;
import com.pepsi.rh.entities.Blacklist;
import com.pepsi.rh.entities.Collaborateur;
import com.pepsi.rh.entities.Departs;
import com.pepsi.rh.entities.Discipline;

public class ExportPdfService {
			
	//Collaborateurs PDF
	public static ByteArrayInputStream ColllaboratruersReport(List<Collaborateur> collaborateurs) {
		
		Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,6);
		Font bodyFont = FontFactory.getFont(FontFactory.COURIER_BOLD,6);
		
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			PdfWriter.getInstance(document, out);
			document.open();
			
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14,Color.blue);
			Paragraph para = new Paragraph("Etat du personnel ",font);
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			document.add(Chunk.NEWLINE);
			
			
			
			
			PdfPTable table = new PdfPTable(12);
			table.setWidthPercentage(110);
			table.setWidths(new int[] {2,4,4,4,4,5,3,5,5,8,6,8});

			
			PdfPCell hcell;
			
			
			hcell = new PdfPCell(new Phrase("id", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			
			
			hcell = new PdfPCell(new Phrase("Nom", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Prenom", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("N°CIN", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("N°CNSS", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Date de naissence ", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Sexe", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Situation", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Date de recrutement", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Adresse", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("N°telephone", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Email", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);

			for (Collaborateur coll : collaborateurs) {
				
				PdfPCell cell;
				
				cell = new PdfPCell(new Phrase(String.valueOf(coll.getId()),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(coll.getNom(),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(coll.getPrenom(),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(coll.getCin(),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(coll.getNcnss(),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//cell.setPaddingRight(5);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(coll.getDate_borth()), bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//cell.setPaddingRight(5);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(coll.getSexe()),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//cell.setPaddingRight(5);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(coll.getSituation()),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//cell.setPaddingRight(5);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(coll.getDate_recrut()),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//cell.setPaddingRight(5);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(coll.getAdresse(),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//cell.setPaddingRight(5);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(coll.getTel(), bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//cell.setPaddingRight(5);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(coll.getEmail(), bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//cell.setPaddingRight(5);
				table.addCell(cell);
			}

			document.add(table);
			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}
	
	//Absence PDF
	public static ByteArrayInputStream AbsencesReport(List<Absences> absences) {

		
		Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,6);
		Font bodyFont = FontFactory.getFont(FontFactory.COURIER_BOLD,6);
		
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			PdfWriter.getInstance(document, out);
			document.open();
			
			Font pfont = FontFactory.getFont(FontFactory.COURIER_BOLD ,14,Color.blue);
			Paragraph para = new Paragraph("Absence pendant une période",pfont);
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			document.add(Chunk.NEWLINE);
			
			
			
			
			PdfPTable table = new PdfPTable(9);
			table.setWidthPercentage(110);
			table.setWidths(new int[] {8,9,8,8,8,8,3,8,8});
			
			
			
			PdfPCell hcell;
			
			hcell = new PdfPCell(new Phrase("Nom et Prenom", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("type Absence", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("created Date", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("date Premier Jour", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			
			
			hcell = new PdfPCell(new Phrase("date Dernier Jour", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("date Retour", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("N°Jours", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("responsable", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("commentaire", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			

			for (Absences absence : absences) {
				
				PdfPCell cell;
				
				cell = new PdfPCell(new Phrase(String.valueOf(absence.Collaborateur().getNom()+" "+absence.Collaborateur().getPrenom()),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(absence.getTypeAbs().name(),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(absence.getCreatedDate()),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(absence.getDatePremierJ()+" "+ absence.getMatinorApresMidiPJ()),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(absence.getDateDernierJ()+" "+absence.getMatinorApresMidiDJ()),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//cell.setPaddingRight(5);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(absence.getDateRetour()),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//cell.setPaddingRight(5);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(absence.getNombreJ()),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//cell.setPaddingRight(5);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(absence.getResponsable(),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//cell.setPaddingRight(5);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(absence.getCommentaire(),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//cell.setPaddingRight(5);
				table.addCell(cell);
			}

			document.add(table);
			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}
	
	//Departs PDF
	public static ByteArrayInputStream DepartsReport(List<Departs> Departs) {

		
		Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,8);
		Font bodyFont = FontFactory.getFont(FontFactory.COURIER_BOLD,8);
		
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			PdfWriter.getInstance(document, out);
			document.open();
			
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14,Color.blue);
			Paragraph para = new Paragraph(" Etat des départs",font);
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			document.add(Chunk.NEWLINE);
			
			
			
			
			PdfPTable table = new PdfPTable(6);
			table.setWidthPercentage(100);
			table.setWidths(new int[] {1,1,1,2,2,4});

			
			PdfPCell hcell;
			
			
			hcell = new PdfPCell(new Phrase("N°CIN", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			
			
			hcell = new PdfPCell(new Phrase("Nom", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Prenom", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Date de recrutement", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Date de depart", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Motif", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			for (Departs dep : Departs ) {
				
				PdfPCell cell;
				
				cell = new PdfPCell(new Phrase(dep.Collaborateur().getCin(),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(dep.Collaborateur().getNom(),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(dep.Collaborateur().getPrenom(),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(dep.Collaborateur().getDate_recrut()),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(dep.getDate()),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(dep.getMotif(),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			}

			document.add(table);
			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}
	
	//Etat des profils
	public static ByteArrayInputStream profilsReport(List<Collaborateur> Coll) {

		
		Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,8);
		Font bodyFont = FontFactory.getFont(FontFactory.COURIER_BOLD,8);
		
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			PdfWriter.getInstance(document, out);
			document.open();
			
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14,Color.blue);
			Paragraph para = new Paragraph("Etat des profils",font);
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			document.add(Chunk.NEWLINE);
			
			
			
			
			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(100);
			table.setWidths(new int[] {1,1,1,4,4});

			
			PdfPCell hcell;
			
			
			hcell = new PdfPCell(new Phrase("N°CIN", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			
			
			hcell = new PdfPCell(new Phrase("Nom", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Prenom", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Experiences", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Diplomes", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);

			
			for (Collaborateur C : Coll ) {
				
				PdfPCell cell;
				
				cell = new PdfPCell(new Phrase(C.getCin(),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(C.getNom(),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(C.getPrenom(),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(C.ExperienceByCollaborateur().toString(),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(C.DiplomesByCollaborateur().toString(),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
			}

			document.add(table);
			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

	//Etat des recrutements :
	public static ByteArrayInputStream recrutementsReport(List<Collaborateur> Coll) {

	
	Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,8);
	Font bodyFont = FontFactory.getFont(FontFactory.COURIER_BOLD,8);
	
	Document document = new Document();
	ByteArrayOutputStream out = new ByteArrayOutputStream();

	try {
		PdfWriter.getInstance(document, out);
		document.open();
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14,Color.blue);
		Paragraph para = new Paragraph("Etat des recrutements",font);
		para.setAlignment(Element.ALIGN_CENTER);
		document.add(para);
		document.add(Chunk.NEWLINE);
		
		
		
		
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100);
		table.setWidths(new int[] {1,1,1,4,4});

		
		PdfPCell hcell;
		
		
		hcell = new PdfPCell(new Phrase("N°CIN", headFont));
		hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		hcell.setBackgroundColor(Color.blue);
		table.addCell(hcell);
		
		
		
		hcell = new PdfPCell(new Phrase("Nom", headFont));
		hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		hcell.setBackgroundColor(Color.blue);
		table.addCell(hcell);
		
		hcell = new PdfPCell(new Phrase("Prenom", headFont));
		hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		hcell.setBackgroundColor(Color.blue);
		table.addCell(hcell);
		
		hcell = new PdfPCell(new Phrase("Date de recrutements", headFont));
		hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		hcell.setBackgroundColor(Color.blue);
		table.addCell(hcell);
		

		
		for (Collaborateur C : Coll ) {
			
			PdfPCell cell;
			
			cell = new PdfPCell(new Phrase(C.getCin(),bodyFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(C.getNom(),bodyFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(C.getPrenom(),bodyFont));
			//cell.setPaddingLeft(5);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf(C.getDate_recrut()),bodyFont));
			//cell.setPaddingLeft(5);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			
		}

		document.add(table);
		document.close();

	} catch (DocumentException ex) {

	}

	return new ByteArrayInputStream(out.toByteArray());
}

	//Etat discipline 
	public static ByteArrayInputStream disciplineReport(List<Discipline> discipline) {

		
		Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,8);
		Font bodyFont = FontFactory.getFont(FontFactory.COURIER_BOLD,8);
		
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			PdfWriter.getInstance(document, out);
			document.open();
			
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14,Color.blue);
			Paragraph para = new Paragraph("Etat dicipline ",font);
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			document.add(Chunk.NEWLINE);
			
			
			
			
			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(100);
			table.setWidths(new int[] {1,1,1,4,2});

			
			PdfPCell hcell;
			
			
			hcell = new PdfPCell(new Phrase("N°CIN", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Nom", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Prenom", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Avertissement", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Date de avertissement", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			

			
			for (Discipline D : discipline ) {
				
				PdfPCell cell;
				
				cell = new PdfPCell(new Phrase(D.Collaborateur().getCin(),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(D.Collaborateur().getNom(),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(D.Collaborateur().getPrenom(),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(D.getAvertissement(),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(D.getDate()),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
			}

			document.add(table);
			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

	//Black-List
	public static ByteArrayInputStream BlacklistReport(List<Blacklist> blacklist) {

		
		Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,8);
		Font bodyFont = FontFactory.getFont(FontFactory.COURIER_BOLD,8);
		
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			PdfWriter.getInstance(document, out);
			document.open();
			
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14,Color.blue);
			Paragraph para = new Paragraph("Etat Black-list ",font);
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			document.add(Chunk.NEWLINE);
			
			
			
			
			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(100);
			table.setWidths(new int[] {1,1,1,4,2});

			
			PdfPCell hcell;
			
			
			hcell = new PdfPCell(new Phrase("N°CIN", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Nom", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Prenom", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Motif", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Date", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(Color.blue);
			table.addCell(hcell);
			

			
			for (Blacklist B : blacklist ) {
				
				PdfPCell cell;
				
				cell = new PdfPCell(new Phrase(B.Collaborateur().getCin(),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(B.Collaborateur().getNom(),bodyFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(B.Collaborateur().getPrenom(),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(B.getMotif(),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(B.getDate()),bodyFont));
				//cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
			}

			document.add(table);
			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

}

