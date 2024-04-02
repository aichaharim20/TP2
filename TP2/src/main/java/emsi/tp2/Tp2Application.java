package emsi.tp2;

import emsi.tp2.entities.*;
import emsi.tp2.repository.*;
import emsi.tp2.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp2Application /*implements CommandLineRunner*/ {
    @Autowired
    private productRepository iproduct;


    public static void main(String[] args) {

        SpringApplication.run(Tp2Application.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService HospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository)
    {
        return args -> {
            Stream.of("Badr","Hamid","Said")
                    .forEach(name->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        HospitalService.savePatient(patient);
                    });
                Stream.of("DR.Badr","DR.Hamid","DR.Said")
                    .forEach(name->{
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        HospitalService.saveMedecin(medecin);
                    });
                RendezVous rendezVous=new RendezVous();
                rendezVous.setDate(new Date());
                rendezVous.setStatus(StatusRDV.PENDING);
                Patient patient=patientRepository.findById(1L).orElse(null);
                Patient patient1 =patientRepository.findByNom("Badr");
                Medecin medecin=medecinRepository.findByNom("DR.Badr");
                rendezVous.setMedecin(medecin);
                rendezVous.setPatient(patient);

            RendezVous savedRDV = HospitalService.saveRendezVous(rendezVous);
            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
            System.out.println(rendezVous1.getId());
                Consultation consultation = new Consultation();
                consultation.setDateConsultation(new Date());
                consultation.setRendezVous(rendezVous1);
                consultation.setRapport("Rapport de la consultation ....");
                HospitalService.saveConsultation(consultation);
        };

    }
   /* @Override
    public void run(String... args) throws Exception {
        iproduct.save(new Product(null,"Ananas",500,100));
        iproduct.save(new Product(null,"Fraise",750,80));
        iproduct.save(new Product(null,"Pomme",1500,110));
        List<Product> productsList = iproduct.chercherProduits(100,70);
        List <Product> products = iproduct.findAll();
        productsList.forEach(p->{
                    System.out.println("----------------------------------------------------");
                    System.out.println(p.getId());
                    System.out.println(p.getName());
                    System.out.println(p.getPrice());
                    System.out.println(p.getQuantity());
                }
        );
        Product p = iproduct.findById(3L).orElse(null);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(p.getId()+"*********"+p.getPrice()+"*********"+p.getName()+"*********"+p.getQuantity());
        p.setQuantity(10);
        iproduct.save(p);
    }*/

}
