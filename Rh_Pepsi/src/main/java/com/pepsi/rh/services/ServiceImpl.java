package com.pepsi.rh.services;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.pepsi.rh.entities.Absences;
import com.pepsi.rh.entities.Blacklist;
import com.pepsi.rh.entities.Collaborateur;
import com.pepsi.rh.entities.Departs;
import com.pepsi.rh.entities.Discipline;
import com.pepsi.rh.entities.Experience;
import com.pepsi.rh.entities.Fonction;
import com.pepsi.rh.entities.Mission;
import com.pepsi.rh.repo.IAbsence;
import com.pepsi.rh.repo.IBlacklist;
import com.pepsi.rh.repo.ICollaborateur;
import com.pepsi.rh.repo.IDepart;
import com.pepsi.rh.repo.IDiscipline;
import com.pepsi.rh.repo.IExperience;
import com.pepsi.rh.repo.IFonction;
import com.pepsi.rh.repo.IMission;

import lombok.NoArgsConstructor;



@Component
@Service
@NoArgsConstructor
public class ServiceImpl implements IService{

	@Autowired
	ICollaborateur crepo;
	@Autowired
	IAbsence arepo;
	@Autowired
	IDepart Drepo;
	@Autowired
	IBlacklist Brepo;
	@Autowired
	IExperience Erepo;
	@Autowired
	IFonction Frepo;
	@Autowired
	IDiscipline Disrepo;
	@Autowired
	IMission Mrepo;
	
	@Override
	public Collaborateur addcollaborateur(Collaborateur c) {
		Collaborateur C=crepo.save(c);
		return C;
	}

	@Override
	public Collaborateur findCollaborateur(long id) {
		
		Optional<Collaborateur> o = crepo.findById(id);
		if(o.isPresent())
		return o.get();
		else
			return null;
		
	}

	@Override
	public List<Collaborateur> allcollaboraters() {
		return crepo.findAll();
	}

	@Override
	public Absences addAbsence(Absences a, long idc) {
		Collaborateur c = crepo.findById(idc).get();
		//c.getAbsences().add(a);
		a.setCollaborateur(c);
		a=arepo.save(a);
		return a;
	}
	@Override
	public List<Absences> allAbsences() {
		return arepo.findAll();
	}
	

	public Absences findAbsence(long id) {
		Optional<Absences> o = arepo.findById(id);
		if(o.isPresent())
		return o.get();
		else
			return null;
		
	}


	public void deleteAbsence(long id){
			arepo.deleteById(id);
	}

	@Override
	public Page<Absences> allAbsence(int page, int size) {
		Pageable pageable=PageRequest.of(page, size);
		return arepo.findAll(pageable);
	}
	public Absences updateAbsences(Absences abs,Long id ) {
		Absences absenceFromDb = findAbsence(id);
		 
		absenceFromDb.setTypeAbs(abs.getTypeAbs());
		absenceFromDb.setNombreJ(abs.getNombreJ());
		absenceFromDb.setResponsable(abs.getResponsable());
		absenceFromDb.setCollaborateur(abs.getCollaborateur());
		absenceFromDb.setMatinorApresMidiDJ(abs.getMatinorApresMidiDJ());
		absenceFromDb.setMatinorApresMidiPJ(abs.getMatinorApresMidiPJ());
		absenceFromDb.setCreatedDate(abs.getCreatedDate());
		absenceFromDb.setDatePremierJ(abs.getDatePremierJ());
		absenceFromDb.setDateDernierJ(abs.getDateDernierJ());
		absenceFromDb.setDateRetour(abs.getDateRetour());
		absenceFromDb.setFile(abs.getFile());
		absenceFromDb.setCommentaire(abs.getCommentaire());
		abs=arepo.save(absenceFromDb);
		return abs;
	}
	
	public List<Departs> allDeparts(){
		return Drepo.findAll();
	}
	@Override
	public Departs addDepart(Departs D, long idc) {
		Collaborateur c = crepo.findById(idc).get();
		//c.getAbsences().add(a);
		D.setCollaborateur(c);
		D=Drepo.save(D);
		return D;
	}
	
	
	

	@Override
	public Blacklist addCollaborateurBlacklist(Blacklist B, long idc) {
		Collaborateur c = crepo.findById(idc).get();
		//c.getAbsences().add(a);
		B.setCollaborateur(c);
		B=Brepo.save(B);
		return B;
	}

	@Override
	public List<Blacklist> allCollaborateursBlacklist() {
		return Brepo.findAll();
	}

	@Override
	public Experience addExperienceCollaborateur(Experience E, long idc) {
		Collaborateur c = crepo.findById(idc).get();
		//c.getAbsences().add(a);
		E.setCollaborateur(c);
		E=Erepo.save(E);
		return E;
	}

	@Override
	public List<Experience> allExperienceCollaborateurs() {
		return Erepo.findAll();
	}

	@Override
	public Fonction addFonctionCollaborateur(Fonction F, long idc) {
		Collaborateur c = crepo.findById(idc).get();
		//c.getAbsences().add(a);
		F.setCollaborateur(c);
		F=Frepo.save(F);
		return F;
	}

	@Override
	public List<Fonction> allFonctionCollaborateurs() {
		return Frepo.findAll();
	}

	@Override
	public Mission addMissionCollaborateur(Mission M, long idc) {
		Collaborateur c = crepo.findById(idc).get();
		//c.getAbsences().add(a);
		M.setCollaborateur(c);
		M=Mrepo.save(M);
		return M;
	}

	@Override
	public List<Mission> allMissionCollaborateurs() {
		return Mrepo.findAll();
	}
	
	@Override
	public List<Absences> findAbsrncesPeriode(LocalDateTime PJ, LocalDateTime DJ) {
		List<Absences> AllAbsences = arepo.findAll();
		List<Absences> absencesPeriode =null;
		for(Absences abs : AllAbsences) {
			//int Date1= abs.getDatePremierJ().compareTo(PJ);
			//int Date2= abs.getDateDernierJ().compareTo(DJ);
			if(abs.getDatePremierJ().equals(PJ) && abs.getDateDernierJ().equals(DJ)) {
				absencesPeriode.add(abs);
				
			}
			
		}
		return absencesPeriode;
		
	}

	@Override
	public Discipline addDiscipline(Discipline D, long idc) {
		Collaborateur c = crepo.findById(idc).get();
		//c.getAbsences().add(a);
		D.setCollaborateur(c);
		D=Disrepo.save(D);
		return D;
	}

	@Override
	public List<Discipline> allDiscipline() {
		return Disrepo.findAll();
	}

	
	
}
