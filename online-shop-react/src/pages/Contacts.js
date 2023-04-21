import '../layout/css/Customers.css';
import { useTranslation } from 'react-i18next';

export default function Contacts() {
  const { t } = useTranslation();
    return (
      <div>
        <h1 style={{textAlign: "center"}}>{t('contact')}</h1>
        <ul>
        <h1>{t('vadcontacts')}</h1>
        <b2> </b2>
        <li>{t('vadnumber1')}</li>
        <b2> </b2>
        <li>{t('vadnumber2')}</li>
        <b2> </b2>
        <li>{t('vadelp')}</li>
        <b2> </b2>
        <li>{t('vademail')}</li>
        </ul>
        <ul>
        <h1>{t('intuž')}</h1>
        <b2> </b2>
        <li> {t('intužvadelp')}</li>
        <b2> </b2>
        <li> {t('intužvadtlf')}</li>
        </ul>
      
      </div>
    );
    
  }