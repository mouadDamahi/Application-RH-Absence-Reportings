package com.pepsi.rh.api;





import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.pepsi.rh.entities.Absences;
import com.pepsi.rh.entities.Blacklist;
import com.pepsi.rh.entities.Collaborateur;
import com.pepsi.rh.entities.Departs;
import com.pepsi.rh.entities.Discipline;
import com.pepsi.rh.repo.IAbsence;
import com.pepsi.rh.services.ExportPdfService;
import com.pepsi.rh.services.IService;


@CrossOrigin(origins = "*", allowedHeaders = "*") //DESKTOP-8CM1NR0:4200
@RestController
@RequestMapping("Collaborateur")
public class CollaborateurRest {

	@Autowired
	IService service;
	
	
	
	
	//Methodes For collaborateurs
	@PostMapping("/add")
	public ResponseEntity<Collaborateur> AddCollaborateur(@RequestBody Collaborateur c)
	{
		c=service.addcollaborateur(c);
		if(c!=null)
		return new ResponseEntity<>(c, HttpStatus.OK);
		else
			return new ResponseEntity<Collaborateur>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/allCollaborateurs")
	public List<Collaborateur> all(){
		return service.allcollaboraters();
	}
	
	@GetMapping("/oneCollaborateurs/{idc}")
	public ResponseEntity<Collaborateur> oneCollaborateurs(@PathVariable long idc)
	{
		Collaborateur c = service.findCollaborateur(idc);
		if(c!=null)
		return new ResponseEntity<Collaborateur>(c,HttpStatus.FOUND);
		else
		return new ResponseEntity<Collaborateur>(HttpStatus.NO_CONTENT);
		
	}
	
	
	
	
	//Methode for Absences
	@PostMapping("/Absence/{idc}")
	public Absences addAbsence(@RequestBody Absences ab,@PathVariable long idc)
	{
		
		return service.addAbsence(ab, idc);
	}
	@GetMapping("/Absence")
	public List<Absences> allAbsence() {
		return service.allAbsences();
	}
	
	@GetMapping("/Absencespage")
	public Page<Absences> allAbsences(@PathVariable @RequestParam  int page,@PathVariable @RequestParam int size){
		return service.allAbsence(page, size);
	}

	@DeleteMapping("/Absence/{id}")
	public ResponseEntity<Object> deleteAbsence(@PathVariable("id") long id)
	{
		if(service.findAbsence(id)!=null)
		{
			service.deleteAbsence(id);
			return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/Absence/{id}")
	public ResponseEntity<Absences> updateAbsences(@RequestBody Absences abs,@PathVariable long id) {
		if(service.findAbsence(id)!=null)
		{
			abs=service.updateAbsences(abs, id);
			return new ResponseEntity<Absences>(abs,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	 @GetMapping("/Absences")  
	 public String AbsencesPage() {
		 return "Absences";
	 }
	 
	 
	 //Methodes for Departs
	 @PostMapping("/Departs/{idc}")
	 public Departs addDeparts(@RequestBody Departs D,@PathVariable long idc)
		{
			return service.addDepart(D, idc);
		}
	 @GetMapping("/Departs")
	 public List<Departs> allDeparts() {
			return service.allDeparts();
		}
	 
	 
	 
	 //Collaborateur PDF
	 @GetMapping(value = "/exportpdfCollaborateurs", produces = MediaType.APPLICATION_PDF_VALUE)
	 public ResponseEntity<InputStreamResource> CollaborateursReports(){
		 	
			List<Collaborateur> ListCollaborateur = service.allcollaboraters();

			ByteArrayInputStream bis = ExportPdfService.ColllaboratruersReport(ListCollaborateur);

			HttpHeaders headers = new HttpHeaders();

			headers.add("Content-Disposition", "attachment;filename=Collaborateurs.pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
	 //for testing methodes periode
	 @GetMapping(value = "/exportpdfAbsencesP/{SPJ}/{SDJ}", produces = MediaType.APPLICATION_PDF_VALUE)
	 public List<Absences> allAbsenceP(@PathVariable String SPJ, @PathVariable String SDJ) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		 LocalDateTime PJ = LocalDateTime.parse(SPJ, formatter);
		 LocalDateTime DJ = LocalDateTime.parse(SDJ, formatter);
			return service.findAbsrncesPeriode(PJ,DJ);
		}
	 //Absence Pdf
	 @GetMapping(value = "/exportpdfAbsencesP", produces = MediaType.APPLICATION_PDF_VALUE)
	 public ResponseEntity<InputStreamResource> absencesReports(){
		 	
			List<Absences> absencesP = service.allAbsences();

			ByteArrayInputStream bis = ExportPdfService.AbsencesReport(absencesP);

			HttpHeaders headers = new HttpHeaders();

			headers.add("Content-Disposition", "attachment;filename=Absences.pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
	 //Departs PDF
	 @GetMapping(value = "/exportpdfDepartsP", produces = MediaType.APPLICATION_PDF_VALUE)
	 public ResponseEntity<InputStreamResource> departsReports(){
		 	
			List<Departs> DepartPeriode = service.allDeparts();

			ByteArrayInputStream bis = ExportPdfService.DepartsReport(DepartPeriode);

			HttpHeaders headers = new HttpHeaders();

			headers.add("Content-Disposition", "attachment;filename=Departs.pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
	 
	 
	 
	//Etat des profils PDF
	 @GetMapping(value = "/exportpdfprofilsP", produces = MediaType.APPLICATION_PDF_VALUE)
	 public ResponseEntity<InputStreamResource> etatProfileReports(){
		 	
			List<Collaborateur> etatProfilsPeriode = service.allcollaboraters();

			ByteArrayInputStream bis = ExportPdfService.profilsReport(etatProfilsPeriode);
			HttpHeaders headers = new HttpHeaders();

			headers.add("Content-Disposition", "attachment;filename=Etat de profils.pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
	 
	//Etat des recrutements PDF
	 @GetMapping(value = "/exportpdfRecrutementsP", produces = MediaType.APPLICATION_PDF_VALUE)
	 public ResponseEntity<InputStreamResource> etatRecrutementsReports(){
		 	
			List<Collaborateur> etatRecrutmentsPeriode = service.allcollaboraters();

			ByteArrayInputStream bis = ExportPdfService.recrutementsReport(etatRecrutmentsPeriode);
			HttpHeaders headers = new HttpHeaders();

			headers.add("Content-Disposition", "attachment;filename=Etat des recrutements.pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
	 
	//Etat discipline PDF
	 @GetMapping(value = "/exportpdfDisciplineP", produces = MediaType.APPLICATION_PDF_VALUE)
	 public ResponseEntity<InputStreamResource> etatDisciplineReports(){
		 	
			List<Discipline> etatDesciplinePeriode = service.allDiscipline();

			ByteArrayInputStream bis = ExportPdfService.disciplineReport(etatDesciplinePeriode);
			HttpHeaders headers = new HttpHeaders();

			headers.add("Content-Disposition", "attachment;filename=Etat discipline.pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
	
	//Black-List PDF
	 @GetMapping(value = "/exportpdfBlacklistP", produces = MediaType.APPLICATION_PDF_VALUE)
	 public ResponseEntity<InputStreamResource> blackListReports(){
		 	
			List<Blacklist> BlacklistPeriode = service.allCollaborateursBlacklist();

			ByteArrayInputStream bis = ExportPdfService.BlacklistReport(BlacklistPeriode);
			HttpHeaders headers = new HttpHeaders();

			headers.add("Content-Disposition", "attachment;filename=Black List.pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
	
	
	
}
