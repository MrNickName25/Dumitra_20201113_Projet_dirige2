package docs;

import java.awt.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

import vulnerabilities.Logiciel;
import vulnerabilities.Menace;
import vulnerabilities.Solution;
import vulnerabilities.ModelLogiciel;
import vulnerabilities.ModelMenace;
import vulnerabilities.ModelSolution;

@WebServlet("/BulletinPDF")
public class GenPdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GenPdf() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("application/pdf");
		PdfDocument doc;
		try {
			PdfWriter writer=new PdfWriter(response.getOutputStream());
			doc=new PdfDocument(writer);
			PdfPage page=doc.addNewPage();
			PdfCanvas canvas= new PdfCanvas(page);
			FontProgram fontProgram=FontProgramFactory.createFont();
			PdfFont font = PdfFontFactory.createFont(fontProgram, "UTF-8", true);
			canvas.beginText();
			
			String codestringv=request.getParameter("id_index_vulnerabilite");
			Long codelongv=Long.parseLong(codestringv);
			
			String codestringl=request.getParameter("id_index_logiciel");
			Long codelongl=Long.parseLong(codestringl);
			
			ModelMenace m=new ModelMenace();
			ArrayList<Menace> listem =m.versCollection(codelongv);
			
			ModelLogiciel l=new ModelLogiciel();
			ArrayList<Logiciel> listel =l.versCollection(codelongv);
			
			ModelSolution s=new ModelSolution();
			ArrayList<Solution> listes =s.versCollection(codelongl, codelongv);
			
			int start=842;
			int space=20;
			int inline;
			inline=start-space;
			
			for (Menace men: listem) {			
				canvas.setTextMatrix(10, inline);inline=inline-space;
				canvas.setFontAndSize(font, 18);
					canvas.newlineShowText("Synthese");
				canvas.setTextMatrix(10, inline);inline=inline-space;
				canvas.setFontAndSize(font, 16);
				canvas.showText(men.getSynthese_vulnerabilite());
				
				canvas.setTextMatrix(10, inline);inline=inline-space;
				canvas.setFontAndSize(font, 18);
					canvas.newlineShowText("Description");
				canvas.setTextMatrix(10, inline);inline=inline-space;
				canvas.setFontAndSize(font, 10);
				canvas.showText(men.getDescription_vulnerabilite());
				
				canvas.setTextMatrix(10, inline);inline=inline-space;
				canvas.setFontAndSize(font, 18);
					canvas.newlineShowText("Niveau de gravite: ["+men.getNiv_gravite()+"] sur 4!");
				
				canvas.setTextMatrix(10, inline);inline=inline-space;
				canvas.setFontAndSize(font, 18);
					canvas.newlineShowText("Source");
				canvas.setTextMatrix(10, inline);inline=inline-space;
				canvas.setFontAndSize(font, 10);
				canvas.showText(men.getUrl_source());
				
				canvas.setTextMatrix(10, inline);inline=inline-space;
				canvas.setFontAndSize(font, 10);
				canvas.showText("--------------------------------------------");
				
					for (Logiciel log: listel) {
						canvas.setTextMatrix(20, inline);inline=inline-space;
						canvas.setFontAndSize(font, 18);
							canvas.newlineShowText("Logiciel");
							canvas.setTextMatrix(20, inline);inline=inline-space;
						canvas.setFontAndSize(font, 10);
						canvas.showText(log.getNom_logiciel());
						
						canvas.setTextMatrix(20, inline);inline=inline-space;
						canvas.setFontAndSize(font, 14);
							canvas.newlineShowText("Version");
							canvas.setTextMatrix(20, inline);inline=inline-space;
							canvas.setFontAndSize(font, 10);
							canvas.showText(log.getVersion_logiciel());
									
								for (vulnerabilities.Solution sol: listes) {
									canvas.setTextMatrix(40, inline);inline=inline-space;
									canvas.setFontAndSize(font, 14);
										canvas.newlineShowText("Solution");
										
									canvas.setTextMatrix(40, inline);inline=inline-space;
									canvas.setFontAndSize(font, 10);
									canvas.showText(sol.getDescription_solution());
									
									canvas.setTextMatrix(40, inline);inline=inline-space;
									canvas.setFontAndSize(font, 10);
									canvas.showText("--------------------------------------------");
								}
					}		
					
			}
			canvas.endText();
			
		} catch (Exception de) {throw new ServletException(de);}
		
		doc.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
