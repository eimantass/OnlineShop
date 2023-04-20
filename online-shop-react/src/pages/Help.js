import '../layout/css/Customers.css';
import { useTranslation } from 'react-i18next';

export default function Help() {
  const { t } = useTranslation();
    return (
      <div>
        <ul>
        <h1 style={{textAlign: "center"}}>{t('help')}</h1>
        <h1>Pagalba telefonu</h1>
        <b2> </b2>
        <li>+370-472-84596 - pagalba prekių klausimais, lizingo sudarymo klausimais.</li>
        <b2> </b2>
        <li>+370-472-84597 - pagalba el. parduotuves užsakymų klausimais.</li>
        <b2> </b2>
        <li>+370-472-84598 - pagalba garantinio ir pogarantinio aptarnavimo klausimais. Stacionariu ir nešiojamų kompiuterių atnaujinimas, servisas.</li>
        <b2> </b2>
        <li>+370-472-84599 - pagalba viešujų prikimų klausimais.</li>
        <b2> </b2>
        <li>+370-472-84600 - "Vietos" parduotuves ir bendri klausimai</li>
        </ul>
        <ul>
        <h1>Pagalba el.paštu</h1>
        <b2> </b2>
        <li>email: "Email"</li>
        </ul>
      </div>
    );
    
  }