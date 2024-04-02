package emsi.tp2.service;

import emsi.tp2.entities.Consultation;
import emsi.tp2.entities.Medecin;
import emsi.tp2.entities.Patient;
import emsi.tp2.entities.RendezVous;
import emsi.tp2.repository.ConsultationRepository;
import emsi.tp2.repository.MedecinRepository;
import emsi.tp2.repository.PatientRepository;
import emsi.tp2.repository.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service //Les objets de la couche métier utilise l'annotation service
@Transactional  // tous les opérations métier sont des opérations transactionnal.
public class IHospitalServiceImpl implements IHospitalService{
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository,
                                MedecinRepository medecinRepository,
                                RendezVousRepository rendezVousRepository,
                                ConsultationRepository consultationRepository) {

        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
