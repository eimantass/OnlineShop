package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service

public class RecordService {
	 /*Logger logger = LoggerFactory.getLogger(KvitasService.class);

		
		@Autowired
		IrasasRepository kvitasRep;
		
		@Autowired
		PrekeRepository prekeRep;

		public List<KvitasDto> getAll() {
			// TODO Auto-generated method stub
			List<Kvitas> seniKvitai = kvitasRep.findAll();

			return seniKvitai.stream()
					.map(k -> new KvitasDto(k))
					.toList();
		}

		public void saveKvitas(KvitasDto kvitasDto) {
			logger.debug(kvitasDto.toString());
			logger.info("Gavome nauja kvita");
			List<Eilute> eilutes = new ArrayList<>();
			for (IrasasDto irasas : kvitasDto.getIrasai()) {
				if(irasas.getKiekis()<=0) 
					continue;
				
				Preke preke = prekeRep.findById(irasas.getId()).get();
				Eilute eilute = new Eilute(preke, irasas.getKiekis());
				eilutes.add(eilute);
			}
			Kvitas kvitas = new Kvitas(eilutes);
			kvitasRep.save(kvitas);
			logger.info(kvitasDto.toString());

		}
		*/
	}

