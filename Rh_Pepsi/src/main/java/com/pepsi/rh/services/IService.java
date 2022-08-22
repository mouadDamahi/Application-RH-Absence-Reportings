package com.pepsi.rh.services;




import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;


import com.pepsi.rh.entities.Absences;
import com.pepsi.rh.entities.Blacklist;
import com.pepsi.rh.entities.Collaborateur;
import com.pepsi.rh.entities.Departs;
import com.pepsi.rh.entities.Discipline;
import com.pepsi.rh.entities.Experience;
import com.pepsi.rh.entities.Fonction;
import com.pepsi.rh.entities.Mission;

public interface IService {

	
	public Collaborateur addcollaborateur(Collaborateur c);
	public Collaborateur findCollaborateur(long idc);
	public List<Collaborateur> allcollaboraters();
	public Absences addAbsence(Absences a, long idc);
	public Absences findAbsence(long id);
	public Page<Absences> allAbsence(int page, int size);
	public Absences updateAbsences(Absences abs,Long id );
	public List<Absences> allAbsences();
	public void deleteAbsence(long id);
	public List<Absences> findAbsrncesPeriode(LocalDateTime PJ,LocalDateTime DJ);
	public List<Departs> allDeparts();
	public Departs addDepart(Departs D, long idc);
	public Discipline addDiscipline(Discipline D, long idc);
	public List<Discipline> allDiscipline();
	public Blacklist addCollaborateurBlacklist(Blacklist B, long idc);
	public List<Blacklist> allCollaborateursBlacklist();
	public Experience addExperienceCollaborateur(Experience E, long idc);
	public List<Experience> allExperienceCollaborateurs();
	public Fonction addFonctionCollaborateur(Fonction F, long idc);
	public List<Fonction> allFonctionCollaborateurs();
	public Mission addMissionCollaborateur(Mission M, long idc);
	public List<Mission> allMissionCollaborateurs();
}
