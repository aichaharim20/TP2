package emsi.tp2.service;

import emsi.tp2.entities.Consultation;
import emsi.tp2.entities.Medecin;
import emsi.tp2.entities.Patient;
import emsi.tp2.entities.RendezVous;

public interface IHospitalService {
    public  Patient savePatient(Patient patient);
    public  Medecin saveMedecin(Medecin medecin);
    public  RendezVous saveRendezVous(RendezVous rendezVous);
    public  Consultation saveConsultation(Consultation consultation);

}
